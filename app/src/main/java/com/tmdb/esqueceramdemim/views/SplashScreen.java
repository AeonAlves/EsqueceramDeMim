package com.tmdb.esqueceramdemim.views;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tmdb.esqueceramdemim.Async.CriarBD;
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
            CriarBD criar = new CriarBD(getBaseContext());
        }catch (Exception e)
        {
            String error = e.toString();
            Toast toast = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG );
            toast.show();
        }


        try{
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent i = new Intent(SplashScreen.this, LoginView.class);
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
