package com.tmdb.esqueceramdemim.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.tmdb.esqueceramdemim.R;

/**
 * Created by diego on 04/09/2018.
 */

public class SplashScreen extends AppCompatActivity {

    private static int splash_time_out = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent i = new Intent(SplashScreen.this, LoginPage.class);
                startActivity(i);

                finish();
            }
        }, splash_time_out);
    }
}
