/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

public class SetPuntajes {
    private final PuntajeCL cl;
    private final PuntajeM1 m1;
    private final PuntajeM2 m2;
    private final PuntajeCiencias ciencias;
    private final PuntajeHistoria historia; 
    private final PuntajeNEM nem;
    private final PuntajeRanking ranking;

    public SetPuntajes(int cl, int m1, int m2, int ciencias, int historia, int nem, int ranking) {
        this.cl = new PuntajeCL(cl);
        this.m1 = new PuntajeM1(m1);
        this.m2 = new PuntajeM2(m2);
        this.ciencias = new PuntajeCiencias(ciencias);
        this.historia = new PuntajeHistoria(historia); 
        this.nem = new PuntajeNEM(nem);
        this.ranking = new PuntajeRanking(ranking);
    }

    // Getters
    public PuntajeCL getCl() { return cl; }
    public PuntajeM1 getM1() { return m1; }
    public PuntajeM2 getM2() { return m2; }
    public PuntajeCiencias getCiencias() { return ciencias; }
    public PuntajeHistoria getHistoria() { return historia; } 
    public PuntajeNEM getNem() { return nem; }
    public PuntajeRanking getRanking() { return ranking; }
}