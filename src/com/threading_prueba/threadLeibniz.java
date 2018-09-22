package com.threading_prueba;

import java.util.Scanner;

class threadPrueba_2 extends Thread {

    public static int contador;
    public static int ciclos;
    public static float pi_2;

    @Override
    public void run() {
        int total = 0;
        Scanner lectura = new Scanner(System.in);
        contador = 0;
        System.out.println("Digite la cantidad de ciclos a realizar");
        total = lectura.nextInt();
        for (int i = 0; i < total; i++) {
            if (i % 2 == 0) {
                puntoPositivo(i, pi_2);
            } else {
                puntoNegativo(i, pi_2);
            }
            contador++;
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pi: " + pi_2);
    }

    public void puntoNegativo(int a, float pi) {
        pi -= (float) (4 / ((2 * a) + 1));
    }

    public void puntoPositivo(int a, float pi) {
        pi += (float) (4 / ((2 * a) + 1));
    }

}

public class threadLeibniz {

    public void calcularLeibniz() {
        threadPrueba_2 pruebas = new threadPrueba_2();
        pruebas.run();
    }

    public static void main(String[] args) {
        threadPrueba_2 pruebas = new threadPrueba_2();
        pruebas.run();
    }
}
