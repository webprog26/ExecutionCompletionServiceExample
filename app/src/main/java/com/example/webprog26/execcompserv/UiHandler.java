package com.example.webprog26.execcompserv;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by webprog26 on 07.11.2016.
 */

public class UiHandler extends Handler {

    private static final String TAG = "UiHandler_TAG";

    private MessageRunnable messageRunnable;

    public UiHandler(MessageRunnable messageRunnable) {
        this.messageRunnable = messageRunnable;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case ConsumerThread.IMAGE_LOADED:
                printLog(msg.what);
                post(messageRunnable);
                break;
        }
    }

    private void printLog(int messageWhat){
        String logMessage = "";
        switch (messageWhat){
            case ConsumerThread.IMAGE_LOADED:
                logMessage = "Image loaded";
                break;
        }
        Log.i(TAG, logMessage);
    }
}
