/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

public abstract class Carrera {
    protected String nombre;
    protected int vacantes;

    public Carrera(String nombre, int vacantes) {
        this.nombre = nombre;
        this.vacantes = vacantes;
    }

    public String getNombre() { return nombre; }
    public int getVacantes() { return vacantes; }

    public abstract double calcularPonderado(SetPuntajes puntajes);
}
