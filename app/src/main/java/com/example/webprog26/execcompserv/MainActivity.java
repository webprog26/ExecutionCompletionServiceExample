package com.example.webprog26.execcompserv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private static final int NUMBER_OF_TASKS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UiHandler uiHandler = new UiHandler(new MessageRunnable(this));

        DownloadCompletionService esc = new DownloadCompletionService(Executors.newCachedThreadPool());
        new ConsumerThread(esc, uiHandler).start();

        for(int i = 0; i < NUMBER_OF_TASKS; i++){
            esc.submit(new ImageDownloadTask(this));
        }

        esc.shutdown();
    }
}
