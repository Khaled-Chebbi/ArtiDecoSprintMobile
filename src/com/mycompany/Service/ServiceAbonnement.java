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
import com.mycompany.Entite.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khaled Chebbi
 */
public class ServiceAbonnement {
    
    
       public ArrayList<Utilisateur> getListArtisans() {
        ArrayList<Utilisateur> listArtisans = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/allartisan");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> artisans = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(artisans);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) artisans.get("root");
                    for (Map<String, Object> obj : list) {
                        
                        Utilisateur user = new Utilisateur();
                        //float id = Float.parseFloat(obj.get("id").toString());
                        
                        //task.setId((int) id);
                        
                        float id = Float.parseFloat(obj.get("idUtilisateur").toString());
        
                        user.setId_utilisateur((int)id);
                        user.setNomBoutique(obj.get("nomBoutique").toString());
               
                        
                        
                        System.out.println(user.getId_utilisateur());
                        
                        System.out.println(user.getNomBoutique());
                        
                        
                        listArtisans.add(user);
                        
                        //System.out.println("this is the key"+artisans.keySet());
                       // System.out.println(artisans.values());
                        //System.out.println(artisans.size());

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listArtisans;
    }
       
       
       
       public void AddAbonnement(String clientnom , String clientprenom , String Boutique , int idArtisan , int idClient) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/abonnement/add?clientname="+clientnom+"&clientsecondname="+clientprenom+"&boutiquename="+Boutique+"&idartisan="+idArtisan+"&idclient="+idClient;
        con.setUrl(Url);

        System.out.println("tt");

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
       
       
       public void SupprimerAbonnement(int idartisan ,  int idiclient) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/abonnement/delete?idartisan="+idartisan+"&idclient="+idiclient;
        con.setUrl(Url);

        System.out.println("stt");

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
       
       
       
       
       public ArrayList<ArtisansFavories> getListAllAbonner() {
        ArrayList<ArtisansFavories> listAbonner = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/abonnement/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> artisans = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(artisans);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) artisans.get("root");
                    for (Map<String, Object> obj : list) {
                        
                        ArtisansFavories abonnement = new ArtisansFavories();
                        //float id = Float.parseFloat(obj.get("id").toString());
                        
                        //task.setId((int) id);
                        
                        float id = Float.parseFloat(obj.get("id").toString());
        
                        abonnement.setId_Artisansfav((int)id);
                        abonnement.setNom(obj.get("nom").toString());
                        abonnement.setPrenom(obj.get("prenom").toString());
                        abonnement.setNomBoutique(obj.get("nomBoutique").toString());
                        
                        float idUser = Float.parseFloat(obj.get("idUser").toString());
                        
                        abonnement.setId_User((int)idUser);
                        
                        float idClient = Float.parseFloat(obj.get("idClient").toString());
                        abonnement.setId_client((int)idClient);
                        
                        
                        
                        
               
                        
                        
                        System.out.println(abonnement.getId_Artisansfav());
                        
                        System.out.println(abonnement.getNom());
                        System.out.println(abonnement.getPrenom());
                        System.out.println(abonnement.getNomBoutique());
                        System.out.println(abonnement.getId_client());
                        System.out.println(abonnement.getId_User());
                        
                        
                        listAbonner.add(abonnement);
                        
                        //System.out.println("this is the key"+artisans.keySet());
                       // System.out.println(artisans.values());
                        //System.out.println(artisans.size());

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAbonner;
    }
    
    
}
