/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucaslui.logic;

/**
 *
 * @author lucas
 */
public class Main {
    public static void main(String[] args) {
        Thread receiver = new Thread(new ReceiverThread());
        receiver.start();
    }
}
