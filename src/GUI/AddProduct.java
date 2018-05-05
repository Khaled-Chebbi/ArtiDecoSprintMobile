/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.AffichageCategorie.cat;
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
import com.mycompany.Entite.Categorie;
import com.mycompany.Entite.Produit;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Service.ServiceAbonnement;
import com.mycompany.Service.ServiceCategorie;
import com.mycompany.Service.ServiceMailing;
import com.mycompany.Service.ServiceProduit;
import com.mycompany.Service.ServiceSMS;
import com.mycompany.Service.ServiceUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khaled Chebbi
 */
public class AddProduct {
    
     Form fAddproductSendingSMS;
     List<ArtisansFavories> ListAllAbonner;
     List<Utilisateur> ListAllUsers;
    
    
    public AddProduct()
    {
         //create and build the home Form
        fAddproductSendingSMS = new Form("Add product");
        fAddproductSendingSMS.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        ListAllAbonner = new ArrayList<>();
        ListAllUsers = new ArrayList<>();
        
        //fAffichageCategorie.addComponent(new Label("This is a Label"));
        //fAffichageCategorie.addComponent(new Button("This is a Button"));
        
        
        
        
        
           TextField txtnomproduit = new TextField();
           TextField txtdescriptionproduit = new TextField();
           TextField txtprixproduit = new TextField();
           //txtproduit.setText(cat.getNom_categorie());
           txtnomproduit.setHint("Ajouter le nom de votre produit...");
           fAddproductSendingSMS.addComponent(txtnomproduit);
           txtdescriptionproduit.setHint("Ajouter la description de votre produit...");
           fAddproductSendingSMS.addComponent(txtdescriptionproduit);
           txtprixproduit.setHint("Ajouter le prix de votre produit...");
           fAddproductSendingSMS.addComponent(txtprixproduit);
           
           
           
           
           
           
        
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
        ServiceUser serUser = new ServiceUser();
        ServiceSMS sms = new ServiceSMS();
        ListAllAbonner = serabonnement.getListAllAbonner();
        ListAllUsers = serUser.getListUtilssateurs();
        
        
        
        Button b1 = new Button("Ajouter");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
                //ServiceCategorie ser = new ServiceCategorie();
               // Categorie updatedcat = new Categorie(txtproduit.getText());
               // ser.UpdateCategorie(cat, updatedcat);
               Produit prod = new Produit();
               prod.setTitre(txtnomproduit.getText());
               prod.setDescription(txtdescriptionproduit.getText());
               prod.setPrix(Integer.parseInt(txtprixproduit.getText()));
               
                ServiceProduit serProd = new ServiceProduit();
                serProd.ajoutProduit(prod);
               
               
                
                if (Dialog.show("Succés", "Votre produit a été ajouter avec succés et un SMS sera envoyer a votre clients abonnées", "Ok", "Cancel"))
                {
                    //redireger l'application vers la pages d'affichages des produit et applique le service web d'SMS
                    
                    //--------- Service SMS
                    int idArtisan = Authentification.staticUser.getId_utilisateur();
                    Utilisateur userClient = null;
                    Utilisateur userArtisan = null;
                    
               
               for(ArtisansFavories i : ListAllAbonner)
               {
                   
                   if(i.getId_User() == idArtisan)
                   {
                       System.out.println(i.getId_client()+ i.getNom());
                       System.out.println(i.getId_User() + i.getNomBoutique());
                       
                       for(Utilisateur j : ListAllUsers)
                       {
                           if(i.getId_client() == j.getId_utilisateur())
                           {
                            userClient = j;
                            System.out.println("this the j loop  :" + userClient.getNumtel());
                           }
                       }
                       
                       for(Utilisateur k : ListAllUsers)
                       {
                           if(i.getId_User() == k.getId_utilisateur())
                           {
                            userArtisan = k;
                            System.out.println("this the k loop  :" + k.getNomBoutique());
                           }
                       }
                       
                       
                       
                       ServiceMailing sm = new ServiceMailing();
                        String too = userClient.getEmail();
                        String content = "Hi "+ userClient.getNom() + " , votre boutique favorie " + userArtisan.getNomBoutique() + " a ArtiDeco ont ajouté le nouveau produit " + txtnomproduit.getText() + " mentionne par " + txtdescriptionproduit.getText() + " et avec un prix " + txtprixproduit.getText() + " dollars !!"; 
                        
                        sm.SendMail(too, content);
                        
                        
                       
                       sms.getServiceSMS(userClient.getNumtel(), userClient.getNom(), txtnomproduit.getText(), txtdescriptionproduit.getText(), userArtisan.getNomBoutique(), txtprixproduit.getText());
                       
                       
                        
                        
                        
                   }
               }
                    
                    
               
                 txtnomproduit.setText("");
                 txtdescriptionproduit.setText("");
                 txtprixproduit.setText("");
                    
                    //AffichageCategorie affcat = new AffichageCategorie();
                    //affcat.getfAffichageCategorie().show();
                }
                
                
            }

        });
        
        fAddproductSendingSMS.addComponent(b1);

    
        
        //Create Form1 and Form2 and set a Back Command to navigate back to the home Form        
        Form form1 = new Form("Form1");
        setBackCommand(form1);
        Form form2 = new Form("Form2");
        setBackCommand(form2);
        
        ArtisanHome arthome = new ArtisanHome();
        //Add navigation commands to the home Form
        NavigationCommand homeCommand = new NavigationCommand("Home");
        homeCommand.setNextForm(arthome.getfArtisanHome());
        fAddproductSendingSMS.getToolbar().addCommandToSideMenu(homeCommand);

        NavigationCommand cmd1 = new NavigationCommand("Contact us");
        cmd1.setNextForm(form1);
        fAddproductSendingSMS.getToolbar().addCommandToSideMenu(cmd1);

        NavigationCommand cmd2 = new NavigationCommand("About");
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
    
    ArtisanHome arthome = new ArtisanHome();
    protected void setBackCommand2(Form f) {
        Command back = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                arthome.getfArtisanHome().showBack();
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
