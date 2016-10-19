/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.controller;

//import static jdk.nashorn.internal.runtime.Debug.id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 35194
 */
@Controller

public class LdsController {

    @RequestMapping(value = "/hello", method  = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }
    
    @RequestMapping(value = "/", method  = RequestMethod.GET)
    public String printHello2(ModelMap model, String id, String param) {
        model.addAttribute("message", "My id is " + id);
        
        return "index";
    }
    
    @GetMapping("/RestClient")
    public String getRestClientExample() {
        return "restClient";
    }
}
