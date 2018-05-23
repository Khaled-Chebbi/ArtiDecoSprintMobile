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
import com.mycompany.Entite.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lenovo
 */
public class UserService {
    
     public ArrayList<User> getList(String email, String password) {
        ArrayList<User> listUser = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/ArtiiDeco/web/app_dev.php/api/Authentification/" + email+ "/" + password);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> users = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) users.get("root");
                    for (Map<String, Object> obj : list) {
                        User us = new User();
                        float id = Float.parseFloat(obj.get("idUtilisateur").toString());
                        us.setIdUtilisateur((int) id);
                        us.setEmail(obj.get("email").toString());
                        us.setMdp(obj.get("mdp").toString());
                        us.setNom(obj.get("nom").toString());
                        us.setPrenom(obj.get("prenom").toString());

                        listUser.add(us);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUser;
    }
    
 public void ajoutUser(User u) { 
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/Inscription/" + u.getNom()+ "/" + u.getPrenom()+ "/" + u.getEmail()+ "/"+u.getMdp()+ "/"+u.getTypeUser()+ "/"+u.getNumtel()+ "/"+u.getAdresse();
        con.setUrl(Url);
        System.out.println(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
