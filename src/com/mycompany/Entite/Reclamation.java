/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author Manel
 */
public class Reclamation {
        int id_reclamation;
    	int id_Client;
        String description;
        Date date_rec ;
        String etat_rec;
        
        
        String nomClient;
        
        public Reclamation()
        {
            
        }

    public Reclamation(int id_reclamation, int id_Client, String description, Date date_rec, String etat_rec) {
        this.id_reclamation = id_reclamation;
        this.id_Client = id_Client;
        this.description = description;
        this.date_rec = date_rec;
        this.etat_rec = etat_rec;
    }
    
    public Reclamation(int id_reclamation, String nomClient, String description, Date date_rec, String etat_rec) {
        this.id_reclamation = id_reclamation;
        this.nomClient = nomClient;
        this.description = description;
        this.date_rec = date_rec;
        this.etat_rec = etat_rec;
    }
    
    
     public Reclamation(int id_Client, String description, Date date_rec, String etat_rec) {
        this.id_Client = id_Client;
        this.description = description;
        this.date_rec = date_rec;
        this.etat_rec = etat_rec;
    }
     
     
     public Reclamation(String description) {
      
        this.description = description;
       
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }

    public String getEtat_rec() {
        return etat_rec;
    }

    public void setEtat_rec(String etat_rec) {
        this.etat_rec = etat_rec;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
    
    
    

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", id_Client=" + id_Client + ", description=" + description + ", date_rec=" + date_rec + ", etat_rec=" + etat_rec + '}';
    }
    
    
    
    
        
        
        

    }
