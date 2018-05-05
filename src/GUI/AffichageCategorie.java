/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
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
import java.util.List;

/**
 *
 * @author khaled Chebbi
 */
public class AffichageCategorie {
    
    Form fAffichageCategorie;
    RadioButton rb;
    List catsListindex = new ArrayList<String>();
    public static Categorie cat;
    
    
            
    public AffichageCategorie()
    {
         //create and build the home Form
        fAffichageCategorie = new Form("Vos categories");
        fAffichageCategorie.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        
        //fAffichageCategorie.addComponent(new Label("This is a Label"));
        //fAffichageCategorie.addComponent(new Button("This is a Button"));
       // TextField txt = new TextField();
     //   txt.setHint("This is a TextField");
       // fAffichageCategorie.addComponent(txt);
       // fAffichageCategorie.addComponent(new CheckBox("This is a CheckBox"));
       
        Container listCat = new Container(BoxLayout.y());
        listCat.setScrollableY(true);
        
        
       
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
        
        fAffichageCategorie.add(listCat);
        
        
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
        
        ArtisanHome ah= new ArtisanHome();
        
        Command back = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ah.getfArtisanHome().showBack();
            }

        };
        Image img = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, UIManager.getInstance().getComponentStyle("TitleCommand"));
        back.setIcon(img);
        fAffichageCategorie.getToolbar().addCommandToLeftBar(back);
        fAffichageCategorie.getToolbar().setTitleCentered(true);
        fAffichageCategorie.setBackCommand(back);
        
       

        //Add navigation commands to the home Form
       // NavigationCommand homeCommand = new NavigationCommand("Home");
       // homeCommand.setNextForm(fAffichageCategorie);
       // fAffichageCategorie.getToolbar().addCommandToSideMenu(homeCommand);
       /*
        ArtisanHome ah= new ArtisanHome();
        NavigationCommand cmd1 = new NavigationCommand("Home");
        cmd1.setNextForm(ah.getfArtisanHome());
        fAffichageCategorie.getToolbar().addCommandToSideMenu(cmd1);
        
        ArtisanAbonner aa= new ArtisanAbonner();
        NavigationCommand cmd2 = new NavigationCommand("Mes Abonnées");
        cmd2.setNextForm(aa.getfAffichageArtisanAbonner());
        fAffichageCategorie.getToolbar().addCommandToSideMenu(cmd2);
        */

        //Add Edit, Add and Delete Commands to the home Form context Menu
        Image im = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, UIManager.getInstance().getComponentStyle("Command"));
        Command edit = new Command("Edit", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Editing");
                
                System.out.println(bg.getSelectedIndex());
                System.out.println(catsListindex.get(bg.getSelectedIndex()));
                
                String nameCat = catsListindex.get(bg.getSelectedIndex()).toString();
                
                cat = new Categorie();
                cat.setNom_categorie(nameCat);
                        
                //ServiceCategorie ser = new ServiceCategorie();
                //ser.UpdateCategorie(cat, cat);
                
                UpdateCategorie uppcat = new UpdateCategorie();
                    uppcat.getfUpdateCategorie().show();
            }
        };
        fAffichageCategorie.getToolbar().addCommandToOverflowMenu(edit);

        im = FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("Command"));
        Command add = new Command("Add", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Add");
                AjouterCategorie ajtCat = new AjouterCategorie();
                ajtCat.getfAjouterCategorie().show();
            }
        };
        fAffichageCategorie.getToolbar().addCommandToOverflowMenu(add);

        im = FontImage.createMaterial(FontImage.MATERIAL_DELETE, UIManager.getInstance().getComponentStyle("Command"));
        Command delete = new Command("Delete", im) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //System.out.println("Deleting");
                
                System.out.println(bg.getSelectedIndex());
                System.out.println(catsListindex.get(bg.getSelectedIndex()));
                
                String nameCat = catsListindex.get(bg.getSelectedIndex()).toString();
                
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
        fAffichageCategorie.getToolbar().addCommandToOverflowMenu(delete);

        fAffichageCategorie.show();
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

    public Form getfAffichageCategorie() {
        return fAffichageCategorie;
    }

    public void setfAffichageCategorie(Form fAffichageCategorie) {
        this.fAffichageCategorie = fAffichageCategorie;
    }
    
    
    
    
    
}
