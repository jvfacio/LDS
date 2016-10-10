/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.ids.service.impl.dummy.DummyCRS;
import com.hxwr.lds.LoanDao;
import com.hxwr.lds.entities.Customer;
import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.model.LoanReport;
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

        // obtain the spring web context
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        
        // obtain the Create report service bean
        DummyCRS dummy = webApplicationContext.getBean(DummyCRS.class);
        
       
        Loan loan = new Loan();
        loan.setLoanType(request.getParameter("type"));
        loan.setLoanPeriod(request.getParameter("loanperiod"));
        loan.setAmount(Double.parseDouble(request.getParameter("amount")));
        loan.setInterest(Double.parseDouble(request.getParameter("interest")));
        
        
        HttpSession httpSession = request.getSession();
        try {
            new LoanDao().addLoanDetails(loan);

            httpSession.setAttribute("loanType", request.getParameter("type"));
            httpSession.setAttribute("loanPeriod", request.getParameter("loanperiod"));
            httpSession.setAttribute("loanType", Double.parseDouble(request.getParameter("amount")));
            httpSession.setAttribute("interest", Double.parseDouble(request.getParameter("interest")));
            httpSession.setAttribute("message", "Loan Data Created!");
            response.sendRedirect("/LDS/displayloan");
            LoanReport lr = dummy.CreateReport(loan, new Customer());
            
            //response.sendRedirect("/Success");
        } catch (Exception e) {
            e.printStackTrace();
            try (PrintWriter out = response.getWriter()) {
                out.print(e.toString());
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
