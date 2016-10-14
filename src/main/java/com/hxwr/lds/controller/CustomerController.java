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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author 35194
 */
@Controller
public class CustomerController{
    
    @Autowired
    ICustomerSrv customerSrv;
    
    @GetMapping("/customer")
    public String customerDetails(@SessionAttribute("client") Client client) {
        return "customer";
    }
    
    @GetMapping("/customer/register")
    public String registerPage() {
        return "register";
    }
    
    @PostMapping("/customer/register")
    public String registerCustomer(
            HttpSession session,
            @ModelAttribute Client client) {
        customerSrv.register(client);
        session.setAttribute("message", "Account successfully created.");
        return "redirect:/customer";
    }

    @GetMapping("/customer/login")
    public String loginPage(ModelMap model) { 
        return "login";
    }
    
    @PostMapping("/customer/login")
    public String submitLogin(
            HttpSession session,
            String nickname, String password) {
        Client client = customerSrv.validateCustomer(nickname, password);
        if (client != null) {
            session.setAttribute("message", "Login successful!");
            session.setAttribute("client", client);
            return "redirect:/customer";
        }
        else {
            session.setAttribute("message", "Login credentials invalid.");
            return "redirect:/customer/login";
        }
    }
    
    @RequestMapping(value = "/customer/logout")
    public String submitLogout(
            ModelMap model, HttpSession session,
            @SessionAttribute Client client
    ) {
        session.setAttribute("client", null);
        return "redirect:/";
    }
}
