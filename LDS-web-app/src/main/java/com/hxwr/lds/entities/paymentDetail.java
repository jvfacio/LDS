/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hxwr.lds.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joseph
 */
public class paymentDetail implements Serializable {
    private int numOfPayment;
    private Date limitPayDay;
    private double amount;
    private int status;
    private loansApproved loanid;
    private arrears arrear;
    
    private int detailPayID;

    
    public int getDetailPayID() {
        return detailPayID;
    }

    public void setDetailPayID(int detailPayID) {
        this.detailPayID = detailPayID;
    }
    

    public arrears getArrear() {
        return arrear;
    }

    public void setArrear(arrears arrear) {
        this.arrear = arrear;
    }

    public int getNumOfPayment() {
        return numOfPayment;
    }

    public void setNumOfPayment(int numOfPayment) {
        this.numOfPayment = numOfPayment;
    }

    public Date getLimitPayDay() {
        return limitPayDay;
    }

    public void setLimitPayDay(Date limitPayDay) {
        this.limitPayDay = limitPayDay;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public loansApproved getLoanid() {
        return loanid;
    }

    public void setLoanid(loansApproved loanid) {
        this.loanid = loanid;
    }
    
    
    
}
