package com.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cliente extends Conexion {

    public Cliente() throws IOException {
        super("cliente");
    } //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try {
//Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            Scanner lectura = new Scanner(System.in);
            Scanner lecturaDecimal = new Scanner(System.in);
            int opciones = 0, ciclos = 0;
            double a, b, c; 
                    float pi;
            float[] raices = new float[2];
            while (opciones != 4) {
                System.out.println("\nDigite las opciones a desarrollar: "
                        + "\n1. Calcular Pi"
                        + "\n2. Calcular con la función cuadratica"
                        + "\n3. Lectura de archivos"
                        + "\n4. Salir");
                opciones = lectura.nextInt();
                switch (opciones) {
                    case 1:
                        //Calculo Pi
                        Servidor.calcularPiHilos();
                        break;
                    case 2:
                        Servidor.calcularCuadraticaHilos();
                        break;
                    case 3:
                        Servidor.leerTextoHilos();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Digita opciones validas");
                        break;
                }
            }
            salidaServidor.writeUTF("Digite la cantidad de ciclos para calcular Pi:");

//            for (int i = 0; i < 2; i++) {
////Se escribe en el servidor usando su flujo de datos
//                salidaServidor.writeUTF("Este es el mensaje número " + (i + 1) + "\n");
//            }
            cs.close();//Fin de la conexión
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
