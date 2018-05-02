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
public class Blague {
    private int Id;
    private String Titre;
    private String Description;
    private Date Date;
    public Blague(int Id, String Titre, String Description, Date Date) {
        this.Id = Id;
        this.Titre = Titre;
        this.Description = Description;
        this.Date = Date;
    }

    public Blague() {
    }

    @Override
    public String toString() {
        return "Blague{" + "Id=" + Id + ", Titre=" + Titre + ", Description=" + Description + ", Date=" + Date + '}';
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }
    
    
    
}
