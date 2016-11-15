/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hxwr.lds.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joseph
 */
public class paymentDetail implements Serializable {
    private int paymentdetailID;
    private int numOfPayment;
    private Date beginningBalance;
    private double interest;
    private int principal;
    private int endingBalance;
    private String date;
    
    @JsonIgnore
    private Loan loanid;

    public int getPaymentdetailID() {
        return paymentdetailID;
    }

    public void setPaymentdetailID(int paymentdetailID) {
        this.paymentdetailID = paymentdetailID;
    }

    public int getNumOfPayment() {
        return numOfPayment;
    }

    public void setNumOfPayment(int numOfPayment) {
        this.numOfPayment = numOfPayment;
    }

    public Date getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(Date beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(int endingBalance) {
        this.endingBalance = endingBalance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Loan getLoanid() {
        return loanid;
    }

    public void setLoanid(Loan loanid) {
        this.loanid = loanid;
    }

    
}
