package com.arashivision.graphicpath.render.Stabilization;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class AAARawItem {
    public int data_stat;
    public float ev_target;
    public float exp_time;
    public int iso_value;
    public int luma_wg_grid;
    public int luma_wg_y;
    public int sum_wg_y;
    public int temp_data_0;
    public int temp_data_1;
    public int temp_data_2;
    public int temp_data_3;
    public int temp_data_4;
    public int temp_data_5;
    public int temp_data_6;
    public int time_stamp;

    public static ArrayList<AAARawItem> ByteArray2AAAData(byte[] bArr, int i2) {
        if (bArr == null) {
            return new ArrayList<>();
        }
        ArrayList<AAARawItem> arrayList = new ArrayList<>();
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        int limit = order.limit();
        while (order.position() + i2 <= limit) {
            AAARawItem aAARawItem = new AAARawItem();
            aAARawItem.time_stamp = order.getInt();
            aAARawItem.ev_target = order.getFloat();
            aAARawItem.exp_time = order.getFloat();
            aAARawItem.data_stat = order.getInt();
            int i3 = order.getInt();
            aAARawItem.luma_wg_grid = i3 & GyroType.INS_WEARABLE_TEST;
            aAARawItem.luma_wg_y = (i3 & 16256) >> 7;
            aAARawItem.sum_wg_y = (507904 & i3) >> 14;
            aAARawItem.iso_value = (i3 & -524288) >> 19;
            aAARawItem.temp_data_0 = order.getInt();
            aAARawItem.temp_data_1 = order.getInt();
            aAARawItem.temp_data_2 = order.getInt();
            aAARawItem.temp_data_3 = order.getInt();
            aAARawItem.temp_data_4 = order.getInt();
            aAARawItem.temp_data_5 = order.getInt();
            aAARawItem.temp_data_6 = order.getInt();
            arrayList.add(aAARawItem);
        }
        return arrayList;
    }
}
