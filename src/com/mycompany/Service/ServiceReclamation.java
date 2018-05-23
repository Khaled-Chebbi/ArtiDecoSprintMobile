/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.mycompany.Entite.Produit;
import com.mycompany.Entite.Reclamation;

/**
 *
 * @author khaled Chebbi
 */
public class ServiceReclamation {
    
    
    public void ajoutReclamation(Reclamation p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/ArtiiDeco/web/app_dev.php/api/ajoutReclamation?etatRec="+p.getEtat_rec() + "&description=" + p.getDescription()+ "&idClient="+p.getId_Client();
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
