/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.LoanDao;
import com.hxwr.lds.entities.Client;
import com.hxwr.lds.entities.Loan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Training
 */
public class CreateLoanServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/createLoan.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Retrieve Client object from the current session
        HttpSession httpSession = request.getSession();
        Object rawClient = httpSession.getAttribute("client");
        
        //If the Client is not logged in, redirect to the login page
        if(rawClient == null || !(rawClient instanceof Client)) {
            response.sendRedirect("/LDS/customer/login");
        }
        else {
            //Cast the Client to correct type
            Client client = (Client) rawClient;
            
            //Initialize the new Loan object
            Loan loan = new Loan();
            loan.setLoanType(request.getParameter("type"));
            loan.setLoanPeriod(request.getParameter("loanperiod"));
            loan.setAmount(Double.parseDouble(request.getParameter("amount")));
            loan.setInterest(Double.parseDouble(request.getParameter("interest")));
            
            //Add the new Loan to the Client
            loan.setClient(client);
            
            try {
                new LoanDao().addLoanDetails(loan);
                //Set confirmation message
                httpSession.setAttribute("message", "New Loan Created!");
                response.sendRedirect("/LDS/displayloan");
                //response.sendRedirect("/Success");
            } catch (Exception e) {
                e.printStackTrace();
                try (PrintWriter out = response.getWriter()) {
                    out.print(e.toString());
                }
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
