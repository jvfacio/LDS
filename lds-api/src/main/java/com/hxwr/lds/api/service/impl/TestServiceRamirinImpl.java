/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.api.service.impl;

import com.hxwr.lds.api.service.ITestServiceRamirin;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramirin
 */
@Service
public class TestServiceRamirinImpl implements ITestServiceRamirin{
    
    @Override
    public String add(int a, int b) {
  
        
    return "the addition is --> " +(a+b) ;
    
    }
    
}
