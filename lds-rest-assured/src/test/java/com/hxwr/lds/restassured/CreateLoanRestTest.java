/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxwr.lds.core.entities.Loan;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.expect;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Training
 */
public class CreateLoanRestTest {
    
    Response response;
    String jsonAsString;
    ObjectMapper mapper;
    Loan loan;
    
    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "";
        
    }
    
    @Test
    //Test to check if client is able to enter information and submit successfully
    public void testUnit1() throws JsonProcessingException{
        mapper= new ObjectMapper();
        loan= new Loan("Car","10",16.0,234.0);
        jsonAsString = mapper.writeValueAsString(loan); 
        System.out.println(jsonAsString);
        expect().statusCode(200)
                    .given().contentType("application/json").body(jsonAsString)
                    .when().post("/lds-api/client/1/createLoan");
    }
    
    @Test
    //Test to check if one client can register many loans
    public void testUnit2() throws JsonProcessingException {
           mapper= new ObjectMapper();
           loan=new Loan("Mortgage","10",15.0,233.0);
           jsonAsString = mapper.writeValueAsString(loan); 
           System.out.println(jsonAsString);
           expect().statusCode(200)
                    .given().contentType("application/json").body(jsonAsString)
                    .when().post("/lds-api/client/1/createLoan");
    
    }
}
