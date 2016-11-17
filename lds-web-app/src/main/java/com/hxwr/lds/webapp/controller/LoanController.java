/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.controller;

import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.entities.Loan;
import com.hxwr.lds.core.entities.PaymentDetail;
import com.hxwr.lds.core.service.ILoanSrv;
import com.hxwr.lds.webapp.service.PDFViewReportSrv;
import com.hxwr.lds.webapp.session.ClientSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Training
 */
@Controller
public class LoanController {

    @Autowired
    ClientSession clientSession;

    @Autowired
    PDFViewReportSrv PDFView;

    @Autowired
    ILoanSrv loanSrv;

    @GetMapping(value = "/loan/create")
    public String createLoan() {
        if (clientSession.isLoggedIn()) {
            return "createLoan";
        } else {
            return "redirect:/customer/login";
        }
    }

//    @RequestMapping("/loan/total/{id}")
//    public String showIndex(Model model, @PathVariable("id") int id) {
//        try {
//            Loan loan = loanSrv.fetchLoanByID(id);
//            List<PaymentDetail> pdetails = loan.getPaymentDetail();
//
//            double bi = 0;
//            for (PaymentDetail i : pdetails) {
//                bi = bi + i.getInterest();
//            }
//
//            double tot = 0;
//            for (PaymentDetail i : pdetails) {
//                tot = tot + i.getEndingBalance();
//            }
//
//            double monthly = 0;
//            for (PaymentDetail i : pdetails) {
//                monthly = i.getPrincipal() + i.getEndingBalance();
//                break;
//            }
//
//            model.addAttribute("resultado", "Results:");
//            model.addAttribute("paymonthly", monthly);
//            model.addAttribute("numberpayments", pdetails.size());
//            model.addAttribute("totalinteres", bi);
//            model.addAttribute("total", tot);
//        } catch (IOException ex) {
//            System.err.println("Error " + ex.getMessage());
//        }
//        return "totals";
//    }

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

            return "redirect:/loan/display/html?id=" + loan.getLoanID();

        }

    }

    @GetMapping(value = "/loan/display/pdf")
    public String displayLoanPDF(
            @RequestParam(value = "id", required = true) int id,
            HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        Loan loan = loanSrv.fetchLoanByID(id);
        if (loan != null) {
            PDFView.view(loan, request, response);
            return null;
        } else {
            return "redirect:/customer";
        }
    }

    @GetMapping(value = "/loan/display/html")
    public String displayLoanHTML(
            @RequestParam(value = "id", required = true) int id,
            RedirectAttributes redirect,
            Model model)
            throws IOException {
        //get the loan associated with the loanid
        Loan loan = loanSrv.fetchLoanByID(id);
        
        if (loan != null) {
            model.addAttribute("loan", loan);

            //joseph add this for calculate totals, regards
            DecimalFormat decimals = new DecimalFormat("0.00");
            DecimalFormat percentages = new DecimalFormat("0.##");
            List<PaymentDetail> pdetails = loan.getPaymentDetail();
            double interest = 0;
            for (PaymentDetail i : pdetails) {
                interest = interest + i.getInterest();
            }
            double tot = 0;
            for (PaymentDetail i : pdetails) {
                tot = tot + i.getPrincipal();
            }
            double monthly = 0;
            for (PaymentDetail i : pdetails) {
                monthly = i.getPrincipal() + i.getInterest();
                break;
            }
            
            model.addAttribute("paymonthly", decimals.format(monthly));
            model.addAttribute("numberpayments", pdetails.size());
            model.addAttribute("totalinterest", decimals.format(interest));
            model.addAttribute("total", decimals.format(tot + interest));
            model.addAttribute("decimals", decimals);
            model.addAttribute("percentages", percentages);

            return "displayloan";
        } else {
            redirect.addFlashAttribute("message", "Loan doesn't exist");
            return "redirect:/customer";
        }

    }
}
