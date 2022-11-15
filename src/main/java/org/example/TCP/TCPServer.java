package org.example.TCP;

import org.example.utils.Calculator;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String argv[]) throws Exception {

        /* Registra servico na porta 1234 e aguarda por conexoes */

        ServerSocket servidor = new ServerSocket(1234);
        System.out.println("Aguardando por conexoes");
        Socket conexao = servidor.accept();
        System.out.println("Cliente conectou " + conexao);


        /* Estabelece fluxos de entrada e saida */

        DataInputStream fluxoEntrada = new DataInputStream(new BufferedInputStream(conexao.getInputStream()));
        DataOutputStream fluxoSaida = new DataOutputStream(conexao.getOutputStream());


        /* inicia a comunicacao */

        String mensagem = fluxoEntrada.readUTF();
        System.out.println("Cliente> " + mensagem);

        Calculator calculator = new Calculator();

        fluxoSaida.writeUTF(String.valueOf(calculator.calculate(mensagem)));


        /* Fecha fluxos e socket */

        fluxoEntrada.close();
        fluxoSaida.close();
        conexao.close();
        servidor.close();

    }


}
