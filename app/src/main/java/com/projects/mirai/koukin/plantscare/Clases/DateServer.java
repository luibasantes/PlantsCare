package com.projects.mirai.koukin.plantscare.Clases;

public class DateServer {
    String dia;
    String mes;
    String anio;
    String hora;
    String minutos;
    String segundos;
    String milisegundos;


    public DateServer(String dia, String mes, String anio, String hora, String minutos, String segundos, String milisegundos) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
        this.milisegundos = milisegundos;
    }
    public DateServer(){
        this.dia = "";
        this.mes = "";
        this.anio = "";
        this.hora = "";
        this.minutos = "";
        this.segundos = "";
        this.milisegundos = "";

    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(String segundos) {
        this.segundos = segundos;
    }

    public void setMilisegundos(String milisegundos) {
        this.milisegundos = milisegundos;
    }
    public void formatearFecha(String fechaCompleta){

        String [] fechaPartida= fechaCompleta.split("T");
        String [] fechaPartida2 = fechaPartida[0].split("-");
        this.anio=fechaPartida2[0];
        this.mes=fechaPartida2[1];
        this.dia=fechaPartida2[2];

        fechaPartida2 = fechaPartida[1].split(":");
        this.hora=fechaPartida2[0];
        this.minutos=fechaPartida2[1];
        System.out.println(fechaPartida2[2]);
        this.segundos=fechaPartida2[2].substring(0,2);
    }
    public String getFechaString(){
        return this.dia + "/" + this.mes + "/" + this.anio;
    }

    public String getHoraCompletaString(){ return this.hora + ":" + this.minutos + ":" + this.segundos; }
}
