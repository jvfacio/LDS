/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.ids.service.impl;

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
        log.debug("Spring 3 : Hello ! " + name);
        log.warn("Spring 3 : Hello ! " + name);
        log.error("Spring 3 : Hello ! " + name);
        log.info("Spring 3 : Hello ! " + name);
        
    }

}
