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
public class Bonplan {
    private int Id;
    private String Categorie;
    private String Region;
    private String Adresse;
    private String Nom;
    private String Nom_image;
    private float Lat;
    private float Lng;
    private String Description;
    private float Rat;

    public Bonplan() {
    }

    public Bonplan(int Id, String Categorie, String Region, String Adresse, String Nom, String Nom_image, float Lat, float Lng, String Description, float Rat) {
        this.Id = Id;
        this.Categorie = Categorie;
        this.Region = Region;
        this.Adresse = Adresse;
        this.Nom = Nom;
        this.Nom_image = Nom_image;
        this.Lat = Lat;
        this.Lng = Lng;
        this.Description = Description;
        this.Rat = Rat;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getNom_image() {
        return Nom_image;
    }

    public void setNom_image(String Nom_image) {
        this.Nom_image = Nom_image;
    }

    public float getLat() {
        return Lat;
    }

    public void setLat(float Lat) {
        this.Lat = Lat;
    }

    public float getLng() {
        return Lng;
    }

    public void setLng(float Lng) {
        this.Lng = Lng;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getRat() {
        return Rat;
    }

    public void setRat(float Rat) {
        this.Rat = Rat;
    }

    @Override
    public String toString() {
        return "Bonplan{" + "Id=" + Id + ", Categorie=" + Categorie + ", Region=" + Region + ", Adresse=" + Adresse + ", Nom=" + Nom + ", Nom_image=" + Nom_image + ", Lat=" + Lat + ", Lng=" + Lng + ", Description=" + Description + ", Rat=" + Rat + '}';
    }
    

    

}
