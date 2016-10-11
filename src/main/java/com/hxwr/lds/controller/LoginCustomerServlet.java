/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.CustomerDao;
import com.hxwr.lds.entities.Client;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Training
 */
public class LoginCustomerServlet extends HttpServlet {

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
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
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
        
        HttpSession httpSession = request.getSession();
        
        String fName = request.getParameter("name"),
               lName = request.getParameter("lastName");
        Client client = new CustomerDao().getByName(fName, lName);
        
        if(client != null) {       
            //set confirmation message
            httpSession.setAttribute("message", "Login successful!");
            
            //set client attribute 
            httpSession.setAttribute("client", client);
            
            //set session expiration to 30 minutes
            httpSession.setMaxInactiveInterval(30*60);
            
            //redirect user to customer details page
            response.sendRedirect("/LDS/customer");
            
        } else {
            httpSession.setAttribute("message", "Login credentials were invalid");
            response.sendRedirect("/LDS/customer/login");
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
