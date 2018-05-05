/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.mycompany.Entite.Categorie;

/**
 *
 * @author khaled Chebbi
 */
public class ServiceSMS {
    
    public void getServiceSMS(String toNumber , String clientName , String productName , String description , String boutique , String prix ) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/codenameoneSMS/index.php?tonumber="+ toNumber +"&clientname="+clientName+"&productname="+ productName +"&description="+ description +"&boutique="+boutique+"&prix="+ prix;
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
