/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.aop;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author 35194
 */
public class HiBeforeMethod implements MethodBeforeAdvice{

    
    private static final Logger log = Logger.getLogger(HiBeforeMethod.class);
            
    @Override
    public void before(Method method, Object[] os, Object o) throws Throwable {
        System.out.println("holas XXXXXXXXXXXXXXXXxx");
            log.debug("HijackBeforeMethod : Before method hijacked!");
    }
    
    
    
}
