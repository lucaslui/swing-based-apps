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
public class ReceiverThread implements Runnable {

    @Override
    public void run() {
        new Communication().receiveMessage();
    }

}
