package com.projects.mirai.koukin.plantscare.Clases;

import android.app.Application;
import android.app.VoiceInteractor;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.projects.mirai.koukin.plantscare.Principales.MenuPrincipal;
import com.projects.mirai.koukin.plantscare.R;

import org.json.JSONArray;
import org.json.JSONObject;


public class RestService  extends Application{

    private final String wsrest="http://luibasantes.pythonanywhere.com/api/";
    private final String uriAll="plantas/";
    private final String uriLast="plantas/last/";
    private final String USER_AGENT = "Mozilla/5.0";





}


