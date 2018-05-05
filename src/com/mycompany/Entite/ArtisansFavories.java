/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author khale
 */
public class ArtisansFavories {
    
    int id_Artisansfav; 
    String 	nom  ; 
    String prenom ; 
    String NomBoutique;
    int id_User;
    int id_client;

    public ArtisansFavories(int id_Artisansfav, String nom, String prenom, String NomBoutique, int id_User) {
        this.id_Artisansfav = id_Artisansfav;
        this.nom = nom;
        this.prenom = prenom;
        this.NomBoutique = NomBoutique;
        this.id_User = id_User;
    }

    public ArtisansFavories(String nom, String prenom, String NomBoutique, int id_User) {
        this.nom = nom;
        this.prenom = prenom;
        this.NomBoutique = NomBoutique;
        this.id_User = id_User;
    }
    
    public ArtisansFavories(String nom, String prenom, String NomBoutique, int id_User , int id_client) {
        this.nom = nom;
        this.prenom = prenom;
        this.NomBoutique = NomBoutique;
        this.id_User = id_User;
        this.id_client = id_client;
    }
    
    public ArtisansFavories( String nom, String prenom, String NomBoutique) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.NomBoutique = NomBoutique;
       
    }

    
    
    

    public ArtisansFavories() {
    }

    public int getId_Artisansfav() {
        return id_Artisansfav;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomBoutique() {
        return NomBoutique;
    }

    public int getId_User() {
        return id_User;
    }
    
    

    public void setId_Artisansfav(int id_Artisansfav) {
        this.id_Artisansfav = id_Artisansfav;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNomBoutique(String NomBoutique) {
        this.NomBoutique = NomBoutique;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "ArtisansFavories{" + "id_Artisansfav=" + id_Artisansfav + ", nom=" + nom + ", prenom=" + prenom + ", NomBoutique=" + NomBoutique + ", id_User=" + id_User + ", id_client=" + id_client + '}';
    }
    
    

   
    
  
    
     
    
}
