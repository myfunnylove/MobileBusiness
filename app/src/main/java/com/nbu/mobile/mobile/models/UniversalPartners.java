package com.nbu.mobile.mobile.models;

import java.util.ArrayList;

/**
 * Created by macbookpro on 03.09.17.
 */

public class UniversalPartners {

    private int id;
    private int partnerId;
    private String partnerName;
    private int partnerLogo;
    private ArrayList<String> partnerPrefixes;

    public UniversalPartners(int id, int partnerId, String partnerName, int partnerLogo, ArrayList<String> partnerPrefixes) {
        this.id = id;
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.partnerLogo = partnerLogo;
        this.partnerPrefixes = partnerPrefixes;

    }

    public int getId() {
        return id;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public int getPartnerLogo() {
        return partnerLogo;
    }

    public ArrayList<String> getPartnerPrefixes() {
        return partnerPrefixes;
    }
}
