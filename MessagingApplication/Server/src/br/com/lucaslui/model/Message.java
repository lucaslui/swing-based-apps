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
public class Message {

    private String id;
    private String idRelationship;
    private String owner;
    private String datetime;
    private String text;

    public Message() {
    }

    public String getId() {
        return id;
    }
    
    public String getIdRelationship() {
        return idRelationship;
    }

    public void setIdRelationship(String idRelationship) {
        this.idRelationship = idRelationship;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
