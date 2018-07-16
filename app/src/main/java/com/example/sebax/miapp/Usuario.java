package com.example.sebax.miapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.file.Files;

public class Usuario extends AppCompatActivity implements View.OnClickListener {
    TextView TVnombre, TVrut, TVgoic, TVcarolina, TVguiller, TVAlejandro,TVsebastian,TVpiñera,TVedu,TVartes,TVbeatriz,TVsanchez,
    TVmarcos,TVmeo,TVjuan,TVkast,TVale,TVnavarro;
    Button BTNcarolina, BTNguiller,BTNpiñera,BTNnavarro,BTNartes,BTNsanchez,BTNmeo,BTNkast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        TVedu=findViewById(R.id.TVedu);
        TVartes=findViewById(R.id.TVartes);
        TVbeatriz=findViewById(R.id.TVbeatriz);
        TVsanchez=findViewById(R.id.TVsanchez);
        TVmarcos=findViewById(R.id.TVmarcos);
        TVmeo=findViewById(R.id.TVmeo);
        TVjuan=findViewById(R.id.TVjuan);
        TVkast=findViewById(R.id.TVkast);
        TVale=findViewById(R.id.TVale);
        TVnavarro=findViewById(R.id.TVnavarro);
        TVsebastian=findViewById(R.id.TVsebastian);
        TVpiñera=findViewById(R.id.TVpiñera);
        TVAlejandro = findViewById(R.id.TValejandro);
        TVguiller = findViewById(R.id.TVguiller);
        TVnombre = findViewById(R.id.TVnombre);
        TVrut = findViewById(R.id.TVrut);
        TVgoic = findViewById(R.id.TVgoic);
        TVcarolina = findViewById(R.id.TVcarolina);

        Intent intent = getIntent();
        String Nombre = intent.getStringExtra("Nombre");
        String Rut = intent.getStringExtra("Rut");

        TVnombre.setText(Nombre);
        TVrut.setText(Rut);


        BTNkast = findViewById(R.id.BTNkast);
        BTNmeo = findViewById(R.id.BTNmeo);
        BTNsanchez = findViewById(R.id.BTNsanchez);
        BTNartes = findViewById(R.id.BTNartes);
        BTNnavarro = findViewById(R.id.BTNnavarro);
        BTNpiñera = findViewById(R.id.BTNpiñera);
        BTNcarolina = findViewById(R.id.BTNcarolina);
        BTNguiller = findViewById(R.id.BTNguller);

        BTNartes.setOnClickListener(this);
        BTNsanchez.setOnClickListener(this);
        BTNmeo.setOnClickListener(this);
        BTNkast.setOnClickListener(this);
        BTNnavarro.setOnClickListener(this);
        BTNpiñera.setOnClickListener(this);
        BTNguiller.setOnClickListener(this);
        BTNcarolina.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.BTNcarolina:

            final String Nombre = TVgoic.getText().toString();
            final String Apellido = TVcarolina.getText().toString();
            Response.Listener<String> responListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        Boolean success = jsonObject.getBoolean("success");
                        if (success) {
                            Intent intent = new Intent(Usuario.this, MainActivity.class);
                            Usuario.this.startActivity(intent);
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Usuario.this);
                            builder.setMessage("Intentar otra vez").setNegativeButton("Retry", null).create().show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            };

            VotoRequest candiRequest = new VotoRequest(Nombre, Apellido, responListener);
            RequestQueue queue = Volley.newRequestQueue(Usuario.this);
            queue.add(candiRequest);

break;
            case R.id.BTNguller:

                final String ale = TVAlejandro.getText().toString();
                final String gui = TVguiller.getText().toString();

                Response.Listener<String> respoListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Usuario.this, MainActivity.class);
                                Usuario.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Usuario.this);
                                builder.setMessage("Intentar otra vez").setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                VotoRequest candRequest = new VotoRequest(ale, gui, respoListener);
                RequestQueue queu = Volley.newRequestQueue(Usuario.this);
                queu.add(candRequest);
break;
            case R.id.BTNpiñera:
                final String seba = TVsebastian.getText().toString();
                final String piñe = TVpiñera.getText().toString();

                Response.Listener<String> sebaListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Usuario.this, MainActivity.class);
                                Usuario.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Usuario.this);
                                builder.setMessage("Intentar otra vez").setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                VotoRequest sebaRequest = new VotoRequest(seba, piñe, sebaListener);
                RequestQueue queue1 = Volley.newRequestQueue(Usuario.this);
                queue1.add(sebaRequest);
                break;

            case R.id.BTNartes:
                final String edu = TVedu.getText().toString();
                final String artes = TVartes.getText().toString();

                Response.Listener<String> eduListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Usuario.this, MainActivity.class);
                                Usuario.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Usuario.this);
                                builder.setMessage("Intentar otra vez").setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                VotoRequest eduRequest = new VotoRequest(edu, artes, eduListener);
                RequestQueue queue1Queue2 = Volley.newRequestQueue(Usuario.this);
                queue1Queue2.add(eduRequest);
                break;

            case R.id.BTNsanchez:
                final String bea = TVbeatriz.getText().toString();
                final String sanchez = TVsanchez.getText().toString();

                Response.Listener<String> beaListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Usuario.this, MainActivity.class);
                                Usuario.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Usuario.this);
                                builder.setMessage("Intentar otra vez").setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                VotoRequest beaRequest = new VotoRequest(bea, sanchez, beaListener);
                RequestQueue queue5 = Volley.newRequestQueue(Usuario.this);
                queue5.add(beaRequest);
                break;

            case R.id.BTNmeo:
                final String marco = TVmarcos.getText().toString();
                final String ominami = TVmeo.getText().toString();

                Response.Listener<String> marcoListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Usuario.this, MainActivity.class);
                                Usuario.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Usuario.this);
                                builder.setMessage("Intentar otra vez").setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                VotoRequest marcoRequest = new VotoRequest(marco, ominami, marcoListener);
                RequestQueue queue6 = Volley.newRequestQueue(Usuario.this);
                queue6.add(marcoRequest);
                break;

            case R.id.BTNkast:
                final String juan = TVjuan.getText().toString();
                final String kast = TVkast.getText().toString();

                Response.Listener<String> juanListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Usuario.this, MainActivity.class);
                                Usuario.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Usuario.this);
                                builder.setMessage("Intentar otra vez").setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                VotoRequest juanRequest = new VotoRequest(juan, kast, juanListener);
                RequestQueue queue7 = Volley.newRequestQueue(Usuario.this);
                queue7.add(juanRequest);
                break;

            case R.id.BTNnavarro:
                final String alejandro = TVale.getText().toString();
                final String navarro = TVnavarro.getText().toString();

                Response.Listener<String> aleListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Usuario.this, MainActivity.class);
                                Usuario.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Usuario.this);
                                builder.setMessage("Intentar otra vez").setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                VotoRequest aleRequest = new VotoRequest(alejandro, navarro, aleListener);
                RequestQueue queue8 = Volley.newRequestQueue(Usuario.this);
                queue8.add(aleRequest);
                break;
        }

    }

}





