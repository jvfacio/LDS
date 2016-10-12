/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.log4j.Logger;

/**
 *
 * @author 35194
 */
public class HelloWorld {
    
    private static final Logger log = Logger.getLogger(HelloWorld.class);

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/yyyy hh:mm:ss");
        
//        log.debug("Spring 3 : Hello ! " + name);
//        log.warn("Spring 3 : Hello ! " + name);
//        log.error("Spring 3 : Hello ! " + name);
//        log.info("Spring 3 : Hello ! " + name);
       
        
        GregorianCalendar gc = new GregorianCalendar();
        Date d = new Date();
        gc.setTime(d);
        log.debug("initial date " + sdf.format(gc.getTime()));
        gc.add(Calendar.MONTH, 1);
        gc.add(Calendar.HOUR, 24);
       
        log.debug("initial date = 1 month " +  sdf.format(gc.getTime()));
        
        
        
        
    }

}
