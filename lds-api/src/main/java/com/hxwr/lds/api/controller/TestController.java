/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.controller;

import com.hxwr.lds.api.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 35194
 */
@RestController
public class TestController {
    
    @Autowired
    private ITestService testService;
    
    @GetMapping("/test/{name}")
    public String sayHola(@PathVariable("name") String name){
        return testService.sayHola(name);
    }
    
}
