package com.hxwr.lds.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoanRestApiTest {
	
	/*******************************************************
	 * Send a GET request to
	 * http://localhost:8080/contact/1
	 * Use Basic authentication
	 ******************************************************/
	
	@Test
	public void retrieveContact() {
//		
//		given().
//			params("grant_type","client_credentials").
//			auth().
//			preemptive().
//			basic("wsuser","t0ps3cr3t").
//		when().
//			get("http://192.168.10.50:8181/contact/1").
//		then().body("id",equalTo(1))
//                        .and().body("firstName", equalTo("Javier"))
//                        .and().body("lastName", equalTo("Mercado"))
//                        .statusCode(200);
	}
        
        @Test
	public void reviewRetrieveContactService() {
            
            System.out.println("test2 from loantestapi");
//		
//		given().
//			params("grant_type","client_credentials").
//			auth().
//			preemptive().
//			basic("wsuser","t0ps3cr3t").
//		when().
//			get("http://localhost:8181/contact/1").
//		then().statusCode(200);
	}
}
