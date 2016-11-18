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
import java.text.DecimalFormat;
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
public class CustomerController {
    
    @Autowired
    ICustomerSrv customerSrv;
    
    @Autowired
    ClientSession clientSession;
    
    @RequestMapping("/")
	public String showIndex(Model model) {
		System.out.println("Java Version: " + System.getProperty("java.version"));
                System.out.println(System.getProperties());
		return "index";
	}
    
    @GetMapping("/customer")
    public String customerDetails(Model model) {
        if (clientSession.isLoggedIn()) {
            DecimalFormat decimals = new DecimalFormat("0.00");
            DecimalFormat percentages = new DecimalFormat("0.##");
            model.addAttribute("decimals", decimals);
            model.addAttribute("percentages", percentages);
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
            RedirectAttributes redirect
    ) throws IOException
    {
        if (result.hasErrors()) {
            redirect.addFlashAttribute("message", "Invalid registration information");
            return "redirect:/customer/register";
        }
        else {
            Client registeredClient = customerSrv.register(client);
            if(registeredClient == null) {
                redirect.addFlashAttribute("message", "Unable to register.");
                return "redirect:/customer/register";
            }
            else {
                clientSession.setClient(registeredClient);
                redirect.addFlashAttribute("message", "Account successfully created.");
                return "redirect:/customer";
            }
        }
    }

    @GetMapping("/customer/login")
    public String loginPage(ModelMap model) { 
        return "login";
    }
    
    @PostMapping("/customer/login")
    public String submitLogin(
            RedirectAttributes redirect,
            String nickname, String password)
        throws IOException 
    {
        Client client = customerSrv.validateCustomer(nickname, password);
        if (client != null) {
            clientSession.setClient(client);
            redirect.addFlashAttribute("message", "Login successful!");
            return "redirect:/customer";
        }
        else {
            redirect.addFlashAttribute("message", "Login credentials invalid.");
            return "redirect:/customer/login";
        }
    }
    
    @RequestMapping(value = "/customer/logout")
    public String submitLogout() {
        clientSession.setClient(null);
        return "redirect:/";
    }
}
