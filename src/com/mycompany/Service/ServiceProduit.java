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
    
}
