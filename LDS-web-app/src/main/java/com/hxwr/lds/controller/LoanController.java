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
import com.hxwr.lds.service.IViewReportSrv;
import com.hxwr.lds.service.impl.HTMLViewReportSrv;
import com.hxwr.lds.service.impl.PDFViewReportSrv;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    HTMLViewReportSrv HTMLView;

    @Autowired
    PDFViewReportSrv PDFView;

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

    @GetMapping(value = "/loan/display")
    public void displayLoan(HttpServletRequest request, String id,String disp,
            HttpSession session, HttpServletResponse response) {

        //get the loan id
        Integer loanid =  Integer.parseInt(id);
        
        //get the load associated with the loanid

        Loan loan = loanSrv.fetchLoanByID(loanid);

        if (loan != null) {

            //retrieve the customer associated with the loan
            Client client = loan.getClient();

            //create the LoanReport
            LoanReport report = crs.CreateReport(loan, client);

            if (disp.equalsIgnoreCase("HTML")) {
                HTMLView.view(report, request, response);
            } else if (disp.equalsIgnoreCase("PDF")) {
                PDFView.view(report, request, response);
            }

        } else {
            session.setAttribute("message", "Loan doesn't exist");
            //return "customer";
        }
    }
}
