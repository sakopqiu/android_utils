package com.example.android_utils;

import android.util.Log;

public class Utils {
    private static String TAG = Utils.class.getCanonicalName();

    public static void log(String content) {
        Log.d(TAG, "222");
        Log.d(TAG, content);
    }
}
