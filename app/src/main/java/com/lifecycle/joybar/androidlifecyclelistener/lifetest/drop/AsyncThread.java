package com.lifecycle.joybar.androidlifecyclelistener.lifetest.drop;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class AsyncThread extends Thread {

    private CallBack mCallBack;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public AsyncThread(CallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    public void run() {
        //模拟耗时
        String name = this.getName();
        try {
            Log.i("AsyncThread","执行异步任务" + name);
            Thread.sleep(1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mCallBack.onRefresh("world");
            }
        });

    }
}
