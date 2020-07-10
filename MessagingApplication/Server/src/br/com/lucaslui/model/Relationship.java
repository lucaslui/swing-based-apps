/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucaslui.model;

/**
 *
 * @author lucas
 */
public class Relationship {

    private String id;
    private String username1;
    private String username2;

    public Relationship(String username1, String username2) {
        this.username1 = username1;
        this.username2 = username2;
    }

    public String getId() {
        return id;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
