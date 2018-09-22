package com.threading_prueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class threadPrueba_3 extends Thread {

    public static int Lineas = 0;
    public static Double[] leibnizMatriz = null;
    public static boolean verificacion;
    public static float[] valores;

    @Override
    public void run() {
        try {
            Scanner lectura = new Scanner(System.in);
            System.out.println("Digite la ruta del archivo:");
            String ruta = lectura.nextLine();
            empezarCodigo(ruta);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(threadPrueba_3.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void empezarCodigo(String ruta) throws FileNotFoundException {
        leerLineas(ruta);
        if (Lineas > 0) {
            obtenerDatos(ruta);
        }
        for (int i = 0; i < Lineas; i++) {

        }
    }

    public static void leerLineas(String ruta) throws FileNotFoundException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        archivo = new File(ruta);
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        leibnizMatriz = new Double[3];
        try {
            String linea;
            while ((linea = br.readLine()) != null) {

                int longitud = 0;
                if (longitud < linea.length()) {
                    longitud = linea.length();
                }
                Lineas++;
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//OK

    public static String obtenerDatos(String ruta) throws FileNotFoundException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        archivo = new File(ruta);
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        String linea;
        String texto = "";
        leibnizMatriz = new Double[3];
        String[] leibnizMatrizTexto;
        try {
            int cantidadLineas = 0;
            while ((linea = br.readLine()) != null) {
                leibnizMatrizTexto = linea.trim().split(",");
                if (leibnizMatrizTexto.length == 3) {
                    for (int i = 0; i < leibnizMatrizTexto.length; i++) {
                        leibnizMatriz[i] = Double.parseDouble(leibnizMatrizTexto[i]);
                    }
                    valores = calcularCuadratica(leibnizMatriz[0], leibnizMatriz[1], leibnizMatriz[2]);
                    if (verificacion) {
                        System.out.println("Valores cuadratica: X-1: " + valores[0] + " X-2: " + valores[1]);
                    } else {
                        System.out.println("Valores cuadratica Invalidos");

                    }
                    //Pasar parametros
                } else {
                    break;
                }
                cantidadLineas++;
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return texto;
    }

    public static float[] calcularCuadratica(double a, double b, double c) {
        float[] seCalcula = new float[2];
        if (a == 0) {
            verificacion = false;
        } else {
            verificacion = true;
        }
        seCalcula[0] = (float) (((-b) + Math.pow(Math.pow(b, 2) - (4 * a * c), (1 / 2))) / (2 * a));
        seCalcula[1] = (float) (((-b) - Math.pow(Math.pow(b, 2) - (4 * a * c), (1 / 2))) / (2 * a));
        return seCalcula;
    }

}

public class threadTextoCuadratica {

    public static void main(String[] args) {
        threadPrueba_3 pruebas = new threadPrueba_3();
        pruebas.run();
    }

    public void calcularTextoCuadraticas() {
        threadPrueba_3 pruebas = new threadPrueba_3();
        pruebas.run();

    }
}
