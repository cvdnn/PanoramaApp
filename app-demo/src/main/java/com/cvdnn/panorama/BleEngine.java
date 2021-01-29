package com.cvdnn.panorama;

import android.assist.Assert;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_NOTIFY;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_READ;
import static android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

public class BleEngine {
    public static final String TAG = "BleWrap";

    public static final String UUID_GATT_SERVICE = "00001910-0000-1000-8000-00805f9b34fb";
    public static final String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";

    private static final UUID UUID_SEND_CHARACTERISTIC = UUID.fromString("0000fff1-0000-1000-8000-00805f9b34fb");
    private static final UUID UUID_RECEIVE_CHARACTERISTIC = UUID.fromString("0000fff4-0000-1000-8000-00805f9b34fb");

    public static final int BT_IDLE_MILLIS = 300;

    private static final int LEN_BT_POC = 17;
    public static final byte FLAG_START_MOTION = 1, FLAG_END_MOTION = 2;

    public static final byte FLAG_REQUEST = 1, FLAG_RESPONSE = 2;

    private static final int INDEX_CLIENT = 1;
    private static final int INDEX_STATE = 10;

    private static final byte[] RESPONSE_CHARACTERISTIC = {0, 0, 0, 0};

    public enum SpinType {
        STOP(0x00, 0),
        SPINFF(0b1010_0000, 1),
        SPIN01(0b0100_0000, 1),
        SPIN02(0b0010_0000, 2),
        SPIN04(0b0001_0000, 4),
        SPIN09(0b0000_1000, 9),
        /** 拍摄18张照片 */
        SPIN18(0b0000_0100, 18),
        /** 拍摄36张照片 */
        SPIN36(0b0000_0010, 36),
        /** 拍摄72张照片 */
        SPIN72(0b0000_0001, 72),
        SPIN50000(0b1000_0000, 50_000),
        SPIN60000(0b1001_0000, 60_000),
        SPIN80000(0b1100_0000, 80_000),
        SPIN90000(0b1110_0000, 90_000);

        /** 操作类型 */
        public byte type;
        /** 拍摄照片数 */
        public int num;

        SpinType(int t, int n) {
            type = (byte) t;
            num = n;
        }
    }

    public static final BluetoothGattService findGattService(BluetoothGatt gatt) {
        BluetoothGattService service = null;

        if (gatt != null) {
            List<BluetoothGattService> bgsList = gatt.getServices();
            if (Assert.notEmpty(bgsList)) {
                for (BluetoothGattService gattService : bgsList) {
                    String uuid = gattService.getUuid().toString();
                    if (UUID_GATT_SERVICE.equalsIgnoreCase(uuid)) {
                        service = gattService;
                        break;
                    }
                }
            }

        }

        return service;
    }

    public static BluetoothGattCharacteristic findSendCharacteristic(BluetoothGattService service) {
        return service != null ? service.getCharacteristic(UUID_SEND_CHARACTERISTIC) : null;
    }

    public static BluetoothGattCharacteristic findReceiveCharacteristic(BluetoothGattService service) {
        return service != null ? service.getCharacteristic(UUID_RECEIVE_CHARACTERISTIC) : null;
    }

    /**
     * Reads the requested characteristic from the associated remote device.
     * The result of the read operation is reported by the onCharacteristicRead() callback.
     *
     * @param gatt
     * @param characteristic
     *
     * @return
     */
    public static boolean readCharacteristic(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        boolean result = false;

        if (characteristic != null) {
            final int charaProp = characteristic.getProperties();
            if (Assert.as(charaProp, PROPERTY_READ) && gatt != null) {
                result = gatt.readCharacteristic(characteristic);
            }
        }

        return result;
    }

    /**
     * Enables or disables notification on a give characteristic.
     *
     * @param characteristic Characteristic to act on.
     * @param enabled        If true, enable notification.  False otherwise.
     */
    public static boolean setCharacteristicNotification(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, boolean enabled) {
        boolean result = false;
        if (gatt != null && characteristic != null) {
            final int charaProp = characteristic.getProperties();
            if ((charaProp | PROPERTY_NOTIFY) > 0) {
                result = gatt.setCharacteristicNotification(characteristic, enabled);

                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(UUID.fromString(CLIENT_CHARACTERISTIC_CONFIG));
                if (descriptor != null) {
                    descriptor.setValue(ENABLE_NOTIFICATION_VALUE);
                    gatt.writeDescriptor(descriptor);
                }
            }
        }

        return result;
    }

    public static boolean takeAround(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, SpinType stye) {
        boolean result = false;

        if (characteristic != null && gatt != null) {
            characteristic.setValue(makeCtlBytes(stye));
            result = gatt.writeCharacteristic(characteristic);
        }

        return result;
    }

    private static byte[] makeCtlBytes(SpinType spinType) {
        byte[] bytes = new byte[17];

        bytes[0] = 17;
        bytes[1] = FLAG_REQUEST;
        bytes[2] = 0;
        bytes[3] = 0;
        bytes[4] = 0;
        bytes[5] = 7;
        bytes[6] = spinType.type;
        bytes[7] = 0;
        bytes[8] = 0;
        bytes[9] = 0;
        bytes[10] = 0;
        bytes[11] = 0;
        bytes[12] = 0;
        bytes[13] = 0;
        bytes[14] = 0;
        bytes[15] = 13;
        bytes[16] = 10;

        return bytes;
    }

    public static byte getState(byte[] bytes) {
        return valueOf(bytes, INDEX_STATE);
    }

    public static boolean asResponse(byte[] bytes) {
        return as(bytes, INDEX_CLIENT, FLAG_RESPONSE);
    }

    public static boolean checkResponse(byte[] bytes) {
        return Arrays.equals(RESPONSE_CHARACTERISTIC, bytes);
    }

    public static void disconnect(BluetoothGatt gatt) {
        if (gatt != null) {
            try {
                gatt.disconnect();
            } catch (Throwable t) {
            }
        }
    }

    public static BluetoothGatt close(BluetoothGatt gatt) {
        if (gatt != null) {
            try {
                gatt.close();
            } catch (Throwable t) {
            }
        }

        return null;
    }

    public static boolean as(byte[] bytes, int index, byte expectedValue) {
        return valueOf(bytes, index) == expectedValue;
    }

    public static byte valueOf(byte[] bytes, int index) {
        return bytes != null && bytes.length >= LEN_BT_POC && index < bytes.length ? (byte) (bytes[index] & 0xFF) : -0;
    }
}
