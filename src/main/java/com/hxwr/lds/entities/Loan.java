/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.entities;

import org.hibernate.cfg.*;
import org.hibernate.*;

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
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Loan() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the loanID
     */
    public int getLoanID() {
        return loanID;
    }

    /**
     * @param loanID the loanID to set
     */
    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    /**
     * @return the loanType
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * @param loanType the loanType to set
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    /**
     * @return the loanPeriod
     */
    public String getLoanPeriod() {
        return loanPeriod;
    }

    /**
     * @param loanPeriod the loanPeriod to set
     */
    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest;
    }

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
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
}
