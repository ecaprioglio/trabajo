/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalculadoraPuntajes {

    public double calcularPuntajeCorte(List<Postulante> simulados, Carrera carrera) {
        if (simulados == null || simulados.isEmpty()) {
            return 0.0;
        }

        List<Double> ponderados = simulados.stream()
                //mapea la lista y hac el puntaje posdetaro segun la carrera
                .map(p -> carrera.calcularPonderado(p.getPuntajes()))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        int indiceCorte = carrera.getVacantes() - 1;
        if (indiceCorte >= 0 && indiceCorte < ponderados.size()) {
            return ponderados.get(indiceCorte);
        }
        return 0.0;
    }

    public void aplicarBonoRanking(Postulante usuario) {
        final List<String> colegiosConBono = List.of(
            "colegio torreon",
            "colegio sagrado corazon",
            "colegio santa maria de maipu",
            "instituto portaleano",
            "colegio pedro de valdivia"
        );
        
        final double FACTOR_BONO = 1.05;
        String colegioUsuario = usuario.getColegio().toLowerCase().trim();
        
        if (colegiosConBono.contains(colegioUsuario)) {
            System.out.println("\n Bono de Ranking detectado para el colegio: " + usuario.getColegio());
            int rankingActual = usuario.getPuntajes().getRanking().getValor();
            int nuevoRanking = (int) (rankingActual * FACTOR_BONO);
            nuevoRanking = Math.min(1000, nuevoRanking);
            usuario.getPuntajes().getRanking().setValor(nuevoRanking);
        }
    }
}
