/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.ids.service.impl;

import com.hxwr.ids.service.ICreateReportSrv;
import com.hxwr.lds.entities.Client;
import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.model.LoanReport;
import com.hxwr.lds.model.Payment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * implements the real way to create the loan report
 *
 * @author 35194
 */
public class CreateReportSrvImpl implements ICreateReportSrv {

    @Override
    public LoanReport CreateReport(Loan loan, Client client) {

        LoanReport loanReport = new LoanReport();
        double amount;
        double interest;
        double paymentAmount;
        int loanPeriodmonths;
        double monthlyInterest;
        List<Payment> payments = new ArrayList<>();

        //getting current date;
        //get current date        
        Calendar date = Calendar.getInstance();

        //add client and loan to loanReport
        loanReport.setClient(client);
        loanReport.setLoan(loan);

        //obtain loan amount
        amount = loan.getAmount();

        //convert interest percentage to decimal
        interest = loan.getInterest() / 100;

        //calculate month interest rate
        monthlyInterest = interest / 12;

        //convert loan period to months
        loanPeriodmonths = Integer.parseInt(loan.getLoanPeriod()) * 12;

        //calculate monthly payments
        paymentAmount = (amount * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -loanPeriodmonths));

        //add monthly payments to payments list
        for (int i = 0; i < loanPeriodmonths; i++) {
            //increment date by one month
            date.add(Calendar.MONTH, i + 1);

            //subtract the monthly payment and add the monthly interest
            amount = (amount - paymentAmount) + (amount * monthlyInterest);
            Payment monthlyPayment = new Payment(paymentAmount, amount, date);

            //add new monthlyPayment to payments list
            payments.add(monthlyPayment);
        }

        //add payments list to loanReport
        loanReport.setMonthPaymentLst(payments);

        return loanReport;
    }
}
