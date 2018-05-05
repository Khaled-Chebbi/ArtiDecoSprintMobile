/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author khaled Chebbi
 */
public class Utilisateur {
    

    int id_utilisateur ; 
    String 	nom  ; 
    String prenom ; 
    
    
    Date datenaissance ;
    String email;
    String numtel ;
    String type_user  ;
    String adresse ; 
    String NomBoutique;
    String mdp ;

    String status ;

    public Utilisateur() {
    }
    
    

    public Utilisateur(int id_utilisateur, String nom, String prenom, Date datenaissance, String email, String numtel, String type_user, String adresse, String mdp, String NomBoutique, String status) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.email = email;
        this.numtel = numtel;
        this.type_user = type_user;
        this.adresse = adresse;
        this.mdp = mdp;
        this.NomBoutique = NomBoutique;
        this.status = status;
    }
    
    
    
    
    
    public Utilisateur(int id_utilisateur, String nom, String prenom, String email, String numtel, String adresse, String NomBoutique) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numtel = numtel;
        this.adresse = adresse;
        this.NomBoutique = NomBoutique;
     
    }
    
    
    
    
        public Utilisateur(int id_utilisateur , String status ) {
         this.id_utilisateur = id_utilisateur;
        this.status = status;
       
        
         }
    
    
    
    
    
    public Utilisateur(String nom, String prenom, Date datenaissance, String email, String numtel, String type_user, String adresse, String mdp ,String NomBoutique, String status) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.email = email;
        this.numtel = numtel;
        this.type_user = type_user;
        this.adresse = adresse;
        this.mdp = mdp;
        this.NomBoutique = NomBoutique;
        this.status = status;
    }

    
    public Utilisateur(int id_utilisateur , String nom, String prenom, String NomBoutique)
    {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        
        this.NomBoutique = NomBoutique;
    }
    
  
    public Utilisateur(String nom, String prenom, Date datenaissance, String email, String numtel, String adresse, String mdp) 
    {
        
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.email = email;
        this.numtel = numtel;
        this.adresse = adresse;
        this.mdp = mdp;
       
    }

    
    public Utilisateur(String nom, String prenom, Date datenaissance, String email, String numtel, String type_user , String adresse, String mdp, String NomBoutique) 
    {
        
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.email = email;
        this.numtel = numtel;
        this.type_user = type_user;
        this.adresse = adresse;
        this.mdp = mdp;
        this.NomBoutique = NomBoutique;
       
    }
    
    public Utilisateur(String nom, String prenom, Date datenaissance, String email, String numtel, String type_user , String adresse, String mdp) 
    {
        
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.email = email;
        this.numtel = numtel;
        this.type_user = type_user;
        this.adresse = adresse;
        this.mdp = mdp;
        
       
    }
    
    
     public Utilisateur(int id_utilisateur, String nom, String prenom, String adresse, String NomBoutiques) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.NomBoutique = NomBoutique;
    
    }
    
   

        public int getId_utilisateur() {
            return id_utilisateur;
        }

        public void setId_utilisateur(int id_utilisateur) {
            this.id_utilisateur = id_utilisateur;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public Date getDatenaissance() {
            return datenaissance;
        }

        public void setDatenaissance(Date datenaissance) {
            this.datenaissance = datenaissance;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNumtel() {
            return numtel;
        }

        public void setNumtel(String numtel) {
            this.numtel = numtel;
        }

        public String getType_user() {
            return type_user;
        }

        public void setType_user(String type_user) {
            this.type_user = type_user;
        }

        public String getAdresse() {
            return adresse;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public String getNomBoutique() {
            return NomBoutique;
        }

        public void setNomBoutique(String NomBoutique) {
            this.NomBoutique = NomBoutique;
        }

        public String getMdp() {
            return mdp;
        }

        public void setMdp(String mdp) {
            this.mdp = mdp;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    
    
    

    
    
}
    
