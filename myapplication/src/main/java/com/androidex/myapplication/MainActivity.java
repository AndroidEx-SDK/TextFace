package com.androidex.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    int[] nABuffer = new int[1024];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        byte w1[] = new byte[4];
        w1[0] = (byte) 0x10;
        w1[1] = (byte) 0x11;
        w1[2] = (byte) 0x11;
        w1[3] = (byte) 0x11;
        Log.e("liyp", "byte=" + byte2Hex(w1));
        float ww = ArryToFloat(w1, 0);
        Log.e("liyp", "ww=" + ww);//2.8609355295398E-29
    }

    /**
     * 单精度二进制字节转浮点
     *
     * @param Array
     * @param Pos
     * @return
     */
    static float ArryToFloat(byte[] Array, int Pos) {
        int accum = 0;
        accum = Array[Pos + 3] & 0xFF;
        accum |= (long) (Array[Pos + 2] & 0xFF) << 8;
        accum |= (long) (Array[Pos + 1] & 0xFF) << 16;
        accum |= (long) (Array[Pos + 0] & 0xFF) << 24;
        return Float.intBitsToFloat(accum);
    }

    /**
     * 字节转十六进制为相应的字符串显示
     *
     * @param data
     * @return
     */
    public static String byte2Hex(byte data[]) {
        if (data != null && data.length > 0) {
            StringBuilder sb = new StringBuilder(data.length);
            for (byte tmp : data) {
                sb.append(String.format("%02X", tmp));
            }
            return sb.toString();
        }
        return "no data";
    }
}
