/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allforkids.Entite;

import java.util.Date;

/**
 *
 * @author Amine
 */
public class Conseil {
    private int Id;
    private String Titre;
    private String Contenu;
    private Date Date;
    

    public Conseil() {
    }

    public Conseil(int Id, String Titre, String Contenu, Date Date) {
        this.Id = Id;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.Date = Date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Conseil{" + "Id=" + Id + ", Titre=" + Titre + ", Contenu=" + Contenu + ", Date=" + Date + '}';
    }
    
}
