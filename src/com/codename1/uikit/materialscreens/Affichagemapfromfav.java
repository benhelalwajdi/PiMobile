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
import com.allforkids.Entite.EntityUser;
import com.allforkids.Service.MessageService;
import com.allforkids.Service.PediatreSpecialisteService;
import com.allforkids.Service.ServiceBlague;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.javascript.JSObject;
import com.codename1.javascript.JavascriptContext;
import com.codename1.ui.BrowserComponent;
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
import com.pofper.maps.api.GoogleDistanceMatrixApi;
import com.pofper.maps.entity.Distance;
import com.pofper.maps.entity.Point;
import com.pofper.maps.entity.Review;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import static com.allforkids.Service.ServiceUser.userid;
/**
 * Represents a user profile in the app, the first form we open after the
 * walkthru
 *
 * @author Shai Almog
 */
public class Affichagemapfromfav extends SideMenuBaseForm {

    private Image img;
    private ImageViewer imgv;
    private EncodedImage enc;
    private Resources res ;
    public static EntitySpecialiste specDetails = new EntitySpecialiste();
    private Resources theme = UIManager.initFirstTheme("/theme");
    EntityUser place; 
    public Affichagemapfromfav(Resources res, EntityUser place) {

       
        super(BoxLayout.y());
        this.res= res ;
         this.place = place;
        System.out.print("now we are in Affiche Baby Sitter"+place.toString());
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

      

      
    
        
    buildForm();
        setupSideMenu(res);
    }
    public void buildForm(){
        Container container = new Container(BoxLayout.y());
        BrowserComponent bc = new BrowserComponent();
        bc.setPreferredH(300);
        
        bc.addWebEventListener("onLoad", new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JavascriptContext context = new JavascriptContext(bc);
                JSObject window = context.getWindow();
                window.call("initialize", new Object[]{
                    36.872530,
                    10.316018,
                    place.getLat(),
                    place.getLng()
                });
            }
        });
        System.out.print(place.getId()+"hhhhhhhh"+place.getNom());
        Distance distance = (new GoogleDistanceMatrixApi("AIzaSyDiFoJPMY8zxTiT8XTEjunsnI5gqKfZAJo").getDistance(
                new Point(36.872530, 10.316018), new Point(place.getLat(), place.getLng())));
        Label distanceLabel = new Label(distance.getFormattedDuration()+ " ("+distance.getFormattedDistance()+")");
        distanceLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        
        Container firstRow = new Container(new FlowLayout());
        firstRow.add(FlowLayout.encloseIn(new Label(place.getNom()), distanceLabel));
         Label imgv;
        if(place.getImage_name() != null && !place.getImage_name().isEmpty()){
            EncodedImage enc = EncodedImage.createFromImage(AffichageBabySitter.theme2.getImage("loading.png"), false);
            URLImage urlImage = URLImage.createToStorage(enc, (new Random()).nextInt()+"", "http://localhost/pidev_32/pidev_3/web/images/users/"+place.getImage_name());
            imgv = new Label(urlImage);
        }else{
            imgv = new Label(AffichageBabySitter.theme2.getImage("default_place.jpg"));
        }
        container.add(imgv);
        Container phoneContainer = new Container(BoxLayout.x());
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        
        Label phoneNumber = new Label(place.getPhone());
        phoneNumber.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        
        phoneContainer.add(phoneLabel);
        phoneContainer.add(phoneNumber);
        
       
        
       
        Container reviewsContainer = new Container(BoxLayout.y());
        reviewsContainer.getAllStyles().setMarginTop(20);
        reviewsContainer.getAllStyles().setMarginBottom(20);
        
        
        reviewsContainer.add(firstRow);
        if(place.getPhone()!= null && !place.getPhone().isEmpty())
            reviewsContainer.add(phoneContainer);
        
        
        container.add(bc);
        container.add(reviewsContainer);
        Button lead = new Button("Contacter");
        lead.setVisible(true);
        System.out.println("id il bs"+place.getId());
        lead.addActionListener((ActionEvent e) -> (new Recovery().setReceiverId(userid, place.getId())));
        container.add(lead);
        Button lead2 = new Button("supprimer Favourier");
        lead.setVisible(true);
        lead.addActionListener((ActionEvent e) -> (new MessageService().ajoutFav(place.getId(),userid)));
         container.add(lead2);
        this.add(container);
        bc.setURL("jar:///assets/MapsView.html");
    }
    
    private Container buildReviewContainer(Review review){
        Container c = new Container(BoxLayout.x());
        c.getAllStyles().setPaddingBottom(20);
        
        Container leftContainer = new Container(BoxLayout.y());
        leftContainer.setWidth(20);
        Container rightContainer = new Container(new BorderLayout());
        
        Label imgv;
         if(place.getImage_name() != null && !place.getImage_name().isEmpty()){
            EncodedImage enc = EncodedImage.createFromImage(AffichageBabySitter.theme2.getImage("loading.png"), false);
            URLImage urlImage = URLImage.createToStorage(enc, (new Random()).nextInt()+"", "http://localhost/pidev_32/pidev_3/web/images/users/"+place.getImage_name());
            imgv = new Label(urlImage);
        }else{
            imgv = new Label(AffichageBabySitter.theme2.getImage("default_place.jpg"));
        }
        leftContainer.add(imgv);
        
        Container firstRow = new Container(new BorderLayout());
        firstRow.getAllStyles().setMarginBottom(0);
        firstRow.getAllStyles().setPaddingBottom(0);
        
        SpanLabel name = new SpanLabel(review.getAuthorName());
        name.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        Container nameContainer = new Container();
        nameContainer.add(name);
        
        Label rating = new Label(review.getRating()+"");
        rating.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        rating.getAllStyles().setMarginRight(0);
        rating.getAllStyles().setPaddingRight(0);
        
        Label ratingStar = new Label(AffichageBabySitter.theme2.getImage("rating-star.png"));
        ratingStar.getAllStyles().setMarginLeft(0);
        ratingStar.getAllStyles().setPaddingLeft(0);
        Container ratingContainer = FlowLayout.encloseRight(rating, ratingStar);
        
        firstRow.add(BorderLayout.CENTER, nameContainer);
        firstRow.add(BorderLayout.EAST, ratingContainer);
        firstRow.setWidth(50);
        
        SpanLabel content = new SpanLabel(review.getText()+" - "+review.getRelativeTimeDescription());
        content.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
        
        rightContainer.getAllStyles().setMarginTop(0);
        rightContainer.getAllStyles().setPaddingTop(0);
        
        rightContainer.add(BorderLayout.NORTH, firstRow);
        rightContainer.add(BorderLayout.SOUTH, content);
        
        c.add(leftContainer);
        c.add(rightContainer);
        return c;
    }
    private void addButtonBottom(Image arrowDown, EntitySpecialiste spec, int color, boolean first, int i) {

       

   
    }

    @Override
    protected void showOtherForm(Resources res) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
