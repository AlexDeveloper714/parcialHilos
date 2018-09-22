package com.sockets;

import java.io.*;
import java.net.*;

public class Conexion {

    private final int PUERTO = 1000;
    private final String HOST = "localhost";
    protected String mensajeServidor;
    protected ServerSocket ss;
    protected Socket cs;
    protected DataOutputStream salidaServidor, salidaCliente;

    public Conexion(String tipo) throws IOException {
        if (tipo.equalsIgnoreCase("servidor")) {
            ss = new ServerSocket(PUERTO);
            cs = new Socket();
        } else {
            cs = new Socket(HOST, PUERTO);
        }
    }
}
