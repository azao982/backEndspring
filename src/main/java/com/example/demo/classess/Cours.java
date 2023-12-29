package com.example.demo.classess; // Note: Changed package name to "classes" to match your original post

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cours implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Use GenerationType.IDENTITY for auto-incremented primary key
    private Long id;

    private String nomDuCours;
    private String image;
    private double prix; // Changed type to double for storing prices as numbers

    // Default constructor
    public Cours() {}

    // Constructor with parameters
    public Cours(String nomDuCours, String image, double prix) {
        this.nomDuCours = nomDuCours;
        this.image = image;
        this.prix = prix;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomDuCours() {
        return nomDuCours;
    }

    public void setNomDuCours(String nomDuCours) {
        this.nomDuCours = nomDuCours;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
