/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.service.impl;

import com.hxwr.lds.api.service.ITestService;

/**
 *
 * @author 35194
 */
public class TestServiceImpl implements ITestService {

    @Override
    public String sayHello(String name) {
        
        return "Hola " + name + "  desde clase servicio implementado metodo say Hello ";
    }

    @Override
    public String sayHola(String name) {
        return "Hola " + name + "  desde clase servicio implementado metodo sayHola ";
    }
    
}
