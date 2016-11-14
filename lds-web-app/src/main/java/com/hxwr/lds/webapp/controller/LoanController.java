/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.controller;

import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.model.LoanReport;
import com.hxwr.lds.core.service.ICreateReportSrv;
import com.hxwr.lds.core.service.ILoanSrv;
import com.hxwr.lds.webapp.service.HTMLViewReportSrv;
import com.hxwr.lds.webapp.service.PDFViewReportSrv;
import com.hxwr.lds.webapp.session.ClientSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            @ModelAttribute ClientSession clientSession,
            String type, String loanperiod,
            String interest, String amount,
            RedirectAttributes redirect) {

        //If the Client is not logged in, redirect to the login page
        if (!clientSession.isLoggedIn()) {
            return "redirect:/customer/login";
        } else {
            
            Client client = clientSession.getClient();
            
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
            redirect.addFlashAttribute("message", "New Loan Created!");

            //Generate a loan report
            LoanReport lr = crs.CreateReport(loan, client);

            //Pass the LoanReport to JSP for rendering
            redirect.addAttribute("report", lr);

            return "redirect:/displayloan";

        }

    }

    @GetMapping(value = "/loan/display")
    public String displayLoan(
            String id, String disp,
            RedirectAttributes redirect,
            HttpServletRequest request, HttpServletResponse response) {

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
            redirect.addFlashAttribute("message", "Loan doesn't exist");
            return "redirect:/customer";
        }
    }
}
