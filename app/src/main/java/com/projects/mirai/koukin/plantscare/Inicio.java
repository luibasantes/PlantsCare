package com.projects.mirai.koukin.plantscare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

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
            Intent i=new Intent(getBaseContext(),MenuPrincipal.class);
            startActivity(i);
            //Inicializar actividad Menu
            finish();




            }
        };
        thread.start();


    }
}
