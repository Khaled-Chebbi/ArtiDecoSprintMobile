/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import com.mycompany.Entite.Produit;
import com.mycompany.Service.ServiceProduit;



import java.util.ArrayList;

/**
 *
 * @author sana
 */
public class Affichage {

    Form f,f2,f3;
TextField titremod;
    TextField image; 
    TextField prix;
    TextField quantite; 
    ComboBox<String> couleurCombobox;
    ComboBox<String> catCombobox;
    TextField description;
    
    
    Button btnajout,btnaff;
     String url="";
     private Resources theme =UIManager.initFirstTheme("/theme");

    ImageViewer imageViewer;
    EncodedImage imgEncodedImg;
    URLImage urlImage;
    Label titre;
    Button modifier,supprimer;

    public Affichage() {
        
       
        f = new Form("liste des produits",BoxLayout.y());
         TextField txtSearch = new TextField();
        Container cont = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Button btnSearch = new Button("search");
        txtSearch.setHint("Search User");
        cont.add(btnSearch);

        btnSearch.addActionListener(e -> {
            if (txtSearch.getText().equals("")) {
                Dialog.show("Details", "Please Type What You Are Searching For", "Ok", null);
            } else {
                new SearchProduct().start(txtSearch.getText());
            }

        });
        
        
        cont.add(txtSearch);
        f.add(cont);
       
        ServiceProduit serviceProduit=new ServiceProduit();
        ArrayList<Produit> lis=serviceProduit.getList2();       
       for (Produit p : lis) {        
        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            //url="http://localhost/Pidevmobile/image/"+p.getImage();
           // System.out.println("path = "+url);
           // imgEncodedImg  = EncodedImage.createFromImage(theme.getImage("B2.png"),true);
          //  urlImage = URLImage.createToStorage(imgEncodedImg, url, url);
         //   imageViewer = new ImageViewer(urlImage);
        supprimer=new Button("supprimer");
        supprimer.addActionListener((evt) -> {
          //????????????????????????????????
       });
        
                
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      titre = new Label(p.getTitre());
     //Label nomc=new Label(p.getNomCategorie());
     
     
      C1.add(titre);
     // C1.add(nomc);

        //C1.add(imageViewer);
        C1.add(new Label(": "+p.getPrix()));
       C1.add(new Label(": "+p.getDescription()));
      
        
        
        
        
        
                
        C1.add(C2);
        
        C1.setLeadComponent(titre);      
        f.add(C1);
        Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
          modifier=new Button("modifier");
    C3.add(modifier);
    C3.add(supprimer);
    f.add(C3);
     titre.addPointerPressedListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
            f2 = new Form(BoxLayout.y());
            Toolbar tb = f2.getToolbar();
        
            tb.addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, e->{
            
           f.showBack();
            });
              // url="http://localhost/Pidevmobile/image/"+p.getImage();
          //  System.out.println("path = "+url);
           // imgEncodedImg  = EncodedImage.createFromImage(theme.getImage("TileBackground.jpg"),false);
           // urlImage = URLImage.createToStorage(imgEncodedImg, url, url);
           // imageViewer = new ImageViewer(urlImage);
        
           // f2.add(imageViewer);
   
            f2.add(new Label("prix: "+p.getPrix()));
            f2.add(new Label("quantite: "+p.getQuantite()));
             f2.add("description: "+p.getDescription());
            Button bb=new Button("Partager sur facebook");
            bb.addActionListener((ActionEvent e) -> {
                String accessToken = "EAACEdEose0cBAKRY3jYmKlMAbnZBzWNfKWZAVknJya3VHK0ZBL0JkEj3UJ6ksgH6cg9L94HgXtUHGYPetgdlcliutRUKSnYIe1UZBILg6J5ZBD54EAKdX99Ivi0no132qsCi4GFLB5akJBq70MaNW4Nr5a3W44BBi9NH9UohC6bBrDWr5Ohd7tG3kBLgUrZAL063NOvGdaRAZDZD";
                  
                  
            });
            f2.add(bb);        
           
           f2.show();
                
     
        
    
            }
            

           
        });
  
       modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
          f3 = new Form("Modifier produit",new BoxLayout(BoxLayout.Y_AXIS));
         
        titremod = new TextField("","titre");
      
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
       
     
      
        btnajout = new Button("modifier");
        btnaff=new Button("Affichage");
        
        f3.add(titremod);
        f3.add(catCombobox);
        f3.add(prix);
        f3.add(quantite);
        f3.add(couleurCombobox);
         f3.add(image);
         f3.add(description);
        f3.add(btnajout);
        f3.add(btnaff);
        
           btnajout.addActionListener((e) -> {
            Produit p2 = new Produit(p.getId(),titremod.getText(),catCombobox.getSelectedItem().toString(),Integer.parseInt(prix.getText().trim()),Integer.parseInt(quantite.getText().trim()),couleurCombobox.getSelectedItem().toString(),image.getText(),description.getText());
               System.out.println(p2);
           // sp.modifierProduit(p2);
               System.out.println("modifier aaa");
            

        });
             btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });
              
          f3.show();      
              //serviceProduit.modifierProduit(p);
            }
        });
     
    
                
        
             
         }
       
     
       
        f.show();
    

          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    public TextField gettitre() {
        return titremod;
    }


}
