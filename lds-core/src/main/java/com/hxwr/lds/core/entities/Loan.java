
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Training
 */
public class Loan implements java.io.Serializable{

    private int loanID;
    private String loanType;
    private String loanPeriod;
    private double interest;
    private double amount;
    @JsonIgnore
    private Set<PaymentDetail> paymentDetail = new HashSet<PaymentDetail>();
    
    @JsonIgnore
    private Client client;
    
    public Loan(String loanType, String loanPeriod, double interest, double amount){
        this.loanType=loanType;
        this.loanPeriod=loanPeriod;
        this.interest=interest;
        this.amount=amount;
    }
    

    public Loan() {
        
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Set<PaymentDetail> getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(Set<PaymentDetail> paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
}