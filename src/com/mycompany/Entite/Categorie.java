/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import javafx.scene.control.Button;

/**
 *
 * @author khale
 */
public class Categorie {
    
    
    String  nom_categorie ; 
    
    
    

    public Categorie(String nom_cat) {
        
        this.nom_categorie = nom_cat;
       
    }
    
    
    
    public Categorie()
    {
         
        
    }

   

    public String getNom_categorie() {
        return nom_categorie;
    }

   

    public void setNom_categorie(String nom_cat) {
        this.nom_categorie = nom_cat;
    }

    @Override
    public String toString() {
        return "Categorie{" + "nom_cat=" + nom_categorie + '}';
    }

   
    
    


    

  
    
}
