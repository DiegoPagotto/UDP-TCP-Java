package org.example.UDP;

import org.example.utils.Calculator;

import java.net.*;

public class ServidorUDP {
    public static void main(String args[]) throws Exception {
        int porta = 9876;
        int numConn = 1;

        DatagramSocket serverSocket = new DatagramSocket(porta);

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("Esperando por datagrama UDP na porta " + porta);

            serverSocket.receive(receivePacket);
            System.out.print("Datagrama UDP [" + numConn + "] recebido...");

            String sentence = new String(receivePacket.getData());
            Calculator calculator = new Calculator();
            String result = String.valueOf(calculator.calculate(sentence));

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            sendData = result.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            System.out.print("Enviando " + result + "...");

            serverSocket.send(sendPacket);

            System.out.println("OK\n");

        }

    }
}
