/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.model;

import java.util.Date;

/**
 *
 * @author Training
 */
public class Payment {

    private double amount;
    private Date date;

    
    public Payment() {
        date = new Date();
        amount = 0;
    }
    
    public Payment(double amount) {
        this.amount = amount;
        date = new Date();
    }
    
    public Payment(double amount, Date date) {
        this.date = date;
        this.amount = amount;
    }
    
    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
