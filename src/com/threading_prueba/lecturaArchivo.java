package com.threading_prueba;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lecturaArchivo {

    public static int Lineas = 0;
    public static int ConteoPalabras = 0;
    public static String textoCopia = "";
    public static String textoOriginal = "";
    public static String salidaTexto = "";

    public void reiniciarVariables() {
        Lineas = 0;
        ConteoPalabras = 0;
        textoCopia = "";
        textoOriginal = textoCopia;
        salidaTexto = textoCopia;
    }

    public void empezarCodigo(String ruta, String patron) throws FileNotFoundException {
        leerLineas(ruta);
        if (Lineas > 0) {
            textoOriginal = obtenerDatos(ruta);
            //
        }
    }


    public static void leerLineas(String ruta) throws FileNotFoundException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        archivo = new File(ruta);
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
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
        try {

            int cantidadLineas = 0;
            while ((linea = br.readLine()) != null) {
                if (cantidadLineas < Lineas) {
                    texto += linea + "\n";
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
//OK

    public static int contarCaracteres(String patron, String texto) {
        int cantidad = 0;
        if (texto.contains(patron)) {
            textoCopia = texto.replaceAll(patron, "-");
            for (int i = 0; i < textoCopia.length(); i++) {
                if (textoCopia.charAt(i) == '-') {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }
}
