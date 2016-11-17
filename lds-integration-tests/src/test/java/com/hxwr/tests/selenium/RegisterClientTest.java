/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.tests.selenium;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Training
 */
public class RegisterClientTest extends AbstractSeleniumTest {
    /***
     * Test case to check the happy path
     * @param driver 
     */
    
    private List<String> nickName;
    private List<String> passWord;
    private List<String> firstName;
    private List<String> lastName;
    private List<String> address;
    private List<String> phoneNumber;
    private List<Integer> salary;
    
    @Given("^the LDS homepage for the loan delivery system$") 
    public void goToHome(){
        driver.get("http://localhost:8080/lds-web-app/");
    }
    @Given("^LDS homepage for the loan delivery system$")
     public void Home(){
        driver.get("http://localhost:8080/lds-web-app/");
    }
    
    @When("^I navigate to the register page$")
    public void navigate(){
        driver.navigate().to("http://localhost:8080/lds-web-app/customer/register");
    }
    @When("^I enter Nickname with$")
    public void enterNickName(List<String> nickName){
        this.nickName=nickName;
        for(String n:nickName){
            n=n+ new Random().nextInt(5000);
        driver.findElement(By.id("nickName")).sendKeys(n);
        }
    }
    @When("^I enter Password with$")
    public void enterPassword(List<String> passWord){
        this.passWord=passWord;
        for(String p:passWord)
        driver.findElement(By.id("pass")).sendKeys(p);
        }
    @When("^I enter First Name with$")
    public void enterFirstName(List<String> firstName){
        this.firstName=firstName;
        for(String f:firstName){
        driver.findElement(By.id("name")).sendKeys(f);
        }
    }
    @When("^I enter last Name with$")
    public void enterLastName(List<String> lastName){
        this.lastName=lastName;
        for(String l:lastName){
            driver.findElement(By.id("lastName")).sendKeys(l);
        }
    }
    @When("^I enter Address with$")
    public void enterAddress(List<String> address){
        this.address=address;
        for(String a:address){
            driver.findElement(By.id("address")).sendKeys(a);
        }
     
    }
    @When("^I enter PhoneNumber with$")
    public void enterPhoneNumber(List<String> phoneNumber){
        this.phoneNumber=phoneNumber;
        for(String ph:phoneNumber){
            driver.findElement(By.id("phoneNumber")).sendKeys(ph);
          }
          
      }
    @When("^I enter Salary with$")
    public void enterSalary(List<Integer> salary){
        this.salary=salary;
        for(Integer sal:salary){
            driver.findElement(By.id("salary")).sendKeys(sal.toString());
          }
      }
    @When("^I click Submit$")
    public void clickSubmit(){
            driver.findElement(By.id("submitUser")).click();
      }
    @Then("^I should be able to view the customer details page$")
    public void assertTitle(){
            String title= driver.getTitle();
            assert(title.equals("LDS - Customer Details"));
      }
    @Then("^I should see Account created successfully$")
    public void checkMessage(){
          String message= driver.findElement(By.id("message")).getText();
          assert(message.equals("Account successfully created."));
         
      }
    @Then("^I should not be able to register successfully$")
    public void unableToRegister(){
          String title=driver.getTitle();
          assert(title.equals("LDS - Register"));
          driver.close();
      }
    }
  