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
import com.allforkids.Entite.EntitySpecialiste;
import com.allforkids.Service.PediatreSpecialisteService;
import com.allforkids.Service.ServiceBlague;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
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
public class AffichageBlague extends SideMenuBaseForm {

    private Image img;
    private ImageViewer imgv;
    private EncodedImage enc;
    public static EntitySpecialiste specDetails = new EntitySpecialiste();
    private Resources theme = UIManager.initFirstTheme("/theme");

    public AffichageBlague(Resources res) {

        super(BoxLayout.y());

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        Label tit = new Label("Blague", "Title");
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

        Label Liste = new Label("Blague");
     
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

      

      
      ServiceBlague serviceBlague=new ServiceBlague();
        ArrayList<Blague> liste=serviceBlague.getList();
      for(Blague t:liste){
                      Container c = new Container(BoxLayout.y());
                     
             Label Titre = new Label(t.getTitre());
            SpanLabel Desc = new SpanLabel(t.getDescription());
           Button par=new Button("Partager sur FB");
               par.addActionListener(e -> {

            String accessToken = "EAAdcc84ixnUBAAaCT4eFCOb3bgIdxFSowprVok9J4nhnmk82ZAjpfor5ZBCNyUYVW77hNt9ONmWl2Be3ldUl1ZCeKg8E4AiynJLfoGOSGZB57TUE0GVZBiDZArJ5gUfpi8Gxqnko9vUUsJUp7ABZADW0yhKmUSvi4R6TCAsRzXtjbTiiBH5YIzP";

            FacebookClient fbClient = new DefaultFacebookClient(accessToken);
            FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                    Parameter.with("message",t.getTitre()+" "+t.getDescription())
            );
            Dialog.show("Information","Votre blague à été publiée sur facebook","ok",null);
        });
            c.addAll(Titre, Desc,par);
                
                c.getStyle().setBgColor(0x99CCCC);
                c.getStyle().setBgTransparency(255);
                add(ComponentGroup.enclose(c));
             
        }
        setupSideMenu(res);
    }

    private void addButtonBottom(Image arrowDown, EntitySpecialiste spec, int color, boolean first, int i) {

       

   
    }

    @Override
    protected void showOtherForm(Resources res) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
