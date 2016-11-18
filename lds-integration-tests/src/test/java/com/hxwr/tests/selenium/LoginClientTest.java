package com.hxwr.tests.selenium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/**
 *
 * @author Training
 */

public class LoginClientTest extends AbstractSeleniumTest {
    
   
   
   
    
    @Given("^the LDS homepage$")
    public void goToHomePage() {
       
        driver.get("http://localhost:8080/lds-web-app/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @When("^I navigate to the login page$")
    public void navigateToLogin() {
        driver.navigate().to("http://localhost:8080/lds-web-app/customer/login");
    }
    @When("^I login with$")
    public void loginWith(DataTable table) {
       for(Map<String,String> row : table.asMaps(String.class, String.class)){
           driver.findElement(By.id("custNickname")).sendKeys(row.get("username"));
           driver.findElement(By.id("custPassword")).sendKeys(row.get("password"));
           driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/button")).click();
           driver.findElement(By.id("navLogoutLink")).click();
           driver.findElement(By.id("navLoginLink")).click();
       }
       
    }
    
    @When("^I login with the values I should get an error$")
    public void loginWithNoValid(DataTable table){
        for(Map<String,String> row : table.asMaps(String.class, String.class)){
           driver.findElement(By.id("custNickname")).sendKeys(row.get("username"));
           driver.findElement(By.id("custPassword")).sendKeys(row.get("password"));
           driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/button")).click();
           WebElement invalidInput = driver.findElement(By.cssSelector("#custPassword:invalid"));
           assertThat(invalidInput.isDisplayed(), is(true));
       }
    }
    
    
    
    @Then("^the page title should be \"([^\"]*)\"$")
    public void validatePageTitle(String title) {
        assert driver.getTitle().equals(title);
    }
    @When("^Close the web browser$")
    public void finalize(){
        driver.close();
    }
}
    
  
        
    
