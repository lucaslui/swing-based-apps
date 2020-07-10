/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucaslui.logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Communication {

    private String host = "127.0.0.1";
    private int port = 9998;

    public void sendMessage(String message) {

        try (Socket socket = new Socket(host, port);
                DataOutputStream data = new DataOutputStream(socket.getOutputStream())) {
            data.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void receiveMessage() {

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                try (Socket socket = serverSocket.accept();
                        DataInputStream data = new DataInputStream(socket.getInputStream())) {
                    System.out.println(data.readUTF());
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
