/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 *
 * @author Mouafek
 */

public class Produit {
    
    private int id;
    private String  titre;
    private String NomCategorie;
    private int prix;
    private int quantite;
    private String couleur;
    private String image;
    private String description;
   
    ImageView imageprod;
    
    Button AjouterPanier;

    public Produit() {
    }
    
  
    
    public Produit(int id, String titre, int prix, String description, ImageView imageprod, Button AjouterPanier) {
        this.id = id;
        this.titre=titre;
        this.prix = prix;
        this.description = description;
        this.imageprod = imageprod;
        this.AjouterPanier = AjouterPanier;
    }
    
    

    public Produit(int id, String titre, String NomCategorie, int prix, int quantite, String couleur, String image, String description) {
        this.id = id;
        this.titre=titre;
        this.NomCategorie = NomCategorie;
        this.prix = prix;
        this.quantite = quantite;
        this.couleur = couleur;
        this.image = image;
        this.description = description;
    }
    
     public Produit(String titre, String NomCategorie, int prix, int quantite, String couleur, String image, String description) {
        this.titre=titre;
        this.NomCategorie = NomCategorie;
        this.prix = prix;
        this.quantite = quantite;
        this.couleur = couleur;
        this.image = image;
        this.description = description;
    }
     
     
     public Produit(String titre, String NomCategorie, int prix, int quantite, String couleur, String image, String description , int id) {
        this.titre=titre;
        this.NomCategorie = NomCategorie;
        this.prix = prix;
        this.quantite = quantite;
        this.couleur = couleur;
        this.image = image;
        this.description = description;
        this.id = id;
    }

  

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getNomCategorie() {
        return NomCategorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNomCategorie(String NomCategorie) {
        this.NomCategorie = NomCategorie;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public ImageView getImageprod() {
        return imageprod;
    }

    public void setImageprod(ImageView imageprod) {
        this.imageprod = imageprod;
    }

    public Button getAjouterPanier() {
        return AjouterPanier;
    }

    public void setAjouterPanier(Button AjouterPanier) {
        this.AjouterPanier = AjouterPanier;
    }
    
    
    
    
    

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", titre=" + titre + ", idcat=" + NomCategorie + ", prix=" + prix + ", quantite=" + quantite + ", couleur=" + couleur + ", image=" + image + ", description=" + description + '}';
    }
    
    
    
    
}
