package com.popular.comm;

import android.util.Log;
import com.orhanobut.logger.Logger;

/**
 * Created by L
 * 2018/9/3
 */
public class LogUtil
{

    public static final String L = "L-WL";

    public static void d(String tag, String msg) {
        if (true)
            Logger.d("命令:=== "+msg);
    }


    public static void i(String tag, String msg) {
        if (true)
            Log.i("borayLog: " + tag, msg);
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (true)
            Log.w("borayLog: " + tag, msg, tr);
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (true)
            Log.e("borayLog: " + tag, msg, tr);
    }
}
