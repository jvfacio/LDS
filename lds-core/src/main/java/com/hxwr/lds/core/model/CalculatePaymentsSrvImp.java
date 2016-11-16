package com.hxwr.lds.core.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.entities.PaymentDetail;
import java.util.Calendar;
import com.hxwr.lds.core.service.ICalculatePaymentsSrv;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * implements the calculations for the payment details
 *
 * @author 35194
 */
@Service
public class CalculatePaymentsSrvImp implements ICalculatePaymentsSrv {

    @Override
    public List<PaymentDetail> CalculatePayments(Loan loan) {

        
        double beginningBalance;
        double interest;
        double paymentAmount;
        int loanPeriodmonths;
        double monthlyInterest;
        double endingBalance;
        double principal;
        double monthInterestAmount;
        List<PaymentDetail> payments = new ArrayList<>();

        //get current date        
        Calendar date = Calendar.getInstance();

        //obtain the initial loan amount
        beginningBalance = loan.getAmount();

        //convert interest percentage to decimal
        interest = loan.getInterest() / 100;

        //calculate month interest rate
        monthlyInterest = interest / 12;

        //convert loan period to months
        loanPeriodmonths = Integer.parseInt(loan.getLoanPeriod()) * 12;

        //calculate monthly payments
        paymentAmount = (beginningBalance * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -loanPeriodmonths));

        //add monthly payments to payments list
        for (int i = 0; i < loanPeriodmonths; i++) {
            
            //the amount of interest payed for the month
            monthInterestAmount = beginningBalance * monthlyInterest; 
            
            //the amount of principal paid for the month
            principal= paymentAmount - monthInterestAmount;
            
            //get the current date
            Calendar nextdate = (Calendar) date.clone();
            
            //increment the date my the necessary months
            nextdate.add(Calendar.MONTH, i + 1);
            
            endingBalance = beginningBalance - principal;
            
            PaymentDetail monthlyPayment = new PaymentDetail();
            
            //add payment information
            monthlyPayment.setBeginningBalance(beginningBalance);
            monthlyPayment.setInterest(monthInterestAmount);
            monthlyPayment.setDate(nextdate);
            monthlyPayment.setNumOfPayment(i+1);
            monthlyPayment.setPrincipal(principal);
            monthlyPayment.setEndingBalance(endingBalance);
            monthlyPayment.setPaymentAmount(paymentAmount);

            //add new monthlyPayment to payments list
            payments.add(monthlyPayment);
            
            //make the the current ending balance the beginning balance for the next payment
            beginningBalance = endingBalance;
        }

        return payments;
    }

}
