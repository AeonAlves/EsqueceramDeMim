package com.tmdb.esqueceramdemim.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

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

        try{
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent i = new Intent(SplashScreen.this, LoginPage.class);
                    startActivity(i);

                    finish();
                }
            }, splash_time_out);
        } catch (Exception ex) {
            String error = ex.toString();
            Toast toast = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
