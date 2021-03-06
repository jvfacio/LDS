package com.hxwr.lds.restassured;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoanRestApiTest {
    
   
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
             RestAssured.basePath = "/lds-api";
        }

       /* @BeforeClass
        public static void testUnit1()
        {
        
            response =
                when().
                    get("/getclientbynickname/okok").
                then().
                    contentType(ContentType.JSON).  // check that the content type return from the API is JSON
                extract().response(); // extract the response
       
       //jsonAsString = response.asString();
        }*/
	@Test
	public void testUnit2() {
		
		given().
			
		when().
			get("/client/getclientbynickname/ok").
		then().body("id",equalTo(1))
                        .and().body("name", equalTo("ok"))
                        .and().body("address", equalTo("123 adfadf"))
                        .and().body("lastName",equalTo("fun"))
                        .statusCode(200);
	}
        
        @Test
	public void testUnit3() {
		
	        given().
                        
		when().
			get("/client/getclientbynickname/ok").
		then().statusCode(200);
	}
    
    
        
       /* public void testUnit4() {
                String customer=  response.path("nickName");
                assert(customer.equals("okok"));
        }*/
                
    
        @Test
        public void testUnit5(){
        given().
               
        when().
                 get("/client/getclientbynickname/ok").
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
                    get("/client/getclientbynickname/ ");
                                               
        }
        @Test
        public void testUnit7(){
            expect().
                     statusCode(400).
            when().        
                    get("/client/getclientbynickname//");
                                               
        }
        @Test
        public void testUnit8(){
            
            try{
            
            expect().
                     statusCode(400).
            when().        
                    get("/client/getclientbynickname/?");
            }
            catch(Exception e){
                System.out.println(e);
            }
            }
           
        }
         

