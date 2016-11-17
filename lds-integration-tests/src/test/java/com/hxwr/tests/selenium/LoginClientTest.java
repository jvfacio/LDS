package com.hxwr.tests.selenium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 *
 * @author Training
 */
public class LoginClientTest extends AbstractSeleniumTest {
    
    @Given("^the LDS homepage$")
    public void goToHomePage() {
        driver.get("http://localhost:8080/lds-web-app/");
    }
    
    @When("^I navigate to the login page$")
    public void navigateToLogin() {
        driver.navigate().to("http://localhost:8080/lds-web-app/customer/login");
    }
    
    @When("^I login with$")
    public void loginWith(HashMap<String,String> info) {
        driver.findElement(By.id("custNickname")).sendKeys(info.get("username"));
        driver.findElement(By.id("custPassword")).sendKeys(info.get("password"));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/button")).click();
    }
    
    @Then("^the page title should be \"([^\"]*)\"$")
    public void validatePageTitle(String title) {
        assert driver.getTitle().equals(title);
    }
}
    
   /* @Test
    public void testHappyPath(){
        String url="http://localhost:8080/lds-web-app";
        driver.get(url);
        driver.navigate().to("http://localhost:8080/lds-web-app/customer/login");
        String title= driver.getTitle();
        assert(title.equals("LDS - Login"));
        driver.findElement(By.id("custNickname")).sendKeys("ok");
        driver.findElement(By.id("custPassword")).sendKeys("ok");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/button")).click();
        String custTitle=driver.getTitle();
        assert(custTitle.equals("LDS - Customer Details"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.id("navLogoutLink")).click();
        driver.close();
    }
    
    @Test
    public void testNickNamePasswordEmpty(){
        String url="http://localhost:8080/lds-web-app";
        driver.get(url);
        driver.navigate().to("http://localhost:8080/lds-web-app/customer/login");
        String title= driver.getTitle();
        assert(title.equals("LDS - Login"));
        String nickName= driver.findElement(By.id("custNickname")).getAttribute("value");
        String passWord= driver.findElement(By.id("custPassword")).getAttribute("value");
        if(nickName.isEmpty()&& passWord.isEmpty()){
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/button")).click();
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             String titleTest= driver.getTitle();
             assert(titleTest.equals("LDS - Login"));
        }
        driver.close();
        
        
    }
}*/