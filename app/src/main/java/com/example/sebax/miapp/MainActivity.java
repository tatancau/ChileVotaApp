package com.example.sebax.miapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
TextView TVregistrar;
    Button BTNiniciar;
    EditText ETnombre,ETrut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTNiniciar = findViewById(R.id.BTNiniciar);
        ETnombre = findViewById(R.id.ETnombre);
        ETrut = findViewById(R.id.ETrut);
     TVregistrar = findViewById(R.id.TVregistrar);
        TVregistrar.setOnClickListener(new View.OnClickListener() {



           @Override
           public void onClick(View view) {
               Intent intentReg = new Intent(MainActivity.this, Registro.class);
               MainActivity.this.startActivity(intentReg);
           }
       });
        BTNiniciar = findViewById(R.id.BTNiniciar);
        BTNiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final String Nombre = ETnombre.getText().toString();
            final String Rut = ETrut.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                        Boolean success = jsonResponse.getBoolean("success");
                        if (success){
                          String Nombre=jsonResponse.getString("Nombre");
                          String Rut=jsonResponse.getString("Rut");

                         Intent intent = new Intent(MainActivity.this, Usuario.class );
                            intent.putExtra("Nombre",Nombre);
                            intent.putExtra("Rut",Rut);

                            MainActivity.this.startActivity(intent);

                        } else {

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Intentar otra vez").setNegativeButton("Retry",null).create().show();
                        }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                LoginRequest loginRequest = new LoginRequest(Nombre,Rut,responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
