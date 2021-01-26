package com.deepai.paipai.ui.activity.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.deepai.library.support.adapter.DBaseAdapter;
import com.deepai.library.support.utils.ToastFactory;
import com.deepai.paipai.R;
import com.deepai.paipai.support.ble.MyBle;
import com.deepai.paipai.support.ble.MyReadSendBle;
import com.deepai.paipai.support.utils.AppSP;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class BleListActivity extends BaseActivity {
    private static final String[] bleStartNames = {"SimpleBLEPeripheral", "TL-6A"};
    /* access modifiers changed from: private */
    public BleAdapter adapter;
    private long delayMillis = 0;
    private LinearLayout llCurrentDevice;
    private LinearLayout llOtherDevice;
    private ListView lvOtherDevice;
    /* access modifiers changed from: private */
    public BluetoothAdapter mBluetoothAdapter;
    /* access modifiers changed from: private */
    public LeScanCallback mLeScanCallback = new LeScanCallback() {
        public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
            BleListActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    BleListActivity.this.adapter.add(device);
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public boolean mScanning;
    private final Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 23:
                    switch (msg.arg1) {
                        case 2:
                            ToastFactory.getToast((Context) BleListActivity.this, (int) R.string.ble_connect_success).show();
                            BleListActivity.this.onBackPressed();
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    };
    private Handler myHandler2;
    /* access modifiers changed from: private */
    public MyReadSendBle myUdpSendTest;
    private TextView tvCurrentName;

    class BleAdapter extends DBaseAdapter<BluetoothDevice> {
        public BleAdapter(List<BluetoothDevice> list, Context context) {
            super(list, context);
        }

        public View createView(int position, View convertView, ViewGroup parent) {
            View convertView2 = this.inflater.inflate(R.layout.item_ble_list, parent, false);
            final BluetoothDevice device = (BluetoothDevice) this.list.get(position);
            ((TextView) convertView2.findViewById(R.id.tv_ble_device_name)).setText("PaiPai360-" + device.getName());
            final ProgressBar progressBar = (ProgressBar) convertView2.findViewById(R.id.progress_ble_show);
            convertView2.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (BleListActivity.this.mScanning) {
                        BleListActivity.this.mBluetoothAdapter.stopLeScan(BleListActivity.this.mLeScanCallback);
                        BleListActivity.this.mScanning = false;
                    }
                    progressBar.setVisibility(View.VISIBLE);
                    AppSP.setBleName(BleAdapter.this.context, device.getName());
                    AppSP.setBleAddress(BleAdapter.this.context, device.getAddress());
                    MyBle.startServiceSendBytes(BleListActivity.this.myUdpSendTest);
                }
            });
            return convertView2;
        }

        public void clear() {
            if (this.list != null && this.list.size() > 0) {
                this.list.clear();
                notifyDataSetChanged();
            }
        }

        public void add(BluetoothDevice device) {
            if (this.list != null && device.getName() != null && device.getName().startsWith("TL")) {
                for (BluetoothDevice d : this.list) {
                    if (device.getAddress().equals(d.getAddress())) {
                        return;
                    }
                }
                this.list.add(device);
                notifyDataSetChanged();
            }
        }

        public void delete(int position) {
            if (this.list != null) {
                this.list.remove(position);
                notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_ble_list);
        initView();
        initBle();
    }

    private void initView() {
        initTitle(R.string.my_device);
        this.llCurrentDevice = (LinearLayout) findViewById(R.id.ll_current_device);
        this.llOtherDevice = (LinearLayout) findViewById(R.id.ll_other_device);
        this.tvCurrentName = (TextView) findViewById(R.id.tv_current_device_name);
        this.lvOtherDevice = (ListView) findViewById(R.id.lv_ble_list);
        this.adapter = new BleAdapter(new ArrayList<>(), this);
        this.lvOtherDevice.setAdapter(this.adapter);
    }

    private void initBle() {
        if (!getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            ToastFactory.getToast((Context) this, (int) R.string.ble_not_supported).show();
            finish();
        }
        this.mBluetoothAdapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        if (this.mBluetoothAdapter == null) {
            ToastFactory.getToast((Context) this, (int) R.string.ble_not_supported).show();
            finish();
            return;
        }
        if (this.mBluetoothAdapter.isEnabled()) {
            this.delayMillis = 1;
        } else {
            this.mBluetoothAdapter.enable();
            this.delayMillis = 3000;
        }
        if (this.myHandler2 == null) {
            this.myHandler2 = new Handler();
        }
        this.myHandler2.postDelayed(new Runnable() {
            public void run() {
                BleListActivity.this.scanLeDevice(true);
            }
        }, this.delayMillis);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MyReadSendBle.Stop();
        this.myUdpSendTest = new MyReadSendBle(this, this.myHandler);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        scanLeDevice(false);
        this.adapter.clear();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: private */
    public void scanLeDevice(boolean enable) {
        if (enable) {
            this.mScanning = true;
            this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
            return;
        }
        this.mScanning = false;
        this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
    }
}
