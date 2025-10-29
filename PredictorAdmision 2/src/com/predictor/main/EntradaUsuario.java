/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.predictor.main;

import java.util.Scanner;

public class EntradaUsuario {
    private final Scanner scanner = new Scanner(System.in);

    public Postulante obtenerDatosPostulante() {
        System.out.println("---Ingreso de Datos del Postulante ---");
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("RUT (ej: 12345678-9): ");
        String rut = scanner.nextLine();
        System.out.print("Nombre de tu colegio: ");
        String colegio = scanner.nextLine();

        System.out.println("\n---Ingreso de Puntajes ---");
        int cl = leerPuntaje("Comprensión Lectora (CL): ");
        int m1 = leerPuntaje("Matemáticas 1 (M1): ");
        int m2 = leerPuntaje("Matemáticas 2 (M2): ");
        int ci = leerPuntaje("Ciencias: ");
        int hi = leerPuntaje("Historia (HI): ");
        int nem = leerPuntaje("Notas de Enseñanza Media (NEM): ");
        int ran = leerPuntaje("Ranking de Notas: ");

        SetPuntajes puntajes = new SetPuntajes(cl, m1, m2, ci, hi, nem, ran); 
        return new Postulante(nombre, rut, colegio, puntajes);
    }
    
    public Carrera elegirCarrera() {
        System.out.println("\n---Selección de Carrera ---");
        System.out.println("1. Ingeniería");
        System.out.println("2. Derecho");
        System.out.println("3. Medicina");
        
        int opcion = 0;
        while (opcion < 1 || opcion > 3) {
            System.out.print("Ingresa el número de la carrera a la que postulas: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > 3) System.out.println("Opción no válida.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            }
        }

        switch (opcion) {
            case 1: return new Ingenieria();
            case 2: return new Derecho();
            case 3: return new Medicina();
            default: return null;
        }
    }

    private int leerPuntaje(String mensaje) {
        int puntaje = 0;
        while (puntaje < 100 || puntaje > 1000) {
            System.out.print(mensaje);
            try {
                puntaje = Integer.parseInt(scanner.nextLine());
                if (puntaje < 100 || puntaje > 1000) {
                    System.out.println("Puntaje inválido. Debe estar entre 100 y 1000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            }
        }
        return puntaje;
    }
}