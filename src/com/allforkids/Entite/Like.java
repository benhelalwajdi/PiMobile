/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allforkids.Entite;

/**
 *
 * @author Amine
 */
public class Like {
    private int Id;
    private int Iduser;
    private int Idrecette;
    private int Etat;

    public Like() {
    }

    public Like(int Id, int Iduser, int Idrecette, int Etat) {
        this.Id = Id;
        this.Iduser = Iduser;
        this.Idrecette = Idrecette;
        this.Etat = Etat;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIduser() {
        return Iduser;
    }

    public void setIduser(int Iduser) {
        this.Iduser = Iduser;
    }

    public int getIdrecette() {
        return Idrecette;
    }

    public void setIdrecette(int Idrecette) {
        this.Idrecette = Idrecette;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int Etat) {
        this.Etat = Etat;
    }
    
    
    
}
