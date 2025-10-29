/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

public class ReporteFinal {
    public void mostrar(Postulante usuario, Carrera carrera, double puntajeUsuario, double puntajeCorte, String resultado) {
        System.out.println("\n--- RESUMEN DE POSTULACIÓN ---");
        System.out.println("=================================================");
        System.out.println("Postulante: " + usuario.getNombre());
        System.out.println("RUT: " + usuario.getRut());
        System.out.println("Colegio: " + usuario.getColegio());
        System.out.println("Carrera Seleccionada: " + carrera.getNombre());
        System.out.println("-------------------------------------------------");
        System.out.printf("Tu Puntaje Ponderado Final: %.2f\n", puntajeUsuario);
        System.out.printf("Puntaje de Corte (calculado con %d vacantes): %.2f\n", carrera.getVacantes(), puntajeCorte);
        System.out.println("-------------------------------------------------");
        
        if (resultado.equals("ACEPTADO")) {
            System.out.println("¡FELICITACIONES, HAS SIDO ACEPTADO!");
            System.out.printf("Tu puntaje de %.2f es mayor o igual al puntaje de corte de %.2f.\n", puntajeUsuario, puntajeCorte);
        } else {
            System.out.println("Veredicto: RECHAZADO");
            System.out.printf("Tu puntaje de %.2f no alcanza el puntaje de corte de %.2f.\n", puntajeUsuario, puntajeCorte);
            System.out.printf("La diferencia fue de %.2f puntos.\n", puntajeCorte - puntajeUsuario);
        }
        
    }
}
