/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.restassured;

import com.hxwr.lds.core.entities.Client;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;

/**
 *
 * @author Training
 */
public class RegisterClientRestTest {
    Response response;
    String jsonAsString;
    ObjectMapper mapper;
    String user;
   
    
    @BeforeClass
    public static void init(){
         RestAssured.baseURI = "http://localhost:8080";
         RestAssured.basePath = "";
         //Set up new test data
        
        System.out.println("hello form init");
    }
    
    
    
    @Test
	public void testUnit1() throws JsonProcessingException {
        mapper = new ObjectMapper();    
        String user= "RestUser"+new Random().nextInt(5000)+1;
	Client client =new Client("Hector","844222112", "Colosio HXWR", "100000","Medina",user, "xxx");
        jsonAsString = mapper.writeValueAsString(client); 
        System.out.println(jsonAsString);
        expect().statusCode(200)
                    .given().contentType("application/json").body(jsonAsString)
                    .when().post("/lds-api/client");
	}
    @Test
        public void testUnit2(){
            System.out.println("Hello from test 2");
        }
}
