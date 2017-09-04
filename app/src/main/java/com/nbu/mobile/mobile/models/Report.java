package com.nbu.mobile.mobile.models;

/**
 * Created by macbookpro on 04.09.17.
 */

public class Report {

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String WAITING = "waiting";

    private int id;

    private int kassaId;
    private String partnerName;
    private int partnerLogo;
    private String dataTime;
    private String summa;
    private String status;

    public Report(int id, int kassaId, String partnerName, int partnerLogo, String dataTime, String summa, String status) {
        this.id = id;
        this.kassaId = kassaId;
        this.partnerName = partnerName;
        this.partnerLogo = partnerLogo;
        this.dataTime = dataTime;
        this.summa = summa;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getKassaId() {
        return kassaId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public int getPartnerLogo() {
        return partnerLogo;
    }

    public String getDataTime() {
        return dataTime;
    }

    public String getSumma() {
        return summa;
    }

    public String getStatus() {
        return status;
    }
}
