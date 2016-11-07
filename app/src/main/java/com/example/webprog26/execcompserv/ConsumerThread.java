package com.example.webprog26.execcompserv;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by webprog26 on 07.11.2016.
 */

public class ConsumerThread extends Thread {

    public static final int IMAGE_LOADED = 100;

    private DownloadCompletionService mEcs;
    private Handler mUiHandler;

    public ConsumerThread(DownloadCompletionService esc, Handler uiHandler) {
        this.mEcs = esc;
        this.mUiHandler = uiHandler;
    }

    @Override
    public void run() {
        super.run();
        try {
            while(!mEcs.isTerminated()){
                Future<Bitmap> future = mEcs.poll(1, TimeUnit.SECONDS);
                if(future != null){
                    mUiHandler.obtainMessage(IMAGE_LOADED, future.get()).sendToTarget();
                }
            }
        } catch (InterruptedException ie){
            ie.printStackTrace();
        } catch (ExecutionException ee){
            ee.printStackTrace();
        }
    }
}
