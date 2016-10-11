/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.ids.service.impl.HelloWorld;
import com.hxwr.ids.service.impl.dummy.DummyCRS;
import com.hxwr.lds.CustomerDao;
import com.hxwr.lds.entities.Client;
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
 * @author 35194
 */
public class RegisterCustomerServlet extends HttpServlet {

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
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
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
        
        Client customer = new Client();
        customer.setAddress(request.getParameter("address"));
        customer.setName(request.getParameter("name"));
        customer.setPhoneNumber(request.getParameter("phone"));
        customer.setSalary(request.getParameter("salary"));
        customer.setlastName(request.getParameter("lastName"));
        HttpSession session = request.getSession(true);
        
        try {
            CustomerDao customerDAO = new CustomerDao();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            customerDAO.addCustomerDetails(customer);
            session.setAttribute("message", "Account registered successfully!");
            response.sendRedirect("/LDS/customer/login");
        } catch (Exception e) {
            e.printStackTrace();
            try(PrintWriter out = response.getWriter()) {
                out.println(e);
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
