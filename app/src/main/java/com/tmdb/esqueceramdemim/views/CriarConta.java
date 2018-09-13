package com.tmdb.esqueceramdemim.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.tmdb.esqueceramdemim.R;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

public class CriarConta extends AppCompatActivity {

    private EditText etName;
    private EditText email;
    private EditText repEmail;
    private EditText password;
    private EditText repPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        etName = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        repEmail = findViewById(R.id.etRemail);
        password = findViewById(R.id.etSenha);
        repPass = findViewById(R.id.etResenha);

        if(password.hasFocus()){
            password.setText(null);
            password.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
        }
        if(repPass.hasFocus()){
            password.setText(null);
            repPass.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
}
