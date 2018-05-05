/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.messaging.Message;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.NavigationCommand;
import com.codename1.ui.RadioButton;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.ArtisansFavories;
import com.mycompany.Entite.Categorie;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Service.ServiceAbonnement;
import com.mycompany.Service.ServiceCategorie;
import com.mycompany.Service.ServiceUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khaled Chebbi
 */
public class ArtisanAbonner {
    
    Form fAffichageArtisanAbonner;
    RadioButton rb;
    List AbonnerListindex = new ArrayList<ArtisansFavories>();
    List AllUsers = new ArrayList<Utilisateur>();

    
    
            
    public ArtisanAbonner()
    {
         //create and build the home Form
        fAffichageArtisanAbonner = new Form("Vos Abonnées");
        fAffichageArtisanAbonner.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        //fAffichageCategorie.addComponent(new Label("This is a Label"));
        //fAffichageCategorie.addComponent(new Button("This is a Button"));
       // TextField txt = new TextField();
     //   txt.setHint("This is a TextField");
       // fAffichageCategorie.addComponent(txt);
       // fAffichageCategorie.addComponent(new CheckBox("This is a CheckBox"));
       
        Container listCat = new Container(BoxLayout.y());
        listCat.setScrollableY(true);
        
        
       
        ServiceAbonnement serviceAbonnement =new ServiceAbonnement();
        ServiceUser serUser = new ServiceUser();
        ArrayList<ArtisansFavories> lis = serviceAbonnement.getListAllAbonner();
        AllUsers = serUser.getListUtilssateurs();
        
        ButtonGroup bg = new ButtonGroup();
        
        
        //lb.setText("+Vos catégories actuel:");
        for (ArtisansFavories i : lis)
        {
          //  if(lb.getText().equals(""))
             //   lb.setText(i.getNom_categorie());
           // else
            
            
            if(Authentification.staticUser.getId_utilisateur() == i.getId_User())
            {
                AbonnerListindex.add(i);
                rb = new RadioButton(i.getNom() +" "+ i.getPrenom());
                bg.add(rb);
                //rb.setGroup("group");
                FontImage.setMaterialIcon(rb, FontImage.MATERIAL_DONE);
                listCat.add(rb);
            }
            
            
            //lb.setText(lb.getText()+"\n"+"        -"+i.getNom_categorie().toString());
        }
        
        fAffichageArtisanAbonner.add(listCat);
        
        
       /* RadioButton rb1 = new RadioButton("This is a Radio Button 1");
        rb1.setGroup("group");
        fAffichageCategorie.addComponent(rb1);
        RadioButton rb2 = new RadioButton("This is a Radio Button 2");
        rb2.setGroup("group");
        fAffichageCategorie.addComponent(rb2);  */
       
        /*
        final Slider s = new Slider();
        s.setText("50%");
        s.setProgress(50);
        s.setEditable(true);
        s.setRenderPercentageOnTop(true);
        fAffichageCategorie.addComponent(s);
        
        Button b1 = new Button("Show a Dialog");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Dialog Title", "Dialog Body", "Ok", "Cancel");
            }
        });
        fAffichageCategorie.addComponent(b1);

    */
        
        //Create Form1 and Form2 and set a Back Command to navigate back to the home Form        
        Form form1 = new Form("Form1");
        setBackCommand(form1);
        Form form2 = new Form("Form2");
        setBackCommand(form2);

        //Add navigation commands to the home Form
       // NavigationCommand homeCommand = new NavigationCommand("Home");
       // homeCommand.setNextForm(fAffichageCategorie);
       // fAffichageCategorie.getToolbar().addCommandToSideMenu(homeCommand);

        ArtisanHome ah= new ArtisanHome();
        NavigationCommand cmd1 = new NavigationCommand("Home");
        cmd1.setNextForm(ah.getfArtisanHome());
        fAffichageArtisanAbonner.getToolbar().addCommandToSideMenu(cmd1);

        AffichageCategorie afcat = new AffichageCategorie();
        NavigationCommand cmd2 = new NavigationCommand("Vos Categories");
        cmd2.setNextForm(afcat.getfAffichageCategorie());
        fAffichageArtisanAbonner.getToolbar().addCommandToSideMenu(cmd2);
        
        

        //Add Edit, Add and Delete Commands to the home Form context Menu
        Image im = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, UIManager.getInstance().getComponentStyle("Command"));
        /*
        Command edit = new Command("Edit", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Editing");
                
                
            }
        };
        fAffichageArtisanAbonner.getToolbar().addCommandToOverflowMenu(edit);
*/
        
        
        im = FontImage.createMaterial(FontImage.MATERIAL_CONTACT_MAIL, UIManager.getInstance().getComponentStyle("Command"));
        Command add = new Command("Contact", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Add");
               // AjouterCategorie ajtCat = new AjouterCategorie();
               // ajtCat.getfAjouterCategorie().show();
               
               ArtisansFavories ArtFav = (ArtisansFavories) AbonnerListindex.get(bg.getSelectedIndex());
                //System.out.println(AbonnerListindex.get(bg.getSelectedIndex()));
                //System.out.println(ArtFav.getId_client() +"and"+ArtFav.getNom());
                int idClient = ArtFav.getId_client();
                String Clientmail=null;
                
                for(Object p : AllUsers)
                {
                    Utilisateur us = (Utilisateur)p;
                    if(us.getId_utilisateur() == idClient)
                    {
                        Clientmail = us.getEmail();
                    }
                }
               
              //Utilisateur myUser = (Utilisateur) AllUsers.get(idClient);
               
                System.out.println(Clientmail);
                System.out.println(Authentification.staticUser.getEmail());
                
                Message m = new Message("Body of message");
                    m.getAttachments().put("rrrr", "text/plain");
                    m.getAttachments().put("rrrr", "image/png");
                    Display.getInstance().sendMessage(new String[] {Clientmail}, "Subject of message", m);
                    
                
            }
        };
        fAffichageArtisanAbonner.getToolbar().addCommandToOverflowMenu(add);
        
        

        im = FontImage.createMaterial(FontImage.MATERIAL_DELETE, UIManager.getInstance().getComponentStyle("Command"));
        Command delete = new Command("Delete", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Deleting");
                
                System.out.println(bg.getSelectedIndex());
                System.out.println(AbonnerListindex.get(bg.getSelectedIndex()));
                
                ArtisansFavories artFav = (ArtisansFavories) AbonnerListindex.get(bg.getSelectedIndex());
                
                
                if (Dialog.show("Attention !!", "Voulez vous vraiment supprimer l'abonner ?", "Confirmer", "Cancel"))
                {
                    ServiceAbonnement ser = new ServiceAbonnement();
                    ser.SupprimerAbonnement(Authentification.staticUser.getId_utilisateur(), artFav.getId_client());
                    ArtisanAbonner affart = new ArtisanAbonner();
                    affart.getfAffichageArtisanAbonner().show();
                }

            }

        };
        fAffichageArtisanAbonner.getToolbar().addCommandToOverflowMenu(delete);

        fAffichageArtisanAbonner.show();
    }

    protected void setBackCommand(Form f) {
        Command back = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                f.showBack();
            }

        };
        Image img = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, UIManager.getInstance().getComponentStyle("TitleCommand"));
        back.setIcon(img);
        f.getToolbar().addCommandToLeftBar(back);
        f.getToolbar().setTitleCentered(true);
        f.setBackCommand(back);
    }

    public Form getfAffichageArtisanAbonner() {
        return fAffichageArtisanAbonner;
    }

    public void setfAffichageArtisanAbonner(Form fAffichageArtisanAbonner) {
        this.fAffichageArtisanAbonner = fAffichageArtisanAbonner;
    }
    
    
}
