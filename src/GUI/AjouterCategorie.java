/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.NavigationCommand;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.Entite.Categorie;
import com.mycompany.Service.ServiceCategorie;
import java.util.ArrayList;

/**
 *
 * @author khaled Chebbi
 */
public class AjouterCategorie {
    
    Form fAjouterCategorie;
    
    
    
    public AjouterCategorie()
    {
         //create and build the home Form
        fAjouterCategorie = new Form("Ajouter votre categorie");
        fAjouterCategorie.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        //fAffichageCategorie.addComponent(new Label("This is a Label"));
        //fAffichageCategorie.addComponent(new Button("This is a Button"));
        
        
        
        
        
           TextField txtCategorie = new TextField();
           txtCategorie.setHint("saisir votre categorie...");
           fAjouterCategorie.addComponent(txtCategorie);
           
           
           
           
           
           
        
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
        
        Button b1 = new Button("Ajouter");
        b1.addActionListener(new ActionListener() {

                   
            
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceCategorie ser = new ServiceCategorie();
                Categorie cat = new Categorie(txtCategorie.getText());
                ser.ajoutCategorie(cat);
                if (Dialog.show("Succés", "Votre categorie a ajouté avec succés", "Ok", "Cancel"))
                {
                    AffichageCategorie affcat = new AffichageCategorie();
                    affcat.getfAffichageCategorie().show();
                }
                
            }
        });
        
        fAjouterCategorie.addComponent(b1);

    
        
        //Create Form1 and Form2 and set a Back Command to navigate back to the home Form        
        Form form1 = new Form("Form1");
        setBackCommand(form1);
        Form form2 = new Form("Form2");
        setBackCommand(form2);
        
        AffichageCategorie affcat = new AffichageCategorie();
        //Add navigation commands to the home Form
        NavigationCommand homeCommand = new NavigationCommand("Categories");
        homeCommand.setNextForm(affcat.getfAffichageCategorie());
        fAjouterCategorie.getToolbar().addCommandToSideMenu(homeCommand);

        NavigationCommand cmd1 = new NavigationCommand("Form1");
        cmd1.setNextForm(form1);
        fAjouterCategorie.getToolbar().addCommandToSideMenu(cmd1);

        NavigationCommand cmd2 = new NavigationCommand("Form2");
        cmd2.setNextForm(form2);
        fAjouterCategorie.getToolbar().addCommandToSideMenu(cmd2);

        
        setBackCommand2(fAjouterCategorie);
        fAjouterCategorie.show();
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

    public Form getfAjouterCategorie() {
        return fAjouterCategorie;
    }

    public void setfAjouterCategorie(Form fAjouterCategorie) {
        this.fAjouterCategorie = fAjouterCategorie;
    }
    
    
    

    }
    

