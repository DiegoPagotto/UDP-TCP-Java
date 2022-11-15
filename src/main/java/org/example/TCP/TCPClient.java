package org.example.TCP;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String argv[]) throws Exception {

        int porta = 1234;
        String ip = "127.0.0.1";
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        /* Estabele conexao com o servidor */

        Socket conexao = new Socket(ip, porta);
        System.out.println("Conectado! " + conexao);


        /* Estabelece fluxos de entrada e saida */

        DataOutputStream fluxoSaida = new DataOutputStream(conexao.getOutputStream());
        DataInputStream fluxoEntrada = new DataInputStream(new BufferedInputStream(conexao.getInputStream()));


        /* Inicia comunicacao */

        System.out.println("Digite o texto a ser enviado ao servidor: ");
        String sentence = inFromUser.readLine();
        fluxoSaida.writeUTF(sentence);
        fluxoSaida.flush();
        String mensagem = fluxoEntrada.readUTF();
        System.out.println("Servidor> " + mensagem);


        /* Fecha fluxos e socket */

        fluxoSaida.close();
        fluxoEntrada.close();
        conexao.close();


    }
}
