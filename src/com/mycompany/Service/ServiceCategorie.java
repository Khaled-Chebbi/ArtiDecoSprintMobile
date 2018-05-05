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
import com.mycompany.Entite.Categorie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khaled Chebbi
 */
public class ServiceCategorie {
    
    public ArrayList<Categorie> getListCategorie() {
        ArrayList<Categorie> listCategories = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/categorie/all");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> categories = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(categories);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) categories.get("root");
                    for (Map<String, Object> obj : list) {
                        Categorie categorie = new Categorie();
                        //float id = Float.parseFloat(obj.get("id").toString());
                        
                        //task.setId((int) id);
                        categorie.setNom_categorie(obj.get("nomCategorie").toString());
                        listCategories.add(categorie);
                        
                        System.out.println("this is the key"+categories.keySet());
                        System.out.println(categories.values());
                        System.out.println(categories.size());

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCategories;
    }
    
    
    
    public void ajoutCategorie(Categorie cat) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/categorie/new?name=" + cat.getNom_categorie();
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
    
    
    
    
    
     public void SupprimerCategorie(Categorie cat) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/categorie/supprimer/" + cat.getNom_categorie();
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
    
    
     public void UpdateCategorie(Categorie cat , Categorie updatedname) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/categorie/update?name=" + cat.getNom_categorie()+"&updatedname=" + updatedname.getNom_categorie();
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
     
     
     
     
  
    
}
