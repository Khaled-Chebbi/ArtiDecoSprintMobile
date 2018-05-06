/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import GUI.Authentification;
import static com.codename1.ui.events.ActionEvent.Type.Response;
import com.mycompany.Entite.Utilisateur;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.IOException;

/**
 *
 * @author khaled Chebbi
 */
public class ServiceMailing {
    
    
     public void SendMail(String too , String contentt) {
    Email from = new Email(Authentification.staticUser.getEmail());
    String subject = "Votre Boutique favorie a ajouté in nouveau produit";
    Email to = new Email(too);
    Content content = new Content("text/plain", contentt);
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid("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");
    
         Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
       ex.printStackTrace();
    }
  }
     
    
}



