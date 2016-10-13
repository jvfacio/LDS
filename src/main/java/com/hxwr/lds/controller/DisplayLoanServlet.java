/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.service.ILoanSrv;
import com.hxwr.lds.service.impl.CreateReportSrvImpl;
import com.hxwr.lds.entities.Client;
import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.model.LoanReport;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "DisplayLoanServlet", urlPatterns = {"/DisplayLoanServlet"})
public class DisplayLoanServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        //get the loan id
        Integer loanid = Integer.parseInt(request.getParameter("id").trim());
        Integer dispop = Integer.parseInt(request.getParameter("disp"));
        System.out.println(dispop);
        //get the load associated with the loanid
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        ILoanSrv loanSrv=(ILoanSrv) webApplicationContext.getBean("loanSrv");
        Loan loan=loanSrv.fetchLoanByID(loanid);
        //Loan loan = new LoanDao().getByLoanID(loanid);

        if (loan != null) {

            //retrieve the customer associated with the loan
            Client client = loan.getClient();

            //create LoanReport
            CreateReportSrvImpl createReport = new CreateReportSrvImpl();
            LoanReport report = createReport.CreateReport(loan, client);

            //set report attribute
            session.setAttribute("report", report);
            
            //redirect the loan to the display loan jsp
            request.getRequestDispatcher("/WEB-INF/views/displayloan.jsp")
                    .forward(request, response);

        } else {
            session.setAttribute("message", "Loan doesn't exist");
            response.sendRedirect("/LDS/customer");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

        //request.getRequestDispatcher("/WEB-INF/views/displayloan.jsp").forward(request, response);
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
        processRequest(request, response);
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
