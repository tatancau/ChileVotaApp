package com.example.sebax.miapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sebax on 08-07-2018.
 */

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL="http://192.168.0.100/Inicio.php";
    private Map<String,String> params;
    public LoginRequest(String Nombre, String Rut, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params=new HashMap<>();
        params.put("Nombre",Nombre);
        params.put("Rut",Rut);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
