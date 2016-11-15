/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.webapp.controller;

import com.hxwr.lds.webapp.session.ClientSession;
import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.service.ICustomerSrv;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author 35194
 */
@Controller
public class CustomerController extends AbstractSessionAwareController {
    
    @Autowired
    ICustomerSrv customerSrv;
    
    @RequestMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("resultado", "Result from Session");
		return "index";
	}
    
    @GetMapping("/customer")
    public String customerDetails(@ModelAttribute ClientSession session) {
        if (session.isLoggedIn()) {
            return "customer";
        }
        else {
            return "redirect:/login";
        }
    }
    
    @GetMapping("/customer/register")
    public String registerPage(Model model) {
        model.addAttribute("client", new Client());
        return "register";
    }
    
    @PostMapping("/customer/register")
    public String registerCustomer(
            @ModelAttribute Client client,
            BindingResult result,
            @ModelAttribute ClientSession session,
            RedirectAttributes redirect
    ) throws IOException
    {
        if (result.hasErrors()) {
            redirect.addFlashAttribute("message", "Invalid registration information");
            return "redirect:/customer/register";
        }
        else {
            session.setClient(client);
            customerSrv.register(client);
            redirect.addFlashAttribute("message", "Account successfully created.");
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/login")
    public String loginPage(ModelMap model) { 
        return "login";
    }
    
    @PostMapping("/customer/login")
    public String submitLogin(
            RedirectAttributes redirect,
            @ModelAttribute ClientSession session,
            String nickname, String password)
        throws IOException 
    {
        Client client = customerSrv.validateCustomer(nickname, password);
        if (client != null) {
            session.setClient(client);
            redirect.addFlashAttribute("message", "Login successful!");
            return "redirect:/customer";
        }
        else {
            redirect.addFlashAttribute("message", "Login credentials invalid.");
            return "redirect:/customer/login";
        }
    }
    
    @RequestMapping(value = "/customer/logout")
    public String submitLogout(@ModelAttribute ClientSession session) {
        session.setClient(null);
        return "redirect:/";
    }
}
