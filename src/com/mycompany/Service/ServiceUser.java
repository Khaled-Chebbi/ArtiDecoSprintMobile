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
import com.mycompany.Entite.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khaled Chebbi
 */
public class ServiceUser {
    
    
    /*
    
    String str;

    public Utilisateur getUser(String nom , String password) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/user?name=" + nom +"&password=" + password;
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
             str = new String(con.getResponseData());
             
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
        return str;
    }
    
*/
    
    public ArrayList<Utilisateur> getListUtilssateurs() {
        ArrayList<Utilisateur> listUtilssateurs = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/alluser");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> utilssateurs = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(utilssateurs);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) utilssateurs.get("root");
                    for (Map<String, Object> obj : list) {
                        Utilisateur utilisateur = new Utilisateur();
                        //float id = Float.parseFloat(obj.get("id").toString());
                        
                        //task.setId((int) id);
                        //System.out.println((int) obj.get("idUtilisateur"));
                       // utilisateur.setId_utilisateur((int) obj.get("idUtilisateur"));
                        //System.out.println(obj.get("nom").toString());
                        float id = Float.parseFloat(obj.get("idUtilisateur").toString());
                        //String nomBoutique = String.valueOf((String)obj.get("nomBoutique").toString());
        
                        utilisateur.setId_utilisateur((int)id);
                        // System.out.println(utilisateur.getId_utilisateur());
                        utilisateur.setNom(obj.get("nom").toString());
                        utilisateur.setPrenom(obj.get("prenom").toString());
                        // System.out.println(obj.get("mdp").toString());
                        utilisateur.setMdp(obj.get("mdp").toString());
                        // System.out.println(obj.get("typeUser").toString());
                        utilisateur.setType_user(obj.get("typeUser").toString());
                        utilisateur.setNumtel(obj.get("numtel").toString());
                        utilisateur.setEmail(obj.get("email").toString());
                        
                        if(!(obj.get("nomBoutique") == null))
                            utilisateur.setNomBoutique(obj.get("nomBoutique").toString());
                            
                       // utilisateur.setNomBoutique(nomBoutique);
                       
                        listUtilssateurs.add(utilisateur);
                        
                        
                        
                        //System.out.println("this is the key"+utilssateurs.keySet());
                       // System.out.println(utilssateurs.values());
                     //   System.out.println(utilssateurs.size());

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUtilssateurs;
    }
    
    
    
    
    
    public ArrayList<Utilisateur> getUserById(int id) {
        ArrayList<Utilisateur> listUser = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/user/3");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> user = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    //System.out.println(utilssateurs);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) user.get("root");
                    for (Map<String, Object> obj : list) {
                        Utilisateur utilisateur = new Utilisateur();
                        //float id = Float.parseFloat(obj.get("id").toString());
                        
                        //task.setId((int) id);
                        //System.out.println((int) obj.get("idUtilisateur"));
                       // utilisateur.setId_utilisateur((int) obj.get("idUtilisateur"));
                        //System.out.println(obj.get("nom").toString());
                        float id = Float.parseFloat(obj.get("idUtilisateur").toString());
        
                        utilisateur.setId_utilisateur((int)id);
                         System.out.println(utilisateur.getId_utilisateur());
                        utilisateur.setNom(obj.get("nom").toString());
                        utilisateur.setPrenom(obj.get("prenom").toString());
                         System.out.println(obj.get("mdp").toString());
                        utilisateur.setMdp(obj.get("numtel").toString());
                         System.out.println(obj.get("typeUser").toString());
                        utilisateur.setType_user(obj.get("typeUser").toString());
                        utilisateur.setType_user(obj.get("nomBoutique").toString());
                        System.out.println(obj.get("nomBoutique").toString());
                        System.out.println(obj.get("numtel").toString());
                        
                       
                        listUser.add(utilisateur);
                        
                        
                        
                        //System.out.println("this is the key"+utilssateurs.keySet());
                       // System.out.println(utilssateurs.values());
                     //   System.out.println(utilssateurs.size());

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUser;
    }
    
    
    
}
