package com.example.webprog26.execcompserv;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by webprog26 on 07.11.2016.
 */

public class BitmapUtils {

    private Activity mActivity;

    public BitmapUtils(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public Bitmap downloadRemoteImage(){
        return BitmapFactory.decodeResource(mActivity.getResources(), R.mipmap.ic_launcher);
    }
}
