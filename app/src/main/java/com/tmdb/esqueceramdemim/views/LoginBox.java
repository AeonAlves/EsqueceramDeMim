package com.tmdb.esqueceramdemim.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tmdb.esqueceramdemim.viewmodels.LoginViewModel;

/**
 * Created by diego on 31/08/2018.
 */

public class LoginBox extends Fragment {

    private EditText email;
    private EditText password;
    private Button enter;
    private Button facebook;
    private Button back;
    private LoginViewModel _model;

    public LoginBox(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.loginbox, container, false);

        email = (EditText) v.findViewById(R.id.etEmail);
        password = (EditText) v.findViewById(R.id.etPassword);
        enter = (Button) v.findViewById(R.id.btLogin);
        facebook = (Button) v.findViewById(R.id.btFacebook);
        back = (Button) v.findViewById(R.id.btBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.setVisibility(View.INVISIBLE);
                Intent intent = new Intent();
                intent.setClass(getActivity(), LoginPage.class);
                getActivity().startActivity(intent);


            }
        });

        return v;
    }
}
