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
public class arrears implements Serializable{
    private int loanid;
    private int numOfPayment;
    private paymentDetail pDetail;
    private double arrearPayAmount;
    private int status;
    private Date payDate;

    public int getLoanid() {
        return loanid;
    }

    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }

    public int getNumOfPayment() {
        return numOfPayment;
    }

    public void setNumOfPayment(int numOfPayment) {
        this.numOfPayment = numOfPayment;
    }

    public paymentDetail getpDetail() {
        return pDetail;
    }

    public void setpDetail(paymentDetail pDetail) {
        this.pDetail = pDetail;
    }

    public double getArrearPayAmount() {
        return arrearPayAmount;
    }

    public void setArrearPayAmount(double arrearPayAmount) {
        this.arrearPayAmount = arrearPayAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    
    
}
