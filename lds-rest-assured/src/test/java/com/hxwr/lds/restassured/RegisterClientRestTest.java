/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.restassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.testng.annotations.Test;


/**
 *
 * @author Training
 */
public class RegisterClientRestTest {
    private static Response response;
    private static String jsonAsString;
    @BeforeClass
    public void init(){
         RestAssured.baseURI = "http://localhost:8080";
         RestAssured.basePath = "/lds-api/client";
    }
    
    
    
    @Test
	public void testUnit1() {
		
		given().
			
		when().
			get("/getclientbynickname/ok").
		then().body("id",equalTo(1))
                        .and().body("name", equalTo("ddd"))
                        .and().body("phoneNumber", equalTo("5555"))
                        .and().body("lastName",equalTo("dddd"))
                        .statusCode(200);
	}
    @Test
        public void testUnit2(){
            System.out.println("Hello from test 2");
        }
}
