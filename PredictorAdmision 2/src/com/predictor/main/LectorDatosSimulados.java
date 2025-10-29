/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LectorDatosSimulados {
    private static final String NOMBRE_ARCHIVO = "salida.txt";

    public void leerArchivo(Map<String, List<Postulante>> datosPorCarrera) {
        String seccionActual = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("// ---")) {
                    seccionActual = extraerNombreSeccion(linea);
                    datosPorCarrera.put(seccionActual, new ArrayList<>());
                    reader.readLine();
                    continue;
                }

                if (!seccionActual.isEmpty() && !linea.isEmpty()) {
                    try {
                        String[] partes = linea.split(",");
                        String colegio = partes[0].trim();
                        int cl = Integer.parseInt(partes[1].trim());
                        int m1 = Integer.parseInt(partes[2].trim());
                        int m2 = Integer.parseInt(partes[3].trim());
                        int ci = Integer.parseInt(partes[4].trim());
                        int hi = Integer.parseInt(partes[5].trim());
                        int nem = Integer.parseInt(partes[6].trim());
                        int ran = Integer.parseInt(partes[7].trim());
                        SetPuntajes puntajes = new SetPuntajes(cl, m1, m2, ci, hi, nem, ran); 
                        datosPorCarrera.get(seccionActual).add(new Postulante(colegio, puntajes));
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error fatal: No se pudo leer el archivo '" + NOMBRE_ARCHIVO + "'.");
            System.err.println("Asegúrate de que el archivo generado por el programa C esté en la raíz del proyecto.");
            System.exit(1);
        }
    }

    private String extraerNombreSeccion(String linea) {
        if (linea.contains("INGENIERIA")) return "Ingenieria";
        if (linea.contains("MEDICINA")) return "Medicina";
        if (linea.contains("DERECHO")) return "Derecho";
        return "";
    }
}
