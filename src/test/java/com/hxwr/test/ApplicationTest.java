/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hxwr.test;


import com.hxwr.lds.entities.Client;
import com.hxwr.lds.service.ICustomerSrv;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import javax.ws.rs.core.MediaType;
/**
 * 
 * @author AntonyRmrz
 */
public class ApplicationTest {
    private Client client;
    private ICustomerSrv custSrv;
    @Before
    public void Init(){
        
       //Set up new test data
    	client = new Client("Hector","844222112", "Colosio HXWR", "100000","Medina", "h1", "xxx");
        
        
        System.out.println("hello form init");
    }
    @Test
    public void testUnit1(){//Post a contact and retrieve it
        System.out.println("hello from test1");
    }
    
    @Test
    public void testUnit2(){
    }
}
