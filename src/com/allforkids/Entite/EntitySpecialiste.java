/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.allforkids.Entite;
import java.util.*;
/**
 *
 * @author amaln
 */
public class EntitySpecialiste {
    
    private int cin;

    private String nom;

    private String prenom;

    private String description;

 
    private Date dateNaissance;

   
    private String specialite;
  
    private int id;
  
    private  int telephone;

  
    private int numCabinet;

   
        private int rating;
    private String mail;

 
    private float lat;

   
    private String lng;
private String justif;

    public String getJustif() {
        return justif;
    }

    public void setJustif(String justif) {
        this.justif = justif;
    }

    
    private String municipalite;

   
    private String gouvernorat;

    private int etatverif;
    
    private String image;

    public EntitySpecialiste() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
    public EntitySpecialiste(int cin, String nom, String prenom, String description, Date dateNaissance, String specialite, int id, int telephone, int numCabinet, String mail, float lat, String lng, String municipalite, String gouvernorat, int etatverif) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.description = description;
        this.dateNaissance = dateNaissance;
        this.specialite = specialite;
        this.id = id;
        this.telephone = telephone;
        this.numCabinet = numCabinet;
        this.mail = mail;
        this.lat = lat;
        this.lng = lng;
        this.municipalite = municipalite;
        this.gouvernorat = gouvernorat;
        this.etatverif = etatverif;
    }

    public int getCin() {
        return cin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getSpecialite() {
        return specialite;
    }

    public int getId() {
        return id;
    }

    public int getTelephone() {
        return telephone;
    }

    public int getNumCabinet() {
        return numCabinet;
    }

    public String getMail() {
        return mail;
    }

    public float getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getMunicipalite() {
        return municipalite;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public int getEtatverif() {
        return etatverif;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setNumCabinet(int numCabinet) {
        this.numCabinet = numCabinet;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setMunicipalite(String municipalite) {
        this.municipalite = municipalite;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setEtatverif(int etatverif) {
        this.etatverif = etatverif;
    }
    
    
}
