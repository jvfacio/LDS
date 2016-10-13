/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.service.ICreateReportSrv;
import com.hxwr.lds.dao.ILoanDao;
import com.hxwr.lds.entities.Client;
import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.model.LoanReport;
import com.hxwr.lds.service.ILoanSrv;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author Training
 */
public class LoansHistoryServlet extends HttpServlet {

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
        request.getRequestDispatcher("/WEB-INF/views/loanHistory.jsp").forward(request, response);
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

        // obtain the spring web context
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());

        // obtain the loan service
        ILoanSrv loanSrv = (ILoanSrv) webApplicationContext.getBean("loanSrv");

        // obtain the Create report service bean
        ICreateReportSrv crs = (ICreateReportSrv) webApplicationContext.getBean("createReportSrv");

        
        //Retrieve Client object from the current session
        HttpSession httpSession = request.getSession();
        Object rawClient = httpSession.getAttribute("client");

        //If the Client is not logged in, redirect to the login page
        if (rawClient == null || !(rawClient instanceof Client)) {
            response.sendRedirect("/LDS/customer/login");
        } else {
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
                //Save the new Loan
                loanSrv.addLoanDetails(loan);
          
                //new LoanDao().addLoanDetails(loan);
                //Set confirmation message
                httpSession.setAttribute("message", "New Loan Created!");

                //Generate a loan report
                LoanReport lr = crs.CreateReport(loan, client);

                //Pass the LoanReport to JSP for rendering
                request.setAttribute("report", lr);
                //httpSession.setAttribute("report", lr);

                request.getRequestDispatcher("/WEB-INF/views/displayloan.jsp")
                        .forward(request, response);
                //response.sendRedirect("/LDS/customer/displayloan");

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
