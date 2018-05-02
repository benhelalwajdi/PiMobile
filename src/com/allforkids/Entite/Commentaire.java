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
public class Commentaire {
    private int Id;
    private int Iduser;
    private int Idconseil;
    private String Texte;
    private String Nomuser;
    
    public Commentaire() {
    }

    public Commentaire(int Id, int Iduser, int Idconseil, String Texte, String Nomuser) {
        this.Id = Id;
        this.Iduser = Iduser;
        this.Idconseil = Idconseil;
        this.Texte = Texte;
        this.Nomuser=Nomuser;
    }

    public String getNomuser() {
        return Nomuser;
    }

    public void setNomuser(String Nomuser) {
        this.Nomuser = Nomuser;
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

    public int getIdconseil() {
        return Idconseil;
    }

    public void setIdconseil(int Idconseil) {
        this.Idconseil = Idconseil;
    }

    public String getTexte() {
        return Texte;
    }

    public void setTexte(String Texte) {
        this.Texte = Texte;
    }
    
}
