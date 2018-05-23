/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.NavigationCommand;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.Reclamation;
import com.mycompany.Entite.User;
import com.mycompany.Service.ServiceMailing;
import com.mycompany.Service.ServiceReclamation;

import com.mycompany.Service.UserService;

/**
 *
 * @author khaled Chebbi
 */
public class AddReclamation {
    Form fAddreclamation;
    
    public AddReclamation(){
    
    fAddreclamation = new Form("Reclamation");
        fAddreclamation.setLayout(new BorderLayout());
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("ContainerWithPadding");
        ComboBox<String> cb1 = new ComboBox<>("Client", "Artisant");

        final TextArea recText = new TextArea();
        
        recText.setHint("Nom");
        
        center.addComponent(recText);

        Button Ajouter = new Button("SAjouter");

        Ajouter.addActionListener(new ActionListener() {
            

            public void actionPerformed(ActionEvent evt) {
                Reclamation rec = new Reclamation();
                rec.setDescription(recText.getText());
                rec.setEtat_rec("Non Traiter");
                rec.setId_Client(Authentification.staticUser.getId_utilisateur());
                
                ServiceReclamation sr = new ServiceReclamation();
                sr.ajoutReclamation(rec);
                
                if(Dialog.show("Confirmation", "Réclamation ajoutée avec succés", "Ok", "Cancel"))
                {
                        recText.setText("");
                }
            //Message m =new Message("test");
           // Display.getInstance().sendMessage(new String[]{"manel.ouaili@esprit.tn"},"utilisateur ajouté ", m);
                
                
            }
        });
        center.addComponent(Ajouter);

        fAddreclamation.addComponent(BorderLayout.CENTER, center);

    
        Image im = FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_CIRCLE, UIManager.getInstance().getComponentStyle("Command"));
        Command edit = new Command("Sing in", im) {

            public void actionPerformed(ActionEvent evt) {
               
               
               Authentification ah = new Authentification();
               ah.getfAuthentification().show();
                
                      }
        };
        fAddreclamation.getToolbar().addCommandToOverflowMenu(edit);
        
        
        
        
        
        
        
        NavigationCommand cmd3 = new NavigationCommand("Profile", FontImage.MATERIAL_ACCOUNT_CIRCLE);
        Profile p = new Profile();
        cmd3.setNextForm(p.getfProfile());
        fAddreclamation.getToolbar().addCommandToSideMenu(cmd3);
        
       

        NavigationCommand cmd2 = new NavigationCommand("About", FontImage.MATERIAL_GROUP_WORK);
        About abt = new About();
        cmd2.setNextForm(abt.getfAbout());
        fAddreclamation.getToolbar().addCommandToSideMenu(cmd2);
    
}

    public Form getfAddreclamation() {
        return fAddreclamation;
    }

    public void setfAddreclamation(Form fAddreclamation) {
        this.fAddreclamation = fAddreclamation;
    }
    
}
