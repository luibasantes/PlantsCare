package com.projects.mirai.koukin.plantscare.Principales;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.projects.mirai.koukin.plantscare.Clases.DateServer;
import com.projects.mirai.koukin.plantscare.Clases.Planta;
import com.projects.mirai.koukin.plantscare.Clases.RestService;
import com.projects.mirai.koukin.plantscare.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class MenuPrincipal extends AppCompatActivity {

    private final String wsrest="http://luibasantes.pythonanywhere.com/api/";
    private final String uriAll="plantas/";
    private final String uriLast="plantas/last/";
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        final RestService wsrest = new RestService();
        /*if(!isConnected(MenuPrincipal.this)) buildDialog(MenuPrincipal.this).show();
        else {
            Toast.makeText(MenuPrincipal.this,"Bienvenido", Toast.LENGTH_SHORT).show();
        }*/
        TextView txt_temperatura =findViewById(R.id.txt_temp);
        TextView txt_humedad =findViewById(R.id.txt_hum);
        TextView txt_hora =findViewById(R.id.txt_hora);
        TextView txt_fecha =findViewById(R.id.txt_fecha);

        Button btn_estadisticas = findViewById(R.id.btn_stad);
        btn_estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),Estadisticas.class);
                startActivity(i);
            }
        });



        fab = findViewById(R.id.btn_float_sync);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isConnected(MenuPrincipal.this)) buildDialog(MenuPrincipal.this,"Sin Conexión al Internet","Necesitas tener internet para usar el APP").show();
                else {

                    getLastPlanta(MenuPrincipal.this);



                }
            }
        });

    }


    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
        else return false;
        } else
        return false;
    }

    public AlertDialog.Builder buildDialog(Context c,String title,String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        //builder.setTitle("No Internet Connection");
        //builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        return builder;
    }


    public void  getLastPlanta(Context context){
        //Gray #c5c8cc
        //holo_green_dark #ff669900
        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#c5c8cc")));
        fab.setEnabled(false);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        final TextView txt_temperatura =findViewById(R.id.txt_temp);
        final TextView txt_humedad =findViewById(R.id.txt_hum);
        final TextView txt_hora =findViewById(R.id.txt_hora);
        final TextView txt_fecha =findViewById(R.id.txt_fecha);
        JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                wsrest + uriLast,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response1) {
                        Log.e("Rest Response:",response1.toString());
                        try{
                            JSONObject response= response1.getJSONObject(0);
                            System.out.println("RESPUESTA DEL GET A "+ uriLast);
                            System.out.println(response.getString("id"));
                            System.out.println(response.getString("nombre"));
                            System.out.println(response.getString("fecha"));
                            System.out.println(response.getDouble("temperatura"));
                            System.out.println(response.getDouble("humedad"));
                            System.out.println(response.getBoolean("ventilador"));


                            DateServer fecha = new DateServer();
                            fecha.formatearFecha(response.getString("fecha"));

                            if(txt_fecha.getText().equals(fecha.getFechaString()) && txt_hora.getText().equals(fecha.getHoraCompletaString())){
                                buildDialog(MenuPrincipal.this,"Servidor","Ya se encuentra actualizada la informacion").show();
                            }else{
                                txt_temperatura.setText(""+response.getDouble("temperatura"));
                                txt_humedad.setText(response.getDouble("humedad")+"");
                                txt_hora.setText(fecha.getHoraCompletaString());
                                txt_fecha.setText(fecha.getFechaString());
                                Toast.makeText(MenuPrincipal.this,"Actualizado", Toast.LENGTH_SHORT).show();

                            }
                            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff669900")));
                            fab.setEnabled(true);

                        }catch(Exception e){
                            System.out.println("Something went wrong."+e);
                            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff669900")));
                            fab.setEnabled(true);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response BAD:",error.toString());
                        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff669900")));
                        fab.setEnabled(true);

                    }
                }
        );
        requestQueue.add(objectRequest);
    }


}
