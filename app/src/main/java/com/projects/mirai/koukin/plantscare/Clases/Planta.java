package com.projects.mirai.koukin.plantscare.Clases;

import java.util.Date;

public class Planta {
    private String nombre;
    private boolean ventilador;
    private double temperatura;
    private double humedad;
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

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumedad() {
        return humedad;
    }

    public void setHumedad(double humedad) {
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
