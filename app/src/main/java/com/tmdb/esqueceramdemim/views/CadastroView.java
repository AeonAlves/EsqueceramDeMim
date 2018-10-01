package com.tmdb.esqueceramdemim.views;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tmdb.esqueceramdemim.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

public class CadastroView extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private EditText etName;
    private EditText email;
    private EditText repEmail;
    private EditText password;
    private EditText repPass;
    private EditText etEndCons;
    private EditText etEnd;
    private EditText etBairro;
    private EditText etCidade;

    private Button btCadastro;
    private DatabaseReference db;
    private GoogleApiClient mGoogleApiClient;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        etName = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        repEmail = findViewById(R.id.etRemail);
        password = findViewById(R.id.etSenha);
        repPass = findViewById(R.id.etResenha);
        etEndCons = findViewById(R.id.etEndCons);
        etEnd = findViewById(R.id.etEnd);
        etBairro = findViewById(R.id.etBairro);
        etCidade = findViewById(R.id.etCidade);
        btCadastro = findViewById(R.id.btCadastro);

        db = FirebaseDatabase.getInstance().getReference().child("Usuarios");

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        callConnection();

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.push().setValue(etName.getText().toString().trim());
                db.push().setValue(email.getText().toString().trim());

            }
        });

    }

    private synchronized void callConnection() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i("LOG", "onConnected(" + bundle + ")");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location l) {
                if(l != null){
                    Log.i("Log", "Latitude: " + l.getLatitude());
                    Log.i("Log", "Longitude: " + l.getLongitude());
                    etEndCons.setHint(null);
                    String result = String.format("%s|%s", l.getLatitude(), l.getLongitude());
                    etEndCons.setText(result);
                }
            }
        });
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "onConnectionSuspended(" + i + ")");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i("LOG", "onConnectionFailed(" + connectionResult + ")");
    }
}
