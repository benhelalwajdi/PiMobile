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

import com.allforkids.Entite.Blague;
import com.allforkids.Entite.Commentaire;
import com.allforkids.Entite.Conseil;
import com.allforkids.Entite.EntitySpecialiste;
import com.allforkids.Service.PediatreSpecialisteService;
import com.allforkids.Service.ServiceBlague;
import com.allforkids.Service.ServiceCommentaire;
import static com.allforkids.Service.ServiceUser.userid;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import static com.codename1.uikit.materialscreens.AffichageConseil.conseil;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a user profile in the app, the first form we open after the
 * walkthru
 *
 * @author Shai Almog
 */
public class AffichageCommentaire extends SideMenuBaseForm {
 ServiceCommentaire sc=new ServiceCommentaire();

    private Image img;
    private ImageViewer imgv;
    private EncodedImage enc;
    public static EntitySpecialiste specDetails = new EntitySpecialiste();
    private Resources theme = UIManager.initFirstTheme("/theme");

    public AffichageCommentaire(Conseil cons,Resources res) {

        super(BoxLayout.y());

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        Label tit = new Label("Commentaires", "Title");
        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                tit
                        )
                ),
                GridLayout.encloseIn(2)
        );

        tb.setTitleComponent(titleCmp);

        Label Liste = new Label("Commentaires");
     
        Label Liste0 = new Label(" ");
        Liste.getAllStyles().setFgColor(0xE12336);

        Container listCon = BoxLayout.encloseY(
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                Liste
                        )
                ),
                GridLayout.encloseIn(2)
        );
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);

      

      
                         conseil=cons;
                         ArrayList<Commentaire> liste=sc.getListcom(conseil.getId());
                         for(Commentaire t:liste){
                         Container c = new Container(BoxLayout.y());
                     
             Label nom = new Label(t.getNomuser());
            SpanLabel texte = new SpanLabel(t.getTexte());
            
            
                      
            c.addAll(nom,texte);
            if(userid==t.getIduser()){
                
                  TextArea te=new TextArea();
                            te.setText(t.getTexte());
                            c.add(te);
            Button sup=new Button("Supprimer");
            sup.addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent evt) {
                                 sc.supprimercommentaire(t.getId());
                             AffichageCommentaire af=new AffichageCommentaire(conseil, theme);
                             af.show();
                             
                             }
                         });
            Button mod=new Button("     Modifier");
            mod.addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent evt) {
                            sc.modifiercommentaire(te.getText(),t.getId());
         AffichageCommentaire af=new AffichageCommentaire(conseil, theme);
                             af.show();
                             }
                         });
            Container btn = new Container(BoxLayout.x());
            btn.addAll(sup,mod);
            btn.getAllStyles().setAlignment(CENTER);
                            c.addAll(btn);
            } 
            add(ComponentGroup.enclose(c));
                         }  
            Button ajt=new Button("Ajouter");
            TextArea tex=new TextArea(); 
            addAll(tex,ajt);
          ajt.addActionListener(new ActionListener() {
                             @Override
                             public void actionPerformed(ActionEvent evt) {
                             sc.ajoutercommentaire(userid,conseil.getId(),tex.getText());

                             }
                         });
                          
        setupSideMenu(res);
    }

    private void addButtonBottom(Image arrowDown, EntitySpecialiste spec, int color, boolean first, int i) {

       

   
    }

    @Override
    protected void showOtherForm(Resources res) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
