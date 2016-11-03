/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.service.impl;

import com.hxwr.lds.api.service.ITestService;
import com.hxwr.lds.api.service.ITestServiceRamirin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 35194
 */
@Component
public class TestServiceImpl implements ITestService {
    
    @Autowired
    public ITestServiceRamirin testServiceRamirin;

    public ITestServiceRamirin getTestServiceRamirin() {
        return testServiceRamirin;
    }

    public void setTestServiceRamirin(ITestServiceRamirin testServiceRamirin) {
        this.testServiceRamirin = testServiceRamirin;
    }

    
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestServiceImpl() {
    }

    public TestServiceImpl(String name) {
        this.name = name;
    }
    

    @Override
    public String sayHello(String name) {
        
        return "Hola " + name + "  desde clase servicio implementado metodo say Hello ";
    }

    @Override
    public String sayHola(String name) {
        String str = testServiceRamirin.add(0, 0);
        return "Hola " + name + "  desde clase servicio implementado metodo sayHola \n" + str ;
    }
    
    public String print(){
        
        return "Print the name "+ name; 
    }
    
}
