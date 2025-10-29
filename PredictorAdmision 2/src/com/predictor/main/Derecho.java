/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

public class Derecho extends Carrera {
    public Derecho() {
        super("Derecho", 50);
    }

    @Override
    public double calcularPonderado(SetPuntajes p) {
        return (p.getCl().getValor() * 0.30) +
               (p.getHistoria().getValor() * 0.30) +
               (p.getNem().getValor() * 0.15) +
               (p.getRanking().getValor() * 0.15) +
               (p.getM1().getValor() * 0.10);
    }
}