/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.model;

import com.hxwr.lds.entities.Customer;
import com.hxwr.lds.entities.Loan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 35194
 */
public class LoanReport { 
    /**
     * Loan information
     */
    Loan loan;
    
    /**
     * customer data
     */
    Customer customer;
    
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Payment> getMonthPaymentLst() {
        return monthPaymentLst;
    }

    public void setMonthPaymentLst(List<Payment> monthPaymentLst) {
        this.monthPaymentLst = monthPaymentLst;
    }
    
    
}
