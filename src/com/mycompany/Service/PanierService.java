/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.mycompany.Entite.Produit;
import com.mycompany.Entite.Produits;


/**
 *
 * @author jean
 */
public class PanierService {
    
      public void ajouterPanier(Produits p) {
        ConnectionRequest con = new ConnectionRequest();
        //String Url = "http://41.226.11.243:10004/tasks/" + ta.getNom() + "/" + ta.getEtat();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/ajouterpanier/"+p.getIdProduit();
        //con.addArgument("name", ta.getNom());
        //con.addArgument("status", ta.getEtat());
        con.setUrl(Url);

       // System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void supprimerPanier(Produits p) {
        ConnectionRequest con = new ConnectionRequest();
        //String Url = "http://41.226.11.243:10004/tasks/" + ta.getNom() + "/" + ta.getEtat();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/supprimerpanier/"+p.getIdProduit();
        //con.addArgument("name", ta.getNom());
        //con.addArgument("status", ta.getEtat());
        con.setUrl(Url);

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
     //preparecommande
     public void preparecommande(double prixTotal) {
        ConnectionRequest con = new ConnectionRequest();
        //String Url = "http://41.226.11.243:10004/tasks/" + ta.getNom() + "/" + ta.getEtat();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/preparecommande";
        
        //con.addArgument("status", ta.getEtat());
            con.addArgument("prixTotal", prixTotal+"");
        con.setUrl(Url); 
    

        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
