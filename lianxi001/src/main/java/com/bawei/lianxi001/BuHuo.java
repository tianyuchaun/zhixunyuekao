package com.bawei.lianxi001;

import android.util.Log;

import androidx.annotation.NonNull;

public class BuHuo implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        Log.d("xx", throwable.getMessage());
    }
}
