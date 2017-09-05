package com.nbu.mobile.mobile.models;

/**
 * Created by Sarvar on 05.09.2017.
 */

public class MainMenuItem {

    private int id ;
    private String logo;
    private String partnerName;
    private String secondaryName;

    public MainMenuItem(int id, String logo, String partnerName, String secondaryName) {
        this.id = id;
        this.logo = logo;
        this.partnerName = partnerName;
        this.secondaryName = secondaryName;
    }

    public int getId() {
        return id;
    }

    public String getLogo() {
        return logo;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getSecondaryName() {
        return secondaryName;
    }
}
