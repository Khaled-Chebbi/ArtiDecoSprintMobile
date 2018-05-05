package com.mycompany.Formulaire;

import GUI.Authentification;
import com.codename1.components.ImageViewer;
import static com.codename1.ui.CN.*;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.validation.GroupConstraint;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    private Form home;
    ImageViewer imageViwer;
    EncodedImage imgEncodedImage;
   

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        //Log.bindCrashProtection(true);
        
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }

        
         Authentification auth = new Authentification();
         auth.getfAuthentification().show();
        
/*
    private void showOKForm(String name ,String prenom) {
        Form f = new Form(name+" "+prenom, BoxLayout.y());
        imgEncodedImage =EncodedImage.createFromImage(theme.getImage("B2.png").fill(50, 50),false);
        imageViwer=new ImageViewer(imgEncodedImage);
        f.add(imageViwer);
        f.getToolbar().setBackCommand("", e -> home.showBack());
        f.show();
    
    */

    }
    
    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }

    public void destroy() {
    }

}
