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
import com.allforkids.Service.ServiceRecette;
import static com.allforkids.Service.ServiceUser.userid;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
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
import static com.codename1.uikit.materialscreens.AffichageRecette.r;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Represents a user profile in the app, the first form we open after the
 * walkthru
 *
 * @author Shai Almog
 */
public class AffichageDetailsRecette extends SideMenuBaseForm {
ConnectionRequest cr;
    String message;
    String message2;
    String message3;
                    ServiceRecette ServiceRecette=new ServiceRecette();
    private Image img;
    private ImageViewer imgv;
    private EncodedImage enc;
    public static EntitySpecialiste specDetails = new EntitySpecialiste();
    private Resources theme = UIManager.initFirstTheme("/theme");

    public AffichageDetailsRecette(Resources res) {

        super(BoxLayout.y());

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        Label tit = new Label("Detail Recette", "Title");
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

        Label Liste = new Label("Detail Recette");
     
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

      

      
      try {
            enc=EncodedImage.create("/giphy.gif").scaledEncoded(200, 200);
            String url="http://localhost:8888/images/"+r.getNom_img();
                    img=URLImage.createToStorage(enc, url,url, URLImage.RESIZE_SCALE);
                    imgv=new ImageViewer(img);
             SpanLabel Ingred = new SpanLabel("Ingredients : "+r.getIngredients());
                     
                             
            Label Nom = new Label("Nom : "+r.getNom());
            Button like=new Button("like");
            like.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
          String urlinsertlike="http://localhost:8888/PiMobile/insertlike.php?user="+userid+"&recette="+r.getId()+"";
                      cr=new ConnectionRequest(urlinsertlike);
                      
                    cr.addResponseListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent evt) {
                         try { 
                             message= new String(cr.getResponseData(), "utf-8");
                                if(message.equals("ok")){
                    Dialog.show("Scucces","Like  ajoutée ","ok",null);}

                        ServiceRecette.updatenbrlike(r.getId());
                                AffichageDetailsRecette af=new AffichageDetailsRecette(theme);
                        af.show();
                    
                                
                             } catch (UnsupportedEncodingException ex) {
                             }
                     }
                 });
                                NetworkManager.getInstance().addToQueue(cr);           
                }
            });
                Button dislike=new Button("dislike");
                dislike.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                     String urlinsertlike="http://localhost:8888/PiMobile/insertdislike.php?user="+userid+"&recette="+r.getId()+"";
                      cr=new ConnectionRequest(urlinsertlike);
                      
                    cr.addResponseListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent evt) {
                         try { 
                             message= new String(cr.getResponseData(), "utf-8");
                                if(message.equals("ok")){
                    Dialog.show("Scucces","dislike  ajoutée ","ok",null);   
ServiceRecette.updatenbrdislike(r.getId());
                        AffichageDetailsRecette af=new AffichageDetailsRecette(theme);
                        af.show();
                  
}
                             } catch (UnsupportedEncodingException ex) {
                             }
                     }
                 });
                                NetworkManager.getInstance().addToQueue(cr);   
                }
            });
                
                Container x=new Container(BoxLayout.y());
        String urllike="http://localhost:8888/PiMobile/veriflike.php?id="+userid+"&recette="+r.getId()+"";
                      cr=new ConnectionRequest(urllike);
                      
                    cr.addResponseListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent evt) {
                         try { 
                             
                             message= new String(cr.getResponseData(), "utf-8");
                                if(message.equals("like")){
                                   x.add(dislike);
                                    System.out.println("zzz");
                                   }else{
                                    System.out.println("sss");
                    x.add(like); 
                                }  

                             } catch (UnsupportedEncodingException ex) {
                             }
                         
                                    
                        
                     }
                 });
                                NetworkManager.getInstance().addToQueueAndWait(cr);
                                Container l=new Container(BoxLayout.y());
                                l.addAll(Nom,Ingred,imgv);
              addAll(ComponentGroup.enclose(l),x);
                               } catch (IOException ex) {
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
