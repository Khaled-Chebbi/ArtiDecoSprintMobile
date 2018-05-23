/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import com.codename1.l10n.SimpleDateFormat;

/**
 *
 * @author lenovo
 */
public class User {
  public static  int connectedUser;
    private int idUtilisateur;

    private String nom;

    private String prenom;

    private SimpleDateFormat   datenaissance;

    private String email;

    private String numtel;

    private String typeUser;

    private String adresse;

    private String mdp;

    private String nomBoutique;
   
    private String status;

    public User(String nom, String prenom, String email, String numtel, String typeUser, String adresse, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numtel = numtel;
        this.typeUser = typeUser;
        this.adresse = adresse;
        this.mdp = mdp;
    }

    public User(int idUtilisateur, String email, String mdp) {
        this.idUtilisateur = idUtilisateur;
        this.email = email;
        this.mdp = mdp;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

    public SimpleDateFormat getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(SimpleDateFormat datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getEmail() {
        return email;
    }

    public User() {
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

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNomBoutique() {
        return nomBoutique;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(String nom, String prenom, SimpleDateFormat datenaissance, String email, String numtel, String typeUser, String adresse, String mdp, String nomBoutique, String status) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.email = email;
        this.numtel = numtel;
        this.typeUser = typeUser;
        this.adresse = adresse;
        this.mdp = mdp;
        this.nomBoutique = nomBoutique;
        this.status = status;
    }
    
    
    
    
}
