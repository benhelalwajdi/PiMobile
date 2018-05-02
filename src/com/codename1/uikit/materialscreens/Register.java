/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.materialscreens;

import com.allforkids.Service.ServiceUser;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 * The Login form
 *
 * @author Shai Almog
 */
public class Register extends Form {
    String role;
     ServiceUser su=new ServiceUser();
    public Register(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
       
      //  Container welcome = FlowLayout.encloseCenter(
        //        new Label("", "WelcomeWhite"),
          //      new Label("", "WelcomeBlue")
       // );
        
        getTitleArea().setUIID("Container");
        Label la=new Label("Inscription");
        la.setUIID("LoginButton");
        la.getAllStyles().setAlignment(CENTER);
        la.getAllStyles().setBgColor(0xE12336);
        Image profilePic = theme.getImage("logoAllforKids.png");
        //Image mask = theme.getImage("logoAllforKids.png");
        //profilePic = profilePic.fill(100,100);
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
      // profilePicLabel.setMask(mask.createMask());
        TextField username = new TextField("Username", "Login", 20, TextField.EMAILADDR) ;
        TextField mail = new TextField("Email", "Mail", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("Password", "Password", 20, TextField.PASSWORD) ;
        TextField password2 = new TextField("Confirmer Password", "Password", 20, TextField.PASSWORD) ;
        ComboBox <String> combo = new ComboBox<> ("Parent","Medecin","Vendeur","Jardin Enfant","Baby Sitter","Enseignant"); 
        if(combo.getSelectedItem().toString().equals("Medecin")){
         role="a:1:{i:0;s:12:"+"ROLE_MEDECIN"+";}";}
         if(combo.getSelectedItem().equals("Parent")){
         role="a:1:{i:0;s:12:"+"ROLE_PARENT"+";}";}
          if(combo.getSelectedItem().equals("Baby Sitter")){
         role="a:1:{i:0;s:12:"+"ROLE_BS"+";}";}
         if(combo.getSelectedItem().equals("Enseignant")){
         role="a:1:{i:0;s:15:"+"ROLE_ENSEIGNANT"+";}";}
         if(combo.getSelectedItem().equals("Jardin Enfant")){
         role="a:1:{i:0;s:7:"+"ROLE_JD"+";}";}
         if(combo.getSelectedItem().equals("Vendeur")){
         role="a:1:{i:0;s:12:"+"ROLE_VENDEUR"+";}";}
        Button EnregistrerButton = new Button("Enregistrer");
        EnregistrerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         su.register(username.getText(), mail.getText(), password.getText(), role);
        }
    });
        Button AnnulerButton = new Button("Annuler");
        AnnulerButton.addActionListener((evt) -> {
            LoginForm l=new LoginForm(theme);
            l.show();
        });
        Container c = new Container(BoxLayout.y());
        c.addAll(la,username,mail,password,password2,combo,AnnulerButton,EnregistrerButton);
        add(BorderLayout.CENTER,c);
        
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        
        
       
    }
}
