package com.threading_prueba;

import java.util.Scanner;

class threadPrueba_4 extends Thread {

    public static float[] valores;
    public static int ciclos;
    public static boolean verificacion;

    @Override
    public void run() {
        Scanner lectura = new Scanner(System.in);
        double a, b, c;
        System.out.println("Digite el valor de A");
        a = lectura.nextDouble();
        System.out.println("Digite el valor de B");
        b = lectura.nextDouble();
        System.out.println("Digite el valor de C");
        c = lectura.nextDouble();
        valores = calcularCuadratica(a, b, c);
        if (verificacion) {
            System.out.println("Valores cuadratica: X-1: " + valores[0] + " X-2: " + valores[1]);
        } else {
            System.out.println("Valores cuadratica Invalidos");

        }
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

public class threadCuadratica {

    public static void main(String[] args) {
        threadPrueba_4 pruebas = new threadPrueba_4();
        pruebas.run();
    }

    public void calcularCuadratica() {
        threadPrueba_4 pruebas = new threadPrueba_4();
        pruebas.run();

    }
}
