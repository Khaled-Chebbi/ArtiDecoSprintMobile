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
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;

import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;
import java.io.IOException;

/**
 *
 * @author sana
 */
public class HomeForm {

    Form f;
    private Command produit;
   private Command statistique;
   private Command promotion;
    TextField titre;
    TextField image; 
    TextField prix;
    TextField quantite; 
    ComboBox<String> couleurCombobox;
    ComboBox<String> catCombobox;
    TextField description;
    
    Button btnajout,btnaff;

    public HomeForm() {
        f = new Form("Ajout produit",new BoxLayout(BoxLayout.Y_AXIS));
        titre = new TextField("","titre");
     
        image=new TextField("","image");
        description=new TextField("","description");
        prix=new TextField("", "prix", 4, TextArea.NUMERIC);
        quantite=new TextField("", "quantite", 4, TextArea.NUMERIC);
        couleurCombobox=new ComboBox<String>();
        couleurCombobox.addItem("rouge");
        couleurCombobox.addItem("bleu");
        couleurCombobox.addItem("noire");
        couleurCombobox.addItem("marron");
       catCombobox=new ComboBox<String>();
      ServiceProduit sp=new ServiceProduit();
       for (String cnom : sp.getCategories())
       {
           catCombobox.addItem(cnom);
       }
       
      
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        
        f.add(titre);
        f.add(catCombobox);
        f.add(prix);
        f.add(quantite);
        f.add(couleurCombobox);
         f.add(image);
         f.add(description);
        f.add(btnajout);
        f.add(btnaff);
        
       btnajout.addActionListener((e) -> {
            if (titre.getText().equals("")||prix.getText().equals("")||quantite.getText().equals("")) {
                Dialog.show("Details", "Please Type What You Are Searching For", "Ok", null);
            } else {
            ServiceProduit sp1 = new ServiceProduit();
            Produit p = new Produit(0,titre.getText(),catCombobox.getSelectedItem().toString(),Integer.parseInt(prix.getText().trim()),Integer.parseInt(quantite.getText().trim()),couleurCombobox.getSelectedItem().toString(),image.getText(),description.getText());
            sp1.ajoutProduit(p);}
            
            Message m =new Message("test");
            Display.getInstance().sendMessage(new String[]{"mouafek.mezni@esprit.tn"},"produit est ajouter", m);
        });
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });
        
       
        
        
        Image im = FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_CIRCLE, UIManager.getInstance().getComponentStyle("Command"));
        Command edit = new Command("Home", im) {

            public void actionPerformed(ActionEvent evt) {
               
               
               ArtisanHome ah = new ArtisanHome();
               ah.getfArtisanHome().show();
                
                      }
        };
        f.getToolbar().addCommandToOverflowMenu(edit);
      
      
    }
    
    
    
    
   
    
   /* public void actionPerformed(ActionEvent evt) {
        Command cmd=evt.getCommand();
        if (cmd==promotion)
        {
     Affichagepromo p=new Affichagepromo();
            p.getF().show();
        }
            else if (cmd==produit)
        {
            Dialog.show("Nos produits","cree par Mouaek", "ok","cancel");
            
            
        }
           
        
           
            
        }*/


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField gettitre() {
        return titre;
    }

   

}
