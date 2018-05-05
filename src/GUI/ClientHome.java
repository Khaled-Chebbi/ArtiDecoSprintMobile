/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.NavigationCommand;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.Categorie;
import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khaled Chebbi
 */
public class ClientHome {
    
    Form fClientHome;
    //RadioButton rb;
    List catsListindex = new ArrayList<String>();
    public static Categorie cat;
    
    
            
    public ClientHome()
    {
         //create and build the home Form
        fClientHome = new Form("Home");
        fClientHome.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        //fAffichageCategorie.addComponent(new Label("This is a Label"));
        //fAffichageCategorie.addComponent(new Button("This is a Button"));
       // TextField txt = new TextField();
     //   txt.setHint("This is a TextField");
       // fAffichageCategorie.addComponent(txt);
       // fAffichageCategorie.addComponent(new CheckBox("This is a CheckBox"));
       
       
       
       
        Container listCat = new Container(BoxLayout.y());
        listCat.setScrollableY(true);
        
        fClientHome.addComponent(new com.codename1.ui.Label("\n"));
        fClientHome.addComponent(new com.codename1.ui.Label("\n"));
        
            Button b1 = new Button("Actualités");
            b1.addActionListener(new ActionListener() {
                
                ServiceProduit serProd = new ServiceProduit();

            @Override
            public void actionPerformed(ActionEvent evt) {
                
                //AffichageCategorie affcat = new AffichageCategorie();
                //affcat.getfAffichageCategorie().show();
                
                //notif nt= new notif();
               // nt.noti();
               // nt.localNotificationReceived("hhhhhhhhiiiddd");
                
               
               LocalNotification n = new LocalNotification();
                n.setId("demo-notification");
                n.setAlertBody("It's time to take a break and look at me");
                n.setAlertTitle("Break Time!");
                n.setAlertSound("/notification_sound_beep-01a.mp3");
                    // alert sound file name must begin with notification_sound

                Display.getInstance().scheduleLocalNotification(
                        n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
                );
          
                /*
                int taille = serProd.getListAllAbonner().size();
                Produit p = new Produit();
                p.setTitre(serProd.getListAllAbonner().get(taille-1).getTitre());
                p.setPrix(serProd.getListAllAbonner().get(taille-1).getPrix());
                p.setDescription(serProd.getListAllAbonner().get(taille-1).getDescription());
                
                
                Dialog.show("Un nouveau produit", p.getTitre() +" \n "+p.getPrix()+"$ \n "+p.getDescription() , "OK", "Cancel");
                
          */
          
         
            }
            
        });
            
        
            Button b2 = new Button("Consulter vos abonnements");
            b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
                //ArtisanAbonner affabb = new ArtisanAbonner();
                //affabb.getfAffichageArtisanAbonner().show();
                
                ClientAbonnement ca = new ClientAbonnement();
                ca.getfAffichageAbonnement().show();
                
            }
            
        });

        fClientHome.addComponent(b1);
        fClientHome.addComponent(b2);
        
        
       /*
        ServiceCategorie serviceCategorie=new ServiceCategorie();
        ArrayList<Categorie> lis=serviceCategorie.getListCategorie();
        
        ButtonGroup bg = new ButtonGroup();
        
        
        //lb.setText("+Vos catégories actuel:");
        
        
        for (Categorie i : lis)
        {
          //  if(lb.getText().equals(""))
             //   lb.setText(i.getNom_categorie());
           // else
            catsListindex.add(i.getNom_categorie());
            
            rb = new RadioButton(i.getNom_categorie().toString());
            bg.add(rb);
            //rb.setGroup("group");
            FontImage.setMaterialIcon(rb, FontImage.MATERIAL_DONE);
            listCat.add(rb);
            //lb.setText(lb.getText()+"\n"+"        -"+i.getNom_categorie().toString());
        }
        
        fArtisanHome.add(listCat);
        */
        
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

        NavigationCommand cmd1 = new NavigationCommand("Contact us");
        cmd1.setNextForm(form1);
        fClientHome.getToolbar().addCommandToSideMenu(cmd1);

        NavigationCommand cmd2 = new NavigationCommand("About");
        cmd2.setNextForm(form2);
        fClientHome.getToolbar().addCommandToSideMenu(cmd2);

        //Add Edit, Add and Delete Commands to the home Form context Menu
        Image im = FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_CIRCLE, UIManager.getInstance().getComponentStyle("Command"));
        Command Logout = new Command("Logout", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Editing");
                
                Authentification auth = new Authentification();
                auth.getfAuthentification().show();
            }
        };
        fClientHome.getToolbar().addCommandToOverflowMenu(Logout);

        
        /*
        im = FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("Command"));
        Command add = new Command("Add", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Add");
                
            }
        };
        fArtisanHome.getToolbar().addCommandToOverflowMenu(add);

        im = FontImage.createMaterial(FontImage.MATERIAL_DELETE, UIManager.getInstance().getComponentStyle("Command"));
        Command delete = new Command("Delete", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Deleting");
                
            }

        };
        fArtisanHome.getToolbar().addCommandToOverflowMenu(delete);

*/

        fClientHome.show();
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

    public Form getfClientHome() {
        return fClientHome;
    }

    public void setfClientHome(Form fClientHome) {
        this.fClientHome = fClientHome;
    }
    
    
}
