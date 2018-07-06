package com.projects.mirai.koukin.plantscare.Principales;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.projects.mirai.koukin.plantscare.R;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button clickButton = (Button) findViewById(R.id.button);
        final EditText codigo = (EditText) findViewById(R.id.txt_codigo);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(codigo.getText().toString().equals("GALLARDO") || codigo.getText().toString().equals("gallardo") || codigo.getText().toString().equals("Gallardo")){
                    Intent i=new Intent(getBaseContext(),MenuPrincipal.class);
                    startActivity(i);
                    finish();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("claveCorrecta", true);
                    editor.commit(); // commit changes
                }
                else{
                    final TextView warning = (TextView) findViewById(R.id.txt_warning);
                    warning.setText("CODIGO INCORRECTO");
                }
            }
        });
    }


}
