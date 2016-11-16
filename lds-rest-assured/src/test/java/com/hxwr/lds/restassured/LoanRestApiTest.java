package com.hxwr.lds.restassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoanRestApiTest {
	private static Response response;
        private static String jsonAsString;
	/*******************************************************
	 * Send a GET request to
	 * http://localhost:8080/contact/1
	 * Use Basic authentication
	 ******************************************************/
	
        @BeforeClass
        public static void setupURL()
        {
        // here we setup the default URL and API base path to use throughout the tests
             RestAssured.baseURI = "http://localhost:8080";
             RestAssured.basePath = "/lds-api/client";
        }

        @BeforeClass
        public static void testUnit1()
        {
        
            response =
                when().
                    get("/getclientbynickname/xxx").
                then().
                    contentType(ContentType.JSON).  // check that the content type return from the API is JSON
                extract().response(); // extract the response
       
       //jsonAsString = response.asString();
        }
	@Test
	public void testUnit2() {
		
		given().
			
		when().
			get("/getclientbynickname/xxx").
		then().body("id",equalTo(1))
                        .and().body("firstName", equalTo("xxx"))
                        .and().body("lastName", equalTo("xxx"))
                        .statusCode(200);
	}
        
        @Test
	public void testUnit3() {
		
	        given().
                        
		when().
			get("/getclientbynickname/xxx").
		then().statusCode(200);
	}
    
    
        @Test
        public void testUnit4() {
                String customer=  response.path("nickName");
                assert(customer.equals("xxx"));
        }
                
    
        @Test
        public void testUnit5(){
        given().
               
        when().
                 get("/getclientbynickname/xxx").
        then().
                body(containsString("name")).
                body(containsString("lastName")).
                body(containsString("nickName")).
                statusCode(200);
         }
    
        @Test
        public void testUnit6(){
            expect().
                     statusCode(400).
            when().        
                    get("/getclientbynickname/ ");
                                               
        }
        @Test
        public void testUnit7(){
            expect().
                     statusCode(400).
            when().        
                    get("/getclientbynickname//");
                                               
        }
        @Test
        public void testUnit8(){
            expect().
                     statusCode(400).
            when().        
                    get("/getclientbynickname/?");
                                               
        }
         
}
