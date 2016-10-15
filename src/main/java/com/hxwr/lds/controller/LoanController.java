/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.entities.Client;
import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.model.LoanReport;
import com.hxwr.lds.service.ICreateReportSrv;
import com.hxwr.lds.service.ILoanSrv;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Training
 */
@Controller
public class LoanController {

    @Autowired
    ILoanSrv loanSrv;

    @Autowired
    ICreateReportSrv crs;

    @GetMapping(value = "/loan/create")
    public String createLoan() {
        return "createLoan";
    }

    @PostMapping(value = "/loan/create")
    public String submitLoan(
            HttpSession session,
            String type, String loanperiod,
            String interest, String amount) {

        Object rawclient = session.getAttribute("client");

        //If the Client is not logged in, redirect to the login page
        if (rawclient == null || !(rawclient instanceof Client)) {

            return "redirect:/customer/login";
        } else {
            //Cast the Client to correct type
            Client client = (Client) rawclient;

            //Initialize the new Loan object
            Loan loan = new Loan();
            loan.setLoanType(type);
            loan.setLoanPeriod(loanperiod);
            loan.setAmount(Double.parseDouble(amount));
            loan.setInterest(Double.parseDouble(interest));

            //Add the new Loan to the Client
            loan.setClient(client);

            loanSrv.addLoanDetails(loan);

            //Set confirmation message
            session.setAttribute("message", "New Loan Created!");

            //Generate a loan report
            LoanReport lr = crs.CreateReport(loan, client);

            //Pass the LoanReport to JSP for rendering
            session.setAttribute("report", lr);

            return "displayloan";

        }

    }
}
