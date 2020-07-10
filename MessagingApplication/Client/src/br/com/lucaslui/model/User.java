/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucaslui.model;

import java.io.Serializable;

/**
 *
 * @author lucas
 */
public class User implements Serializable {

    private String username;
    private String password;
    private String age;
    private String genre;

    public User() {
    }

    public User(String username, String password, String age, String genre) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.genre = genre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
