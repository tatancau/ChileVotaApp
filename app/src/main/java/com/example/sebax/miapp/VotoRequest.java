package com.example.sebax.miapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sebax on 09-07-2018.
 */

public class VotoRequest extends StringRequest {

    private static final String VOTO_REQUEST_UML="http://192.168.0.100/Votos.php";
    private Map<String,String> params;

    public VotoRequest(String Nombre,String Apellido, Response.Listener<String> listener){
         super(Method.POST, VOTO_REQUEST_UML,listener,null);
           params=new HashMap<>();
        params.put("Nombre",Nombre);
        params.put("Apellido",Apellido);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
