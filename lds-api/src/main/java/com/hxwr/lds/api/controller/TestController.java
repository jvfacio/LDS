/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.controller;

import com.hxwr.lds.api.service.ITestService;
import com.hxwr.lds.api.service.ITestServiceRamirin;
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

    public ITestService getTestService() {
        return testService;
    }

    public void setTestService(ITestService testService) {
        this.testService = testService;
    }
    
    
     @Autowired
    private ITestServiceRamirin testServiceRamirin;
    
    @GetMapping("/test/{name}")
    public String xxxxzyyasosdfhk(@PathVariable("name") String name){
        
        return testService.sayHola(name);
    }
    
    @GetMapping("/test/ramirin/{number1}/{number2}")
    public String sayHola2(@PathVariable("number1") int number1,@PathVariable("number2") int number2 ){
        return testServiceRamirin.add(number1,number2);
    }
}
