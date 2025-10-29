/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

public class Medicina extends Carrera {
    public Medicina() {
        super("Medicina", 20);
    }

    @Override
    public double calcularPonderado(SetPuntajes p) {
        return (p.getCiencias().getValor() * 0.40) +
               (p.getM1().getValor() * 0.20) +
               (p.getCl().getValor() * 0.15) +
               (p.getNem().getValor() * 0.15) +
               (p.getRanking().getValor() * 0.10);
    }
}
