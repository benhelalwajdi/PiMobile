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
import com.allforkids.Service.ServiceUser;
import static com.allforkids.Service.ServiceUser.roleuser;
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
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a user profile in the app, the first form we open after the
 * walkthru
 *
 * @author Shai Almog
 */
public class AffichageUser extends SideMenuBaseForm {

    private Image img;
    private ImageViewer imgv;
    private EncodedImage enc;
    public static EntitySpecialiste specDetails = new EntitySpecialiste();
    private Resources theme = UIManager.initFirstTheme("/theme");

    public AffichageUser(Resources res) {

        super(BoxLayout.y());

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        Label tit = new Label("Utilisateur", "Title");
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

        Label Liste = new Label("Utilisateur");
     
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
        Label l5=new Label("Nom : "+ServiceUser.nomuser);
        Label l6=new Label(ServiceUser.nomuser);
      Label l=new Label("Email : ");
        Label l2=new Label(ServiceUser.mailuser);
        Label l3=new Label("Role : ");
        int x=roleuser.indexOf("R");
        Label l4=new Label(ServiceUser.roleuser.substring(x,roleuser.length()-2));
        addAll(ComponentGroup.enclose(l5,l2,l4));
        setupSideMenu(res);
    }

    private void addButtonBottom(Image arrowDown, EntitySpecialiste spec, int color, boolean first, int i) {

       

   
    }

    @Override
    protected void showOtherForm(Resources res) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
