/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

import com.hxwr.lds.entities.Client;
import com.hxwr.lds.service.ICustomerSrv;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 35194
 */
@Controller
public class CustomerController{
    @Autowired
    ICustomerSrv customerSrv;
    
    @RequestMapping(value = "/customer", method  = RequestMethod.GET)
    public String customerDetails() {
        return "customer";
    }

    @RequestMapping(value = "/customer/login", method  = RequestMethod.GET)
    public String loginCustomer(ModelMap model) { 
        return "login";
    }
    
    @RequestMapping(value = "/customer/login", method  = RequestMethod.POST)
    public String submitLogin(
            ModelMap model, HttpSession session,
            String nickname, String password) {
        Client client = customerSrv.validateCustomer(nickname, password);
        if (client != null) {
            model.addAttribute("message", "Login successful!");
            session.setAttribute("client", client);
            return "customer";
        }
        else {
            model.addAttribute("message", "Login credentials invalid.");
            return "login";
        }
    }
}
