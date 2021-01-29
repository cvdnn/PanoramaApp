# 环物拍摄

## 权限设置
### 1. Manifest设置
```xml
<manifest>
    <!-- 蓝牙必须的权限 -->
    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
    <!-- android6.0以上使用蓝牙需要的权限，否则在Android6.0以上的手机扫描不到蓝牙设备 -->
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

    <!-- ble -->
    <uses-feature
        android:name="android.hardware.bluetooth_le"
        android:required="true" />


</manifest>
```

### 2. 识别手机是否支持低功耗蓝牙(BLE)
```java
    // 使用此检查确定设备是否支持BLE。 然后你可以有选择地禁用与BLE相关的功能
    if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
        makeSnack("ble_not_supported");
    }
```

### 3. Activity授权设置
```java
@Override
protected void onCreate(Bundle savedInstanceState) {

    // 权限设置
    if (!checkPermissions(NEEDED_PERMISSIONS)) {
        ActivityCompat.requestPermissions(this, NEEDED_PERMISSIONS, ACTION_REQUEST_PERMISSIONS);
    }
}
```


## 获取蓝牙适配器和扫描器
```java
    mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    // 获取蓝牙扫描器
    mBluetoothLeScanner = mBluetoothAdapter.getBluetoothLeScanner();
```

> For API level 18 and above, get a reference to BluetoothAdapter through BluetoothManager.

```java
    final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
    mBluetoothAdapter = bluetoothManager.getAdapter();
```

- 当检测到手机`蓝牙未打开`，需要跳转打开`蓝牙设置界面`

```java
    // Ensures Bluetooth is available on the device and it is enabled. If not,
    // displays a dialog requesting user permission to enable Bluetooth.
    if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBtIntent, ACTION_REQUEST_BLUETOOTH_LE);
    }
```


## 扫描蓝牙设备
### 1. 蓝牙扫描
```java
    mBluetoothLeScanner.startScan(mScanCallback);
```
> 正常情况下10秒钟就能获取到周边所有蓝牙设备UUID，需要手动停止扫描，否则设备将会一直处于扫描状态。

```java
    // Stops scanning after 10 seconds.
    private static final long SCAN_PERIOD = 10_000;

    /**
     * 扫描设备，通常10秒内能查找到相应到蓝牙设备
     * FIXME 需要添加扫描状态控制
     *
     * @param enable
     */
    private void onStartScanLeDevice(final boolean enable) {
        if (mBluetoothLeScanner != null) {
            if (enable) {
                mBluetoothLeScanner.startScan(mScanCallback);

                Loople.Task.schedule(() -> {
                    if (mBluetoothLeScanner != null) {
                        mBluetoothLeScanner.stopScan(mScanCallback);
                    }

                }, SCAN_PERIOD);

            } else {
                mBluetoothLeScanner.stopScan(mScanCallback);
            }
        }
    }
```

### 2. 扫描结果
扫描是进一步执行到，故需要设置ScanCallback，在ScanCallback中收集蓝牙设备。
> 注：环物设备蓝牙名称是以 `FC-30M` 开头，需要将这部分蓝牙设备单独缓存，列表展示。

```java
    private final ScanCallback mScanCallback = new ScanCallback() {

        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            BluetoothDevice bd = result.getDevice();

            String devName = bd.getName();
            if (Assert.notEmpty(devName) && bd.getName().startsWith("FC-30M")) {
                // FIXME DEMO测试单个设备
                mBluetoothLeScanner.stopScan(this);

                String bdAddress = bd.getAddress();
                Log.e(TAG, "::: " + bd.getType() + ": " + bd.getName() + ", " + bdAddress + ": " + result.getRssi());

                // FIXME DEMO直接发起蓝牙连接
                Loople.Task.schedule(() -> connect(bdAddress));
            }
        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            Log.e(TAG, "::: size: %d", results.size());
        }

        @Override
        public void onScanFailed(int errorCode) {
            Log.e(TAG, "::: onScanFailed: %d", errorCode);
        }
    };
```
> 用例中仅获取扫描到的单个设备作为测试设备。

### 3. 当用户选择连接蓝牙设备后，通过缓存设备蓝牙UUID，以便下一次快捷连接改设备
> 快捷连接蓝牙设备时扫描步骤相同，在ScanResult中匹配到该蓝牙后直接发起连接。

## 蓝牙连接
### 1. 蓝牙连接
扫面过程将会获得设备相关的地址，改地址是一条UUID字符串，用此UUID即可连接蓝牙设备。
> 连接过程需要对 __连接异常__ 进行相关处理，并提示用户蓝牙连接异常，以便重连。
> 需要对连接进行`状态控制`，避免重复连接

```java
    /**
     * Connects to the GATT server hosted on the Bluetooth LE device.
     * FIXME DEMO缺少重连策略
     *
     * @param address The device address of the destination device.
     *
     * @return Return true if the connection is initiated successfully. The connection result is reported asynchronously through the
     * {@code BluetoothGattCallback#onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int)} callback.
     */
    public boolean connect(final String address) {
        if (mBluetoothAdapter == null || address == null) {
            Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }

        // Previously connected device. Try to reconnect.
        if (address.equals(mBluetoothAddress) && mBluetoothGatt != null) {
            Log.d(TAG, "Trying to use an existing mBluetoothGatt for connection.");
            if (mBluetoothGatt.connect()) {
                mConnectionState = STATE_CONNECTING;
                return true;
            } else {
                return false;
            }
        }

        // 获取蓝牙设备实例
        final BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        if (device == null) {
            Log.w(TAG, "Device not found.  Unable to connect.");
            return false;
        }
        // We want to directly connect to the device, so we are setting the autoConnect parameter to false.
        mBluetoothGatt = device.connectGatt(this, true, mGattCallback);
        Log.d(TAG, "Trying to create a new connection.");

        mBluetoothAddress = address;
        mConnectionState = STATE_CONNECTING;

        return true;
    }
```
> 不用扫描回调的BluetoothDevice对象，可以优化业务逻辑分离，是的扫描和连接或快捷连接相对独立，以便更好的进行页面业务逻辑操作。

### 2. 连接回调
- 发起连接后需要关注`连接的稳定性`，主要通过`onConnectionStateChange`来对连接状态进行判断，以及是否需要重连；

- 通过获取指定的服务以及服务特征对设备进行数据传送和监听；
- 通过调用`onCharacteristicRead`方法，并以以回调的方式从设备获取设备`onCharacteristicRead`数据；
- 通过设置`setCharacteristicNotification`监听，回调设备应答数据；

```java
    /**
     * Implements callback methods for GATT events that the app cares about.
     * For example, connection change and services discovered.
     */
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {

        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == STATE_CONNECTED) {
                mConnectionState = STATE_CONNECTED;

                Log.i(TAG, ":::Connected to GATT server.");
                // Attempts to discover services after successful connection.

                // 连接成功后查询设备所提供的蓝牙服务
                boolean result = gatt.discoverServices();
                if (!result) {
                    // FIXME 提示重连等
                    Log.e(TAG, ":::Attempting to start service discovery:" + result);
                    makeSnack("Attempting to start service discovery:" + result);
                }

            } else if (newState == STATE_DISCONNECTED) {
                mConnectionState = STATE_DISCONNECTED;
                Log.i(TAG, ":::Disconnected from GATT server.");
                makeSnack("Disconnected from GATT server");

                // FIXME 提示重连等
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (status == GATT_SUCCESS) {
                mBluetoothGattService = BleEngine.findGattService(mBluetoothGatt);
                onGattServices(mBluetoothGattService);

            } else {
                Log.w(TAG, ":::onServicesDiscovered received: " + status);
                // FIXME 重新尝试获取服务
            }
        }

        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            if (status == GATT_SUCCESS) {
                byte[] bytes = characteristic.getValue();
                if (BleEngine.checkResponse(bytes)) {
                    mDeviceState = FLAG_STATE_SUCCESS;

                    makeSnack("设备连接成功");
                } else {
                    Log.d(TAG, "::: onCharacteristicRead: %d, %s: %s", characteristic.getUuid(), Arrays.toString(bytes));
                }
            }
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            byte[] bytes = characteristic.getValue();
            if (BleEngine.asResponse(bytes)) {
                byte state = BleEngine.getState(bytes);
                if (state == FLAG_END_MOTION) {
                    Loople.Task.schedule(() -> onInvokeTakePicture(), BT_IDLE_MILLIS);
                }
            }

//            Log.d(TAG, "::: onCharacteristicChanged: %s: %s", characteristic.getUuid(), Arrays.toString(bytes));
        }
    };
```

### 3. 当设备连接成功后，即会通过`onServicesDiscovered`回调改蓝牙所提供的服务；
在`onServicesDiscovered`回调中，匹配`00001910-0000-1000-8000-xxxxxxxxxxxx`服务，并对该服务`Characteristic`进行设置。
```java
    mBluetoothGattService = BleEngine.findGattService(mBluetoothGatt);
    onGattServices(mBluetoothGattService);
```

```java
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
```

### 4. `Characteristic`设置
- 获取发送Characteristic: `0000fff1-0000-1000-8000-xxxxxxxxxxxx`
- 设置监听Characteristic: `0000fff4-0000-1000-8000-xxxxxxxxxxxx`

```java
    private final void onGattServices(BluetoothGattService service) {
        if (service != null) {
            mSendCharacteristic = BleEngine.findSendCharacteristic(service);

            if (mReceiveCharacteristic != null) {
                BleEngine.setCharacteristicNotification(mBluetoothGatt, mReceiveCharacteristic, false);
                mReceiveCharacteristic = null;
            }

            BluetoothGattCharacteristic receiveCharacteristic = BleEngine.findReceiveCharacteristic(service);
            if (receiveCharacteristic != null) {
                if (BleEngine.setCharacteristicNotification(mBluetoothGatt, receiveCharacteristic, true)) {
                    mReceiveCharacteristic = receiveCharacteristic;
                }

                // 查询设备状态
                BleEngine.readCharacteristic(mBluetoothGatt, receiveCharacteristic);
            }
        }
    }
```
> 服务Characteristic设置完成后，需要向设备发送读取数据指令，以便确认设备已经初始化准备完成。
> 设备数据从回调函数的 `onCharacteristicRead`方法获取，并进行数据格式判断。
> 如果设备返回异常，则需要 _重新连接_ 蓝牙服务

```java
        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            if (status == GATT_SUCCESS) {
                byte[] bytes = characteristic.getValue();
                if (BleEngine.checkResponse(bytes)) {
                    mDeviceState = FLAG_STATE_SUCCESS;

                    makeSnack("设备连接成功");
                } else {
                    Log.d(TAG, "::: onCharacteristicRead: %d, %s: %s", characteristic.getUuid(), Arrays.toString(bytes));
                }
            }
        }
```

## 蓝牙设备数据通讯
### 1. 字节定义
协议一共17个字节，其中第 `2`个字节是代表数据请求应答；第7个字节属于控制类型；
- [1]: FLAG_REQUEST = 1, FLAG_RESPONSE = 2;
- [6]: 0b0000_0100: 18; 0b0000_0010 : 36;

```java
    public enum SpinType {
        SPIN01(0b0100_0000, 1),
        SPIN02(0b0010_0000, 2),
        SPIN04(0b0001_0000, 4),
        SPIN09(0b0000_1000, 9),
        SPIN18(0b0000_0100, 18),
        SPIN36(0b0000_0010, 36),
        SPIN72(0b0000_0001, 72),
        SPIN50000(0b1000_0000, 50_000),
        SPIN60000(0b1001_0000, 60_000),
        SPIN80000(0b1100_0000, 80_000),
        SPIN90000(0b1110_0000, 90_000);

        public byte type;
        public int num;

        SpinType(int t, int n) {
            type = (byte) t;
            num = n;
        }
    }
```
### 2. 通讯协议
```java
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
```

### 3. 发送指令
```java
    public static boolean takeAround(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, SpinType stye) {
        boolean result = false;

        if (characteristic != null && gatt != null) {
            characteristic.setValue(makeCtlBytes(stye));
            result = gatt.writeCharacteristic(characteristic);
        }

        return result;
    }
```

### 4. 设备执行情况
通过监听`onCharacteristicChanged`获得设备执行情况：FLAG_START_MOTION = 1, FLAG_END_MOTION = 2;
> FLAG_START_MOTION: 设备开始运行；FLAG_END_MOTION: 设备运行完成
```java
        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            byte[] bytes = characteristic.getValue();
            if (BleEngine.asResponse(bytes)) {
                byte state = BleEngine.getState(bytes);
                if (state == FLAG_END_MOTION) {
                    Loople.Task.schedule(() -> onInvokeTakePicture(), BT_IDLE_MILLIS);
                }
            }

//            Log.d(TAG, "::: onCharacteristicChanged: %s: %s", characteristic.getUuid(), Arrays.toString(bytes));
        }
```

## 拍照逻辑
- 摄像头初始化 -> 设置预览 -> 拍照 -> 保存照片 -> 根据业务对照片进行渲染。

## [环物拍照接口](http://192.168.1.47:8067/api/swagger-ui.html)
- 环物拍照过程拍照次数需要控制；
- 资源徐打包成zip上传，文件格式: 00_00_cover.jpg, 00_01_cover.jpg