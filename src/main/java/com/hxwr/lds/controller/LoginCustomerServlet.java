/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.HibernateConfig;
import com.hxwr.lds.entities.Client;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;

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
        Session hibernateSession = HibernateConfig.openSession();
        Query query = hibernateSession.createQuery(
                "from Client where name = :name and lastName = :lastName");
        query.setString("name", request.getParameter("name"));
        query.setString("lastName", request.getParameter("lastName"));
        HttpSession httpSession = request.getSession();
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/LDS/customer");
        Iterator<Client> iter = query.iterate();
        if (iter.hasNext()) {
            Client client = iter.next();
            
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
