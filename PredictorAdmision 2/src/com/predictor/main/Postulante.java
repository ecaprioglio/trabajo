/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

public class Postulante {
    private String nombre;
    private String rut;
    private String colegio;
    private SetPuntajes puntajes;

    public Postulante(String nombre, String rut, String colegio, SetPuntajes puntajes) {
        this.nombre = nombre;
        this.rut = rut;
        this.colegio = colegio;
        this.puntajes = puntajes;
    }

    public Postulante(String colegio, SetPuntajes puntajes) {
        this.nombre = "Simulado";
        this.rut = "N/A";
        this.colegio = colegio;
        this.puntajes = puntajes;
    }

    public String getNombre() { return nombre; }
    public String getRut() { return rut; }
    public String getColegio() { return colegio; }
    public SetPuntajes getPuntajes() { return puntajes; }
}
