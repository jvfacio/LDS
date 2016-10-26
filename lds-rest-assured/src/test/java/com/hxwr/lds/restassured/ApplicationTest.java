package com.hxwr.lds.restassured;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.hxwr.lds.core.entities.Client;
import com.hxwr.lds.core.service.ICustomerSrv;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.expect;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

/**
 * 
 * @author AntonyRmrz
 */

public class ApplicationTest {
    private Client client;
    @Before
    public void Init(){
        
       //Set up new test data
    	client = new Client("Hector","844222112", "Colosio HXWR", "100000","Medina", "h1", "xxx");
        System.out.println("hello form init");
    }
    @Test
    public void testUnit1(){//Post a contact and retrieve it
        expect().
        statusCode(200).
        when().
                get("http://localhost:8081/lds-api/rest/clients");
        
        System.out.println("hello from test1");
    }
    
    @Test
    public void testUnit2(){
        expect().
        statusCode(200).
        when().
                get("http://localhost:8081/lds-api/rest/client/1");
        
        System.out.println("Hello from test2");
    }
    @Test
    public void testUnit3(){
        expect().
        statusCode(200).
        when().
                get("http://localhost:8081/lds-api/rest/client/antonyrmrz");
        
        System.out.println("Hello from test3");
    }
    
}