package com.aplicativo;

import java.io.IOException;
import com.sockets.*;

public class ClienteSocket {
        public static void main(String[] args) throws IOException {
        Cliente clien = new Cliente(); //Se crea el servidor
        System.out.println("Iniciando servidor\n");
        clien.startClient();//Se inicia el servidor
    }
}
