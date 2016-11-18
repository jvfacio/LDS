/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.core.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author joseph
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "paymentdetailID",
        scope = PaymentDetail.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PaymentDetail implements Serializable {

    private int paymentdetailID;
    private int numOfPayment;
    private double beginningBalance;
    private double interest;
    private double principal;
    private double endingBalance;
    private Calendar date;

    private Loan loan;

    /**
     *
     * @return PaymentdetailID
     */
    public int getPaymentdetailID() {
        return paymentdetailID;
    }

    /**
     *
     * @param paymentdetailID to set
     */
    public void setPaymentdetailID(int paymentdetailID) {
        this.paymentdetailID = paymentdetailID;
    }

    /**
     *
     * @return numOfPayment
     */
    public int getNumOfPayment() {
        return numOfPayment;
    }

    /**
     *
     * @param numOfPayment the index of the payment to set
     */
    public void setNumOfPayment(int numOfPayment) {
        this.numOfPayment = numOfPayment;
    }

    /**
     *
     * @return the beginningBalance
     */
    public double getBeginningBalance() {
        return beginningBalance;
    }

    /**
     *
     * @param beginningBalance the beginningBalance to set
     */
    public void setBeginningBalance(double beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    /**
     *
     * @return the interest
     */
    public double getInterest() {
        return interest;
    }

    /**
     *
     * @param interest the interest paid for the current month
     */
    public void setInterest(double interest) {
        this.interest = interest;
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

    /**
     *
     * @return the endingBalance
     */
    public double getEndingBalance() {
        return endingBalance;
    }

    /**
     *
     * @param endingBalance the balance after the current payment
     */
    public void setEndingBalance(double endingBalance) {
        this.endingBalance = endingBalance;
    }

    /**
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     *
     * @return the date formatted as a String
     */
    public String getFormattedDate() {
        if (date == null) {
            return null;
        } else {
            return new SimpleDateFormat("MM-dd-yyyy").format(date.getTime());
        }
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     *
     * @return loan
     */
    @JsonIgnore
    public Loan getLoan() {
        return loan;
    }

    /**
     *
     * @param loan
     */
    @JsonProperty
    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    /**
     *
     * @return paymentAmount
     */
    public double getPaymentAmount() {
        return (interest + principal);
    }

}
