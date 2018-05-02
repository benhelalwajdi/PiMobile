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
public class Recette {
    
    private int Id;
    private String Nom;
    private String Ingredients;
    private String Nom_img;
    private String Nom_vid;
    private int Nbrpersonnes; 
    private int Nbrlikes; 
    private int Nbrdislikes; 

    public Recette(int Id, String Nom, String Ingredients, String Nom_img, String Nom_vid, int Nbrpersonnes, int Nbrlikes, int Nbrdislikes) {
        this.Id = Id;
        this.Nom = Nom;
        this.Ingredients = Ingredients;
        this.Nom_img = Nom_img;
        this.Nom_vid = Nom_vid;
        this.Nbrpersonnes = Nbrpersonnes;
        this.Nbrlikes = Nbrlikes;
        this.Nbrdislikes = Nbrdislikes;
    }

    public int getNbrlikes() {
        return Nbrlikes;
    }

    public void setNbrlikes(int Nbrlikes) {
        this.Nbrlikes = Nbrlikes;
    }

    public int getNbrdislikes() {
        return Nbrdislikes;
    }

    public void setNbrdislikes(int Nbrdislikes) {
        this.Nbrdislikes = Nbrdislikes;
    }
    

    
    
    public Recette() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String Ingredients) {
        this.Ingredients = Ingredients;
    }

    public String getNom_img() {
        return Nom_img;
    }

    public void setNom_img(String Nom_img) {
        this.Nom_img = Nom_img;
    }

    public String getNom_vid() {
        return Nom_vid;
    }

    public void setNom_vid(String Nom_vid) {
        this.Nom_vid = Nom_vid;
    }

    public int getNbrpersonnes() {
        return Nbrpersonnes;
    }

    public void setNbrpersonnes(int Nbrpersonnes) {
        this.Nbrpersonnes = Nbrpersonnes;
    }

    @Override
    public String toString() {
        return "Recette{" + "Id=" + Id + ", Nom=" + Nom + ", Ingredients=" + Ingredients + ", Nom_img=" + Nom_img + ", Nom_vid=" + Nom_vid + ", Nbrpersonnes=" + Nbrpersonnes + '}';
    }
    
    
}
