package com.projects.mirai.koukin.plantscare.Principales;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.projects.mirai.koukin.plantscare.R;

import org.json.JSONObject;

public class Estadisticas extends AppCompatActivity {

    private final String wsrest="http://luibasantes.pythonanywhere.com/api/";
    private final String uriAll="plantas/";
    private final String uriLast="plantas/last/";
    private final String USER_AGENT = "Mozilla/5.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
    }




    public void  getAllPlantas(final Context context){
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                wsrest + uriAll,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response:",response.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response:",error.toString());
                    }
                }
        );


        requestQueue.add(objectRequest);
    }
}
