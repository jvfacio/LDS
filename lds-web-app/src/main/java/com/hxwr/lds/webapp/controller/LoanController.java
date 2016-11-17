/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.controller;

import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.service.ILoanSrv;
import com.hxwr.lds.webapp.service.HTMLViewReportSrv;
import com.hxwr.lds.webapp.service.PDFViewReportSrv;
import com.hxwr.lds.webapp.session.ClientSession;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.hxwr.lds.core.service.ICalculatePaymentsSrv;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Training
 */
@Controller
public class LoanController {

    @Autowired ClientSession clientSession;
    
    @Autowired ILoanSrv loanSrv;

    @Autowired HTMLViewReportSrv HTMLView;

    @Autowired PDFViewReportSrv PDFView;

   
    @GetMapping(value = "/loan/create")
    public String createLoan() {
        if(clientSession.isLoggedIn())
            return "createLoan";
        else {
            return "redirect:/customer/login";
        }
    }

    @RequestMapping("/loan/total/{id}")
	public String showIndex(Model model) {
		model.addAttribute("resultado", "Results:");
		return "totals";
	}
    
    @PostMapping(value = "/loan/create")
    public String submitLoan(
            String type, String loanperiod,
            String interest, String amount,
            RedirectAttributes redirect) throws IOException {

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

            //Add the 
            loanSrv.addLoanDetails(loan);

            //Set confirmation message
            redirect.addFlashAttribute("message", "New Loan Created!");

            //Pass the loan to JSP for rendering
            redirect.addFlashAttribute("loan", loan);

            return "redirect:/loan/display?disp=html&id=" + loan.getLoanID();

        }

    }

    @GetMapping(value = "/loan/display")
    public String displayLoan(
            String id, String disp,
            RedirectAttributes redirect,
            HttpServletRequest request, HttpServletResponse response) 
        throws IOException
    {
        //get the loan id
        //System.out.println("loan str: " + id);
        Integer loanid =  Integer.parseInt(id);
        //System.out.println("loan int: " + loanid);
        
        //get the loan associated with the loanid

        Loan loan = loanSrv.fetchLoanByID(loanid);
       
        if (loan != null) {

            if (disp.equalsIgnoreCase("HTML")) {
                HTMLView.view(loan, request, response);
                
            } else if (disp.equalsIgnoreCase("PDF")) {
                PDFView.view(loan, request, response);
            }
        } else {
            redirect.addFlashAttribute("message", "Loan doesn't exist");
            return "redirect:/customer";
        }
        return null;
    }
}

