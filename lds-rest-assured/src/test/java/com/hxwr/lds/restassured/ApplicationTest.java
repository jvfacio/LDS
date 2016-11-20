package com.hxwr.lds.restassured;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.hxwr.lds.core.entities.Client;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.expect;

/**
 * 
 * @author AntonyRmrz
 */

public class ApplicationTest {
    private Client client;
    @Before
    public void Init(){
        
       //Set up new test data
    	client = new Client("Hector","844222112", "Colosio HXWR", 100000,"Medina", "h1", "xxx");
        System.out.println("hello form init");
    }
    @Test
    public void testUnit1(){//Post a contact and retrieve it
        expect().
        statusCode(200).
        when().
                get("http://localhost:8080/lds-api/clients");
        
        System.out.println("hello from test1");
    }
    
    @Test
    public void testUnit2(){
        expect().
        statusCode(200).
        when().
                get("http://localhost:8080/lds-api/client/1");
        
        System.out.println("Hello from test2");
    }

    
}
