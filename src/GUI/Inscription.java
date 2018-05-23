/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceMailing;
import com.mycompany.Service.UserService;

/**
 *
 * @author khaled Chebbi
 */
public class Inscription {
    
    private Form loginForm;
    
    public Inscription(){
    
    loginForm = new Form("Sign up");
        loginForm.setLayout(new BorderLayout());
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("ContainerWithPadding");
        ComboBox<String> cb1 = new ComboBox<>("Client", "Artisant");

        final TextField nom = new TextField();
        nom.setHint("Nom");
        final TextField Prenom = new TextField();
        Prenom.setHint("Prenom");
        final TextField numTel = new TextField();
        numTel.setHint("NumTel ");
        final TextField adresse = new TextField();
        adresse.setHint("adresse ");

        final TextField email = new TextField();
        email.setHint("Email");
        final TextField pass = new TextField();
        pass.setHint("Mot de passe");
        pass.setConstraint(TextField.PASSWORD);

        center.addComponent(cb1);
        center.addComponent(nom);
        center.addComponent(Prenom);
        center.addComponent(numTel);
        center.addComponent(adresse);
        center.addComponent(email);
        center.addComponent(pass);

        Button signIn = new Button("Sign Up");

        signIn.addActionListener(new ActionListener() {
            

            public void actionPerformed(ActionEvent evt) {
                User u = new User(nom.getText(), Prenom.getText(), email.getText(), numTel.getText(), cb1.getSelectedItem(), adresse.getText(), pass.getText());
                UserService su = new UserService();
                su.ajoutUser(u);
                
              if(Dialog.show("Succes", "Compte ajouté avec succeés", "ok", null))
              {
                  ServiceMailing sm = new ServiceMailing();
                  sm.SendMail(email.getText(), "Vous avez maintenant un client a artiDeco , merci pour votre confiance");
                  
                  Authentification auth = new Authentification();
                  auth.getfAuthentification().show();
              }
                
               
            
            //Message m =new Message("test");
           // Display.getInstance().sendMessage(new String[]{"manel.ouaili@esprit.tn"},"utilisateur ajouté ", m);
                
                
            }
        });
        center.addComponent(signIn);

        loginForm.addComponent(BorderLayout.CENTER, center);

    
        Image im = FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_CIRCLE, UIManager.getInstance().getComponentStyle("Command"));
        Command edit = new Command("Sing in", im) {

            public void actionPerformed(ActionEvent evt) {
               
               
               Authentification ah = new Authentification();
               ah.getfAuthentification().show();
                
                      }
        };
        loginForm.getToolbar().addCommandToOverflowMenu(edit);
    
}

    public Form getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(Form loginForm) {
        this.loginForm = loginForm;
    }
    
     
}
