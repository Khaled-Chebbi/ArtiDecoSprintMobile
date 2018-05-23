/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.ArtisansFavories;
import com.mycompany.Entite.Categorie;
import com.mycompany.Entite.Produit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khaled Chebbi
 */
public class ServiceProduit {
    
    public ArrayList<Produit> getListAllProduits() {
        ArrayList<Produit> listProduit = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/products/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> produits = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(produits);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    for (Map<String, Object> obj : list) {
                        
                        Produit produit = new Produit();
                        //float id = Float.parseFloat(obj.get("id").toString());
                        
                        //task.setId((int) id);
                        
                        float id = Float.parseFloat(obj.get("idProd").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());
        
                        produit.setId((int)id);
                        produit.setTitre(obj.get("titre").toString());
                        produit.setPrix((int)prix);
                        produit.setDescription(obj.get("description").toString());
                        
                        
                        
                        
                        
                        
               
                        
                        
                        System.out.println(produit.getId());
                        
                        System.out.println(produit.getPrix());
                        System.out.println(produit.getPrix());
                        System.out.println(produit.getDescription());
                        
                        
                        
                        listProduit.add(produit);
                        
                        //System.out.println("this is the key"+artisans.keySet());
                       // System.out.println(artisans.values());
                        //System.out.println(artisans.size());

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduit;
    }
    
    
    
    
     public void ajoutProduit(Produit p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/produits/new?titre="+p.getTitre() + "&prix=" + p.getPrix() + "&quantite=" +p.getQuantite()+"&couleur=" +p.getCouleur()+ "&image=" +p.getImage()+ "&description=" + p.getDescription()+"&NomCategorie=" + p.getNomCategorie();
        con.setUrl(Url);

        System.out.println("aaaaaaa");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
     
     /*
     public void ajoutProduit(Produit p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiDeco/web/app_dev.php/api/produits/new?titre="+p.getTitre() + "&prix=" + p.getPrix() + "&quantite=" +p.getQuantite()+"&couleur=" +p.getCouleur()+ "&image=" +p.getImage()+ "&description=" + p.getDescription()+"&NomCategorie=" + p.getNomCategorie();
        con.setUrl(Url);

        System.out.println("aaaaaaa");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
     */
     
     
    public  ArrayList<String> getCategories ()
    {
       ArrayList<String> listategories = new ArrayList<>(); 
       ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/categorie/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> categories = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) categories.get("root");
                    for (Map<String, Object> obj : list) {
                        Categorie c=new Categorie();
                        
                        c.setNom_categorie(
                                obj.get("nomCategorie").toString());
                      
                         listategories.add(c.getNom_categorie());
                      
                    }
    }
                 catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    
  return listategories;
    }
    

    public ArrayList<Produit> getList2() throws NullPointerException{
        ArrayList<Produit> listproduits = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/produits/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> produits = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(""+produits.keySet()+" "+produits.values());
                    System.out.println(produits.size());
                    System.out.println(produits);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    for (Map<String, Object> obj : list) {
                        Produit produit = new Produit();
                        float id = Float.parseFloat(obj.get("id_prod").toString());
                      float prix=Float.parseFloat(obj.get("prix").toString());
                      float quantite=Float.parseFloat(obj.get("quantite").toString());
                       produit.setId((int) id);
                        produit.setTitre(obj.get("titre").toString());
                        //produit.setNomCategorie(obj.get("nomc").toString());
                        produit.setPrix((int)prix);
                        produit.setQuantite((int)quantite);
                        produit.setImage(obj.get("image").toString());
                        produit.setDescription(obj.get("description").toString());
                        listproduits.add(produit);
                      
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    
  return listproduits;
}
  /*    public void modifierProduit(int id,String titre,int prix,int quantite,String couleur, String image, String description,String nomcategorie) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl( "http://localhost/ArtiDeco/web/app_dev.php/api/produits/modif?id"+id+ "&titre"+titre+"&prix"+prix+
                +p.getId()+"?titre="+p.getTitre() + "&prix=" + p.getPrix()
                + "&quantite=" +p.getQuantite()+"&couleur=" +p.getCouleur()+
                "&image=" +p.getImage()+ "&description=" + p.getDescription()+"&NomCategorie=" + p.getNomCategorie());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                byte[] data=(byte[])evt.getMetaData();
                String s=new String(data);
                
            }
            
        });
          
            NetworkManager.getInstance().addToQueue(con);




//System.out.println(Url);
      //  System.out.println("modification ");

      //  con.addResponseListener((e) -> {
          //  String str = new String(con.getResponseData());
           // System.out.println(str);

       // });
       // NetworkManager.getInstance().addToQueueAndWait(con);
    }
      public void supprimerProduit(Produit p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiDeco/web/app_dev.php/api/produits/supprim/"+p;
        System.out.println("suppression");
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
           System.out.println(str);
          
        });
         NetworkManager.getInstance().addToQueueAndWait(con);
    }*/
      
       public ArrayList<Produit> getListAct(String json, String search) {
        ArrayList<Produit> listEtudiants = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");
            for (Map<String, Object> obj : list) {
                if (obj.get("titre").toString().startsWith(search)) {
                           Produit user = new Produit();
                    user.setId(Integer.parseInt(obj.get("id_prod").toString()));
                    user.setTitre(obj.get("titre").toString());
                    user.setPrix(Integer.parseInt(obj.get("prix").toString()));
                    user.setQuantite(Integer.parseInt(obj.get("quantite").toString()));
                    user.setImage(obj.get("image").toString());
                     user.setDescription(obj.get("description").toString());
                      user.setNomCategorie(obj.get("nomc").toString());
                   
                    
                    listEtudiants.add(user);
                }

            }

        } catch (IOException ex) {
        }
        return listEtudiants;

    }
    
}
