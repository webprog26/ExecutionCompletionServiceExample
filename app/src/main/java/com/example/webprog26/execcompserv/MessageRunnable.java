package com.example.webprog26.execcompserv;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by webprog26 on 07.11.2016.
 */

public class MessageRunnable implements Runnable {

    private Activity mActivity;

    public MessageRunnable(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void run() {
        Toast.makeText(mActivity, "Message uploaded", Toast.LENGTH_SHORT).show();
    }


}
