/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

public class Ingenieria extends Carrera {
    public Ingenieria() {
        super("Ingenieria", 62);
    }

    @Override
    public double calcularPonderado(SetPuntajes p) {
        int puntajeElectivo = Math.max(p.getCiencias().getValor(), p.getHistoria().getValor());

        return (p.getM1().getValor() * 0.40) +
               (p.getM2().getValor() * 0.20) +
               (p.getCl().getValor() * 0.10) +
               (puntajeElectivo * 0.10) + 
               (p.getNem().getValor() * 0.10) +
               (p.getRanking().getValor() * 0.10);
    }
}
