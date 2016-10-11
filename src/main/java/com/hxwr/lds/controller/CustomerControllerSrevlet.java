/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.dao.impl.CustomerDao;
import com.hxwr.lds.entities.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 35194
 */
public class CustomerControllerSrevlet extends HttpServlet {

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

//         String userName = request.getParameter("userName");
//        String password = request.getParameter("password1");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String city = request.getParameter("city");
        Client customer = new Client();
//        customer.setAddress(request.getParameter("address"));
//        customer.setName(request.getParameter("name"));
//        customer.setPhoneNumber(request.getParameter("phone"));
//        customer.setSalary(request.getParameter("salary"));
//        customer.setlastName(request.getParameter("lastName"));
        HttpSession session = request.getSession(true);
        try {
            CustomerDao customerDAO = new CustomerDao();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            customerDAO.addCustomerDetails(customer);
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("registerloan.jsp");
            rd.forward(request, response);
            //response.sendRedirect("Success");
        } catch (Exception e) {

            e.printStackTrace();
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
