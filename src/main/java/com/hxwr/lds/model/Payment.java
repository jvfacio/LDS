/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Training
 */
public class Payment {

    private double amount;
    private Date date;
    private double principal;

    
    public Payment() {
        this(0, 0, new Date());
    }
    
    public Payment(double amount, double principal) {
        this(amount, principal, new Date());
    }
    
    public Payment(double amount, double principal, Date date) {
        this.date = date;
        this.principal = principal;
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
    
    public String getFormattedDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the principal
     */
    public double getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(double principal) {
        this.principal = principal;
    }

}
