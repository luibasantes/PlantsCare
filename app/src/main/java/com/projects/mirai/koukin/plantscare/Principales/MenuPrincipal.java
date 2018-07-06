package com.projects.mirai.koukin.plantscare.Principales;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.projects.mirai.koukin.plantscare.Clases.RestService;
import com.projects.mirai.koukin.plantscare.R;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        /*if(!isConnected(MenuPrincipal.this)) buildDialog(MenuPrincipal.this).show();
        else {
            Toast.makeText(MenuPrincipal.this,"Bienvenido", Toast.LENGTH_SHORT).show();
        }*/


        FloatingActionButton fab = findViewById(R.id.btn_float_sync);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isConnected(MenuPrincipal.this)) buildDialog(MenuPrincipal.this).show();
                else {
                    Toast.makeText(MenuPrincipal.this,"Bienvenido", Toast.LENGTH_SHORT).show();
                    RestService wsrest = new RestService();
                    wsrest.getAllPlantas(MenuPrincipal.this);
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

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        //builder.setTitle("No Internet Connection");
        //builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");
        builder.setTitle("Sin Conexión al Internet");
        builder.setMessage("Necesitas tener internet para usar el APP");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

        return builder;
    }
}
