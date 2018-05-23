/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.Utilisateur;
import com.mycompany.Service.ServiceUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khaled Chebbi
 */
public class Profile {
    
        Form fProfile;
         ClientHome ch;
         ArtisanHome ah;
  
   // Label lbl;
    //RadioButton rb;
    

            
    public Profile()
    {
        
         //create and build the home Form
        fProfile = new Form("Profile");
        fProfile.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        //lbl = new Label("ArtiDeco Team" + "\n" + "     - Chebbi khaled" +"\n"+ "     - Mezni Mouafek" +"\n"+ "     - Brandon Dieutoss" +"\n"+ "     - Ouaili Manel" +"\n");
        Container container1 = new Container();
        container1.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        Container container2 = new Container();
        container2.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        Container container3 = new Container();
        container3.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        Container container4 = new Container();
        container4.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        Container container5 = new Container();
        container5.setLayout(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        
        com.codename1.ui.Label lbl1 = new com.codename1.ui.Label(Authentification.staticUser.getNom());
        com.codename1.ui.Label lbl2 = new com.codename1.ui.Label(Authentification.staticUser.getPrenom());
        com.codename1.ui.Label lbl3 = new com.codename1.ui.Label(Authentification.staticUser.getEmail());
        com.codename1.ui.Label lbl4 = new com.codename1.ui.Label(Authentification.staticUser.getNumtel());
        
        container1.add(BorderLayout.CENTER, lbl1);
        container2.add(BorderLayout.CENTER, lbl2);
        container3.add(BorderLayout.CENTER, lbl3);
        container4.add(BorderLayout.CENTER, lbl4);
  
        
        fProfile.add(container1);
        fProfile.add(container2);
        fProfile.add(container3);
        fProfile.add(container4);
        fProfile.add(container5);
        
         
       
         
         //fAbout.addComponent(new Label("This is a Label"));
                  
        
        //fAffichageCategorie.addComponent(new Label("This is a Label"));
        //fAffichageCategorie.addComponent(new Button("This is a Button"));
       // TextField txt = new TextField();
     //   txt.setHint("This is a TextField");
       // fAffichageCategorie.addComponent(txt);
       // fAffichageCategorie.addComponent(new CheckBox("This is a CheckBox"));
       
       /*
       
        Container listBoutiques = new Container(BoxLayout.y());
        listBoutiques.setScrollableY(true);
        
        fAbout.add(listBoutiques);
       
        ServiceAbonnement sa=new ServiceAbonnement();
        ArrayList<Utilisateur> lis = sa.getListArtisans();
        
        
        //ButtonGroup bg = new ButtonGroup();
        
        ServiceAbonnement serab = new ServiceAbonnement();
        List<ArtisansFavories> listAbonner = new ArrayList<>();
        for(ArtisansFavories i :serab.getListAllAbonner())
        {
            listAbonner.add(i);
        }
       
     /*   Button b1 = new Button("add");
        fAffichageAbonnement.add(b1);
        
        b1.addActionListener(new ActionListener<ActionEvent>() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               serab.getListAllAbonner();
            }
        });
        
        
     
     List<CheckBox> checkboxes = new ArrayList<CheckBox>();
     
        int k=0;
        
        
        //lb.setText("+Vos catégories actuel:");
        for (Utilisateur i : lis)
        {
            // CheckBox cb;
            
            k+=1;
            
            ListBoutiqueindex.add(i);
          
            
          //  if(lb.getText().equals(""))
             //   lb.setText(i.getNom_categorie());
           // else
           
            
            cb = new CheckBox(i.getNomBoutique().toString());
            
            

            for(ArtisansFavories j : listAbonner)
            {
                if(i.getId_utilisateur() == j.getId_User() && i.getNomBoutique().equals(j.getNomBoutique()) && Authentification.staticUser.getId_utilisateur() == j.getId_client())
                    cb.setSelected(true);
            }
            
            
            checkboxes.add(cb);
            
            
            //bg.add(rb);
            //rb.setGroup("group");
            FontImage.setMaterialIcon(cb, FontImage.MATERIAL_DONE);
            
            if(k!= lis.size())
            {
                listBoutiques.add(cb);
            }
            
            //lb.setText(lb.getText()+"\n"+"        -"+i.getNom_categorie().toString());
           
            
            cb.addActionListener((evt ) -> {
                
            //if(evt.getSource() == cb ) 
                 //{
                 if(cb.isSelected() == true)
                    {
                        
                        
                        System.out.println("now is not selected");
                        cb.setSelected(false);
                        
                        if(cb.isSelected() == false)
                        {
                            sa.SupprimerAbonnement(i.getId_utilisateur(), Authentification.staticUser.getId_utilisateur());
                        }
                        
                    }
                    else if(cb.isSelected() == false)
                    {
                        System.out.println("now is selected");
                        cb.setSelected(true);
                        if(cb.isSelected()==true)
                        {
                             sa.AddAbonnement(Authentification.staticUser.getNom(), Authentification.staticUser.getPrenom(), i.getNomBoutique(), i.getId_utilisateur(), Authentification.staticUser.getId_utilisateur());
                        }
                       
                    }
           // }
                });
                
        
        
          
            cb.addPointerPressedListener((evt) -> {
                
                    if(cb.isSelected() == true)
                    {
                        
                        System.out.println("now is not selected");
                        cb.setSelected(false);
                        
            
                        if(cb.isSelected() == false)
                        {
                            sa.SupprimerAbonnement(i.getId_utilisateur(), Authentification.staticUser.getId_utilisateur());
                        }
                        
                        
                    }
                    else if(cb.isSelected() == false)
                    {
                        System.out.println("now is selected");
                        cb.setSelected(true);
                        if(cb.isSelected()==true)
                        {
                             sa.AddAbonnement(Authentification.staticUser.getNom(), Authentification.staticUser.getPrenom(), i.getNomBoutique(), i.getId_utilisateur(), Authentification.staticUser.getId_utilisateur());
                        }
                       
                    }
                });
            
        }
       
        
        for(CheckBox cb : checkboxes)
        {
            
            
            i = ListBoutiqueindex.get(checkboxes.indexOf(cb));
            
            cb.addActionListener((evt) -> {
                

                 if(cb.isSelected() == true)
                    {
                        
                        
                        System.out.println("now is not selected");
                        cb.setSelected(false);
                        
                        if(cb.isSelected() == false)
                        {
                            sa.SupprimerAbonnement(i.getId_utilisateur(), Authentification.staticUser.getId_utilisateur());
                        }
                        
                    }
                    else if(cb.isSelected() == false)
                    {
                        System.out.println("now is selected");
                        cb.setSelected(true);
                        if(cb.isSelected()==true)
                        {
                             sa.AddAbonnement(Authentification.staticUser.getNom(), Authentification.staticUser.getPrenom(), i.getNomBoutique(), i.getId_utilisateur(), Authentification.staticUser.getId_utilisateur());
                        }
                       
                    }
                });
        }
        
        
        
     
        
        
        
        
        
        
        RadioButton rb1 = new RadioButton("This is a Radio Button 1");
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
        
       
        
        Command back = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if(Authentification.staticUser.getType_user().equals("Client"))
                {
                    ch = new ClientHome();
                    ch.getfClientHome();
                }
                else
                {
                    ah = new ArtisanHome();
                    ah.getfArtisanHome();
                }   
            }

        };
        Image img = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, UIManager.getInstance().getComponentStyle("TitleCommand"));
        back.setIcon(img);
        fProfile.getToolbar().addCommandToLeftBar(back);
        fProfile.getToolbar().setTitleCentered(true);
        fProfile.setBackCommand(back);
        
       /*
        ClientHome chome = new ClientHome();
        //Add navigation commands to the home Form
        NavigationCommand homeCommand = new NavigationCommand("Home");
        homeCommand.setNextForm(chome.getfClientHome());
        fAffichageAbonnement.getToolbar().addCommandToSideMenu(homeCommand);
       
        ArtisanHome ah= new ArtisanHome();
        NavigationCommand cmd1 = new NavigationCommand("Actualités");
        cmd1.setNextForm(chome.getfClientHome());
        fAffichageAbonnement.getToolbar().addCommandToSideMenu(cmd1);
        
        
        ArtisanAbonner aa= new ArtisanAbonner();
        NavigationCommand cmd2 = new NavigationCommand("Mes Abonnées");
        cmd2.setNextForm(aa.getfAffichageArtisanAbonner());
        fAffichageAbonnement.getToolbar().addCommandToSideMenu(cmd2);
        */
       
       /*

        //Add Edit, Add and Delete Commands to the home Form context Menu
        Image im = FontImage.createMaterial(FontImage.MATERIAL_REFRESH, UIManager.getInstance().getComponentStyle("Command"));
        Command edit = new Command("Refrech", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
               
               
                ClientAbonnement clientAb = new ClientAbonnement();
                clientAb.getfAffichageAbonnement().show();
                //System.out.println("Editing");
                /*
                System.out.println(bg.getSelectedIndex());
                System.out.println(ListBoutiqueindex.get(bg.getSelectedIndex()));
                
                String nameCat = ListBoutiqueindex.get(bg.getSelectedIndex()).toString();
                
                cat = new Categorie();
                cat.setNom_categorie(nameCat);
                        
                ServiceCategorie ser = new ServiceCategorie();
                ser.UpdateCategorie(cat, cat);
                
                UpdateCategorie uppcat = new UpdateCategorie();
                    uppcat.getfUpdateCategorie().show();

            }
        };
        fAbout.getToolbar().addCommandToOverflowMenu(edit);
        
        */

        /*
        im = FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("Command"));
        Command add = new Command("Add", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Add");
                //AjouterCategorie ajtCat = new AjouterCategorie();
               // ajtCat.getfAjouterCategorie().show();
            }
        };
        fAffichageAbonnement.getToolbar().addCommandToOverflowMenu(add);

        im = FontImage.createMaterial(FontImage.MATERIAL_DELETE, UIManager.getInstance().getComponentStyle("Command"));
        Command delete = new Command("Delete", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Deleting");
                
                
                System.out.println(bg.getSelectedIndex());
                System.out.println(ListBoutiqueindex.get(bg.getSelectedIndex()));
                
                String nameCat = ListBoutiqueindex.get(bg.getSelectedIndex()).toString();
                
                Categorie cat = new Categorie();
                cat.setNom_categorie(nameCat);
                        

                if (Dialog.show("Attention !!", "Voulez vous vraiment supprimer votre categorie ?", "Confirmer", "Cancel"))
                {
                    ServiceCategorie ser = new ServiceCategorie();
                    ser.SupprimerCategorie(cat);
                    
                    AffichageCategorie affcat = new AffichageCategorie();
                    affcat.getfAffichageCategorie().show();
                }
        

            }

        };
        fAffichageAbonnement.getToolbar().addCommandToOverflowMenu(delete);

       */
        
        
        

        fProfile.show();
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

    public Form getfProfile() {
        return fProfile;
    }

    public void setfProfile(Form fProfile) {
        this.fProfile = fProfile;
    }
    
    
    
}
