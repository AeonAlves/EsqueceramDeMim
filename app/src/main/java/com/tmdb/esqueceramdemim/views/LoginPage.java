package com.tmdb.esqueceramdemim.views;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import com.tmdb.esqueceramdemim.R;
import com.tmdb.esqueceramdemim.viewmodels.LoginViewModel;

public class LoginPage extends AppCompatActivity {

    private LoginBox loginBox;
    private Button btLogin;
    private Button btSignup;
    private Button btLater;
    private FrameLayout opContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);

        if(findViewById(R.id.loginContainer)!=null){
            if (savedInstanceState!=null)
                return;
        }

        btLogin = findViewById(R.id.btLogin);
        btSignup = findViewById(R.id.btSignup);
        btLater = findViewById(R.id.btLater);
        opContainer = findViewById(R.id.optionsContainer);

        loginBox = new LoginBox();

        FragmentManager m = getSupportFragmentManager();
        final FragmentTransaction t = m.beginTransaction();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.add(R.id.loginContainer, loginBox);
                t.commit();
                opContainer.setVisibility(View.INVISIBLE);
            }
        });

        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, CriarConta.class);
                startActivity(intent);

            }
        });

        btLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
