/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.core.model;

import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.entities.Loan;
import java.util.ArrayList;
import java.util.List;


public class LoanReport implements java.io.Serializable{ 
    /**
     * Loan information
     */
    Loan loan;
    
    /**
     * client data
     */
    Client client;
    
    /**
     * the list of monthly payment
     */
    private List<Payment> monthPaymentLst = new ArrayList<>();

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Payment> getMonthPaymentLst() {
        return monthPaymentLst;
    }

    public void setMonthPaymentLst(List<Payment> monthPaymentLst) {
        this.monthPaymentLst = monthPaymentLst;
    }
}
