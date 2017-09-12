package com.nbu.mobile.mobile.models;

import java.util.ArrayList;

/**
 * Created by Sarvar on 05.09.2017.
 */

public class MainMenuItem {

    private int id;

    private String categoryName;

    private ArrayList<UniversalPartners> partners;

    public MainMenuItem(int id, String categoryName, ArrayList<UniversalPartners> partners) {
        this.id = id;
        this.categoryName = categoryName;
        this.partners = partners;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<UniversalPartners> getPartners() {
        return partners;
    }
}
