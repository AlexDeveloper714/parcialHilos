package com.sockets;

import com.threading_prueba.threadCuadratica;
import com.threading_prueba.threadLeibniz;
import com.threading_prueba.threadTextoCuadratica;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{

    public static boolean validacion = true;

    public Servidor() throws IOException {
        super("servidor");
    } //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try {
            System.out.println("Esperando..."); //Esperando conexión
            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            System.out.println("Cliente en línea");
//Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());
//Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");
//Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            while ((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
            {
//Se muestra por pantalla el mensaje recibido
                System.out.println(mensajeServidor);
            }
            System.out.println("Fin de la conexión");
            ss.close();//Se finaliza la conexión con el cliente
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void calcularPiHilos() {
        threadLeibniz leibniz= new threadLeibniz();
        leibniz.calcularLeibniz();
    }

    public static void calcularCuadraticaHilos() {
        threadCuadratica cuadratica = new threadCuadratica();
        cuadratica.calcularCuadratica();
    }

    public static void leerTextoHilos() {
        threadTextoCuadratica texto = new threadTextoCuadratica();
        texto.calcularTextoCuadraticas();
    }

    public static float calcularPi(int a) {
        float pi = 4;
        if (a <= 0) {
            System.out.println("Digite bien las opciones");
            pi = 0;
        } else {
            while (a > 0) {
                if (a % 2 == 0) {
                    pi += (float) (4 / ((2 * a) + 1));
                } else {
                    pi -= (float) (4 / ((2 * a) + 1));
                }
                a--;
            }
        }
        return pi;
    }

    public static float[] calcularCuadratica(double a, double b, double c) {
        float[] seCalcula = new float[2];
        if (a == 0) {
            validacion = false;
        } else {
            validacion = true;
        }
        seCalcula[0] = (float) (((-b) + Math.pow(Math.pow(b, 2) - (4 * a * c), (1 / 2))) / (2 * a));
        seCalcula[1] = (float) (((-b) - Math.pow(Math.pow(b, 2) - (4 * a * c), (1 / 2))) / (2 * a));
        return seCalcula;
    }
}
