/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaDeAdmision {
    private final LectorDatosSimulados lector;
    private final EntradaUsuario entrada;
    private final CalculadoraPuntajes calculadora;
    private final ReporteFinal reporte;
    private final Map<String, List<Postulante>> datosSimulados;

    public SistemaDeAdmision() {
        this.lector = new LectorDatosSimulados();
        this.entrada = new EntradaUsuario();
        this.calculadora = new CalculadoraPuntajes();
        this.reporte = new ReporteFinal();
        this.datosSimulados = new HashMap<>();
    }


    public void iniciar() {
        lector.leerArchivo(datosSimulados);
        Postulante usuario = entrada.obtenerDatosPostulante();
        Carrera carreraElegida = entrada.elegirCarrera();
        
        calculadora.aplicarBonoRanking(usuario);
        
        List<Postulante> simuladosParaCarrera = datosSimulados.get(carreraElegida.getNombre());
        double puntajeCorte = calculadora.calcularPuntajeCorte(simuladosParaCarrera, carreraElegida);
        double puntajeUsuario = carreraElegida.calcularPonderado(usuario.getPuntajes());
        
        String resultado = (puntajeUsuario >= puntajeCorte) ? "ACEPTADO" : "RECHAZADO";
        
        reporte.mostrar(usuario, carreraElegida, puntajeUsuario, puntajeCorte, resultado);
    }
}
