package com.example.webprog26.execcompserv;

import android.app.Activity;
import android.graphics.Bitmap;

import java.util.concurrent.Callable;

/**
 * Created by webprog26 on 07.11.2016.
 */

public class ImageDownloadTask implements Callable<Bitmap> {

    private Activity mActivity;
    private BitmapUtils mBitmapUtils;

    public ImageDownloadTask(Activity mActivity) {
        this.mActivity = mActivity;
        mBitmapUtils = new BitmapUtils(mActivity);
    }

    @Override
    public Bitmap call() throws Exception {
        return mBitmapUtils.downloadRemoteImage();
    }
}
