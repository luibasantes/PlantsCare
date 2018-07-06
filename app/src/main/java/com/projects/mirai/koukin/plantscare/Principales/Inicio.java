package com.projects.mirai.koukin.plantscare.Principales;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

import com.projects.mirai.koukin.plantscare.R;

public class Inicio extends AppCompatActivity {

    private int tiempo = 10;
    int pStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Thread thread = new Thread() {
        public void run() {
            while (pStatus < 500) {
                pStatus += 1;
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                try {
                    sleep(tiempo);
                } catch (Exception e) {

                }
            }
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            boolean log = pref.getBoolean("claveCorrecta", false); // getting boolean
            Intent i;
            if(log){
                i=new Intent(getBaseContext(),MenuPrincipal.class);
            }else {
                i = new Intent(getBaseContext(), login.class);
            }
            startActivity(i);
            //Inicializar actividad Menu
            finish();




            }
        };
        thread.start();


    }
}
