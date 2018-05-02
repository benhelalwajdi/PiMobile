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
public class RatingBonplan {
    private int Id;
    private int Idbonplan;
   private int Rating;

    public RatingBonplan() {
    }

    public RatingBonplan(int Id, int Idbonplan, int Rating) {
        this.Id = Id;
        this.Idbonplan = Idbonplan;
        this.Rating = Rating;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdbonplan() {
        return Idbonplan;
    }

    public void setIdbonplan(int Idbonplan) {
        this.Idbonplan = Idbonplan;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }
   
}
