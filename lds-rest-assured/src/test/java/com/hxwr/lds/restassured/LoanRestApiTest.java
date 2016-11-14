package com.hxwr.lds.restassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoanRestApiTest {
	
	/*******************************************************
	 * Send a GET request to
	 * http://localhost:8080/contact/1
	 * Use Basic authentication
	 ******************************************************/
	
	/*@Test
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
		
		given().
			params("grant_type","client_credentials").
			auth().
			preemptive().
			basic("wsuser","t0ps3cr3t").
		when().
			get("http://localhost:8181/contact/1").
		then().statusCode(200);
	}*/
    /*@BeforeTest
    public void initPath(){
        RestAssured.rootPath="http://localhost:8080/LDS-web-app/rest";//"http://localhost:8080/LDS/rest/clients"
    }
    
    @Test
    public void getClientByIdTest() {
        given().
                pathParam("id",1).
        when().
                get("http://127.0.0.1:8080/lds-api/client/{id}").
        then().
                assertThat().
                body("name",equalTo("xxx")).
                and().
                body("phoneNumber",equalTo("123")).
                and().
                contentType("application/json").
                and().
                statusCode(200);
                
    }
    @Test
    public void getClient(int id){
        given().
                contentType("application/json").
        when().
                 get("http://localhost:8080/LDS-web-app/rest/client/{id}").
        then().
                assertThat().
                body(containsString("id")).
                body(containsString("name")).
                body(containsString("address")).
                body(containsString("phoneNumber")).
                body(containsString("salary")).
                body(containsString("lastNmae")).
                body(containsString("nickName")).
                
                statusCode(200);
    }
    
    @Test 
    public void getClientByNickNameTest(){
        given().
                pathParam("nickName","xxx").
        when().
                get("http://127.0.0.1:8080/lds-api/client/getclientbynickname/{nickName}").
        then().
                assertThat().
                body("name",equalTo("xxx")).
                and().
                body("phoneNumber",equalTo("123")).
                and().
                contentType("application/json").
                and().
                statusCode(200);
                
    }
*/
         
}
