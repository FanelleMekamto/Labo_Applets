package com.example.club.labo_applets;

/**
 * Created by club on 2016-11-11.
 */

public class Clubs {
    private int color;
    private String nom;
    private String local;

    public Clubs(int color, String nom, String local) {
        this.color = color;
        this.nom = nom;
        this.local = local;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
