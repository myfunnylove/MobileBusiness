package com.nbu.mobile.mobile.models;

/**
 * Created by Sarvar on 04.09.2017.
 */

public class Balance {

    private String balance;
    private String cardNumber;
    private String cardDate;

    public Balance(String balance, String cardNumber, String cardDate) {
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
    }

    public String getBalance() {
        return balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardDate() {
        return cardDate;
    }
}
