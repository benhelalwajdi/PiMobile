package com.codename1.uikit.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Tabs;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.pofper.maps.api.GooglePlacesApi;
import com.pofper.maps.entity.Place;
import com.pofper.maps.entity.Point;
import com.codename1.uikit.materialscreens.AffichageBabySitter;
import java.util.List;

public class BabySitterListView {
    private Form form;
    private Form parentForm;
    private List<Place> babysitter;
    private List<Place> rests;
    private List<Place> parks;
    
    private Container tab1 = new Container(BoxLayout.y()); 
    private Container tab2 = new Container(BoxLayout.y());;
    private Container tab3 = new Container(BoxLayout.y());
    
    private final String KEY = "AIzaSyCiVB-qwVIdq-xykpRt-H2Xf27SVIYO0iY";
    
    public BabySitterListView(Point location, int range, int maxPhotoWidth, int maxPhotoHeight, Form parentForm){
        this.parentForm = parentForm;
        form = new Form(new BorderLayout());
        
        Tabs tab = new Tabs();
        tab.getAllStyles().setBgColor(0xffffff);
        tab.addSelectionListener((o, n) -> {
            switch(n){
                case 0:
                    if(babysitter == null){
                        try {
                            babysitter = (new GooglePlacesApi(KEY)).getNearByPlaces(
                                    location,
                                    GooglePlacesApi.PLACE_TYPE.CAFE,
                                    range,
                                    maxPhotoWidth,
                                    maxPhotoHeight);
                            buildContainer(babysitter, tab1);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    break;
                
            }
        });
        tab.addTab("BabySitter", tab1);
        
        try {
            babysitter = (new GooglePlacesApi(KEY)).getNearByPlaces(
                    location,
                    GooglePlacesApi.PLACE_TYPE.CAFE,
                    range,
                    maxPhotoWidth,
                    maxPhotoHeight);
            buildContainer(babysitter, tab1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        form.add(BorderLayout.CENTER, tab);
        form.getToolbar().addCommandToLeftBar("Back", AffichageBabySitter.theme.getImage("back-command.png"), (ev) -> {
            parentForm.showBack();
        });
    }
    
    private void buildContainer(List<Place> places, Container c){
        c.setScrollableY(true);
        for(Place place : places){
            c.add((new BabySitterView(place, form)).getContainer());
        }
    }
    
    public Form getContainer(){
        return this.form;
    }
}
