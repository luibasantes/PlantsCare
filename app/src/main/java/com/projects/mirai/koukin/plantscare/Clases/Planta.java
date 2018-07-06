package com.projects.mirai.koukin.plantscare.Clases;

import java.util.Date;

public class Planta {
    private String nombre;
    private boolean ventilador;
    private float temperatura;
    private float humedad;
    private String hora;
    private String fecha;


    public Planta(String nombre,boolean ventilador,float temperatura, float humedad,String hora,String fecha){
        this.nombre=nombre;
        this.ventilador=ventilador;
        this.temperatura=temperatura;
        this.humedad=humedad;
        this.hora=hora;
        this.fecha=fecha;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVentilador() {
        return ventilador;
    }

    public void setVentilador(boolean ventilador) {
        this.ventilador = ventilador;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
