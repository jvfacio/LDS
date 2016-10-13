/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.entities.Client;
import com.hxwr.lds.service.ICustomerSrv;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author 35194
 */
@Controller
public class CustomerController{
    
    @RequestMapping(value = "/printhello", method  = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }
    /***
     * This is to display the customer dashboard
     * @param model
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value = "/customer", method  = RequestMethod.GET)
    public String customer(ModelMap model,HttpServletRequest request, HttpServletResponse response){
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        ICustomerSrv custSrv = (ICustomerSrv) context.getBean("customerSrv");
        HttpSession httpSession  = request.getSession();
        Object rawClient = httpSession.getAttribute("client");
        if(rawClient == null || !(rawClient instanceof Client)) {
            return "login";
        }
         else {
            Client client = custSrv.refresh((Client) rawClient);
            httpSession.setAttribute("client", client);
            return "customer";
        }   
        
        
       
    }

        
    
}
