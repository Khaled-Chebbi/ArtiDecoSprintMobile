/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import static com.codename1.ui.CN.SOUTH;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.validation.GroupConstraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.Entite.Categorie;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Service.ServiceMailing;
import com.mycompany.Service.ServiceUser;
import java.util.ArrayList;
import javafx.scene.control.Label;

/**
 *
 * @author khaled Chebbi
 */
public class Authentification {
    
    private Form fAuthentification;
    Button b12;
    public static Utilisateur staticUser;
    
    
    
    
    
    public Authentification()
    {
        TextModeLayout tm = new TextModeLayout(4, 2);
        fAuthentification = new Form("Authentification", new BorderLayout());
        Container content = new Container(tm);
        
        TextComponent Username = new TextComponent().labelAndHint("Username:");
        content.add(tm.createConstraint().horizontalSpan(2), Username);
        
      
        
        TextComponent Password = new TextComponent().labelAndHint("Password:");
        content.add(tm.createConstraint().horizontalSpan(2), Password);
//
//        PickerComponent gender = PickerComponent.createStrings("Male", "Female", "Other", "Unspecified").label("Gender");
//        content.add(gender);
//
//        PickerComponent dateOfBirth = PickerComponent.createDate(null).label("Birthday");
//        content.add(dateOfBirth);
        
       
        
  
        
        content.setScrollableY(true);
        
        
        ServiceUser sv = new ServiceUser();
        ArrayList<Utilisateur> listUser = sv.getListUtilssateurs();
        
        
       /* 
         b12 = new Button("aadd");
         b12.addActionListener((ActionListener) -> {
             
             
             
             //System.out.println(sv);
         });
        
        
        
       */
       
       
       
      
        
        Button submit = new Button("Submit");
        FontImage.setMaterialIcon(submit, FontImage.MATERIAL_DONE);
        submit.addActionListener(e -> {
            
           
            
            boolean test = false;
            String role = "";
             for(Utilisateur i : listUser)
             {
                 if(Username.getField().getText().equals(i.getNom()) && Password.getField().getText().equals(i.getMdp()) )
                 {
                     test = true;
                     role = i.getType_user();
                     staticUser = new Utilisateur();
                     staticUser.setId_utilisateur(i.getId_utilisateur());
                     staticUser.setType_user(i.getType_user());
                     staticUser.setPrenom(i.getPrenom());
                     staticUser.setNom(i.getNom());
                     staticUser.setMdp(i.getMdp());
                     staticUser.setNumtel(i.getNumtel());
                     staticUser.setEmail(i.getEmail());
                 }
                 
            
             }
             
             if(test)
             {
                 if(role.equals("Artisan"))
                 {
                     ArtisanHome artHome = new ArtisanHome();
                     artHome.getfArtisanHome().show();
                 }
                 
                 else if(role.equals("Client"))
                 {
                     ClientHome clientHome = new ClientHome();
                     clientHome.getfClientHome().show();
                 }
                 
                 else
                    {
                        if (Dialog.show("Auhtentification", " Votre Username ou mot de passe incorrect ", "Ok", "Cancel"))
                        {
                           Authentification auth = new Authentification();
                           auth.getfAuthentification().show();
                        }
                    }
                 
                 
             }
             else
             {
                 if (Dialog.show("Auhtentification", " Votre Username ou mot de passe incorrect ", "Ok", "Cancel"))
                {
                    Authentification auth = new Authentification();
                    auth.getfAuthentification().show();
                }
             }
            
            
            
           // AffichageCategorie afCat = new AffichageCategorie();
           // afCat.getfAffichageCategorie().show();
           // showOKForm(name.getField().getText(), prenom.getField().getText());
           
           // System.out.println(Username.getField().getText());
           
         
        });
        
        
        Image im = FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_CIRCLE, UIManager.getInstance().getComponentStyle("Command"));
        Command edit = new Command("Sing up", im) {

            public void actionPerformed(ActionEvent evt) {
               
               
               Inscription ah = new Inscription();
               ah.getLoginForm().show();
                
                      }
        };
        fAuthentification.getToolbar().addCommandToOverflowMenu(edit);
        
        
        
        fAuthentification.add(CENTER, content);
        fAuthentification.add(SOUTH, submit);
        
//        fAuthentification.add(SOUTH, tb);
//        fAuthentification.add(tb);
        // fAuthentification.add(SOUTH, b12);
        
        
        Validator val = new Validator();
        val.setShowErrorMessageForFocusedComponent(true);
        val.addConstraint(Username, 
                new GroupConstraint(
                        new LengthConstraint(2), 
                        new RegexConstraint("^([a-zA-Z0-9 ]*)$", "Please only use latin characters for name"))).
                addSubmitButtons(submit);
        val.addConstraint(Password, 
                new GroupConstraint(
                        new LengthConstraint(2), 
                        new RegexConstraint("^([a-zA-Z0-9 ]*)$", "Please only use latin characters for name"))).
                addSubmitButtons(submit);

        fAuthentification.show();
        
        
        
    }

    public Form getfAuthentification() {
        return fAuthentification;
    }

    public void setfAuthentification(Form fAuthentification) {
        this.fAuthentification = fAuthentification;
    }
    
    
    
    
    }
    
    
    
