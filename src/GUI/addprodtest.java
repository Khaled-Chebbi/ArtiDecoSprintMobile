/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.NavigationCommand;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.ArtisansFavories;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Service.ServiceAbonnement;
import com.mycompany.Service.ServiceSMS;
import com.mycompany.Service.ServiceUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khaled Chebbi
 */
public class addprodtest {
    
    
      Form fAddproductSendingSMS;
     List<ArtisansFavories> ListAllAbonner;
    
    
    public addprodtest()
    {
         //create and build the home Form
        fAddproductSendingSMS = new Form("Add product");
        fAddproductSendingSMS.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        ListAllAbonner = new ArrayList<>();
        //fAffichageCategorie.addComponent(new Label("This is a Label"));
        //fAffichageCategorie.addComponent(new Button("This is a Button"));
        
        
        
        
        
           TextField txtproduit = new TextField();
           //txtproduit.setText(cat.getNom_categorie());
           txtproduit.setHint("Ajouter votre produit...");
           fAddproductSendingSMS.addComponent(txtproduit);
           
           
           
           
           
           
        
       // fAffichageCategorie.addComponent(new CheckBox("This is a CheckBox"));
       
       /*
        Container listCat = new Container(BoxLayout.y());
        listCat.setScrollableY(true);
        
        
       
        ServiceCategorie serviceCategorie=new ServiceCategorie();
        ArrayList<Categorie> lis=serviceCategorie.getListCategorie();
        //lb.setText("+Vos catégories actuel:");
        for (Categorie i : lis)
        {
          //  if(lb.getText().equals(""))
             //   lb.setText(i.getNom_categorie());
           // else
            RadioButton rb = new RadioButton(i.getNom_categorie().toString());
            rb.setGroup("group");
            FontImage.setMaterialIcon(rb, FontImage.MATERIAL_DONE);
            listCat.add(rb);
            //lb.setText(lb.getText()+"\n"+"        -"+i.getNom_categorie().toString());
        }
        
        fAjouterCategorie.add(listCat);
        
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
        */
        
        ServiceAbonnement serabonnement = new ServiceAbonnement();
        ServiceSMS sms = new ServiceSMS();
        ListAllAbonner = serabonnement.getListAllAbonner();
        
        ServiceUser serUser = new ServiceUser();
        
        Button b1 = new Button("Ajouter");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
                //ServiceCategorie ser = new ServiceCategorie();
               // Categorie updatedcat = new Categorie(txtproduit.getText());
               // ser.UpdateCategorie(cat, updatedcat);
               
               
                
                if (Dialog.show("Succés", "Votre produit a été ajouter avec succés et un SMS sera envoyer a votre clients abonnées", "Ok", "Cancel"))
                {
                    //redireger l'application vers la pages d'affichages des produit et applique le service web d'SMS
                    
                    //--------- Service SMS
                    ServiceUser SerUser = new ServiceUser();
                    Utilisateur user = new Utilisateur();

                    for(Utilisateur i : SerUser.getUserById(3))
                    {
                        System.out.println(i.getNomBoutique() + i.getNomBoutique());
                    }
        
               }
                    
                    
                    
                    //AffichageCategorie affcat = new AffichageCategorie();
                    //affcat.getfAffichageCategorie().show();
                }
                
            
        });
        
        fAddproductSendingSMS.addComponent(b1);

    
        
        //Create Form1 and Form2 and set a Back Command to navigate back to the home Form        
        Form form1 = new Form("Form1");
        setBackCommand(form1);
        Form form2 = new Form("Form2");
        setBackCommand(form2);
        
        AffichageCategorie affcat = new AffichageCategorie();
        //Add navigation commands to the home Form
        NavigationCommand homeCommand = new NavigationCommand("Categories");
        homeCommand.setNextForm(affcat.getfAffichageCategorie());
        fAddproductSendingSMS.getToolbar().addCommandToSideMenu(homeCommand);

        NavigationCommand cmd1 = new NavigationCommand("Form1");
        cmd1.setNextForm(form1);
        fAddproductSendingSMS.getToolbar().addCommandToSideMenu(cmd1);

        NavigationCommand cmd2 = new NavigationCommand("Form2");
        cmd2.setNextForm(form2);
        fAddproductSendingSMS.getToolbar().addCommandToSideMenu(cmd2);

        
        setBackCommand2(fAddproductSendingSMS);
        fAddproductSendingSMS.show();
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
    
    AffichageCategorie affcat = new AffichageCategorie();
    protected void setBackCommand2(Form f) {
        Command back = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                affcat.getfAffichageCategorie().showBack();
            }

        };
        Image img = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, UIManager.getInstance().getComponentStyle("TitleCommand"));
        back.setIcon(img);
        f.getToolbar().addCommandToRightBar(back);
        f.getToolbar().setTitleCentered(true);
        f.setBackCommand(back);
    }

    public Form getfAddproductSendingSMS() {
        return fAddproductSendingSMS;
    }

    public void setfAddproductSendingSMS(Form fAddproductSendingSMS) {
        this.fAddproductSendingSMS = fAddproductSendingSMS;
    }
    
    
    
    
}
