/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.tests.selenium;

import static com.hxwr.tests.selenium.AbstractSeleniumTest.driver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Training
 */
public class CreateLoanTest extends AbstractSeleniumTest{
   
    
    @When("^I login with loan user$")
    public void loginWith(DataTable table) {
       for(Map<String,String> row : table.asMaps(String.class, String.class)){
           driver.findElement(By.id("custNickname")).sendKeys(row.get("username"));
           driver.findElement(By.id("custPassword")).sendKeys(row.get("password"));
           driver.findElement(By.xpath("/html/body/div[2]/div/div/div/form/button")).click();
       }
    }
    @Given("^the LDS Customer page And I click the Create Loan button$")
    public void goToLoan(){
        driver.findElement(By.id("navCreateLoanLink")).click();
    }
    
    @Then("^I select Type \"([^\"]*)\" and verify it$")
    public void selectTypeLoan(String type){
       Select dropdown = new Select(driver.findElement(By.id("loanTypeInput")));
       dropdown.selectByVisibleText(type);
    }
    
    @Then("^I select Loan Period (\\d+) years and verify it$")
    public void selectPeriodLoan(int period){
        String xpath_s = null;
        switch(period){
            case 10:
                xpath_s="/html/body/div[2]/div/div/div[1]/form/div[2]/input[1]";
                break;
            case 15:
                xpath_s="/html/body/div[2]/div/div/div[1]/form/div[2]/input[2]";
                break;
            case 20:
                xpath_s="/html/body/div[2]/div/div/div[1]/form/div[2]/input[3]";
                break;
        }
        driver.findElement(By.xpath(xpath_s)).click();
    }
    
    @Then("^I enter The porcentage of interest (.+)$")
    public void selectPorcentageLoan(double porcentage){
         driver.findElement(By.id("loanInterestInput")).sendKeys(Double.toString(porcentage));
         assert driver.findElement(By.id("loanInterestInput")).getAttribute("value").equals(Double.toString(porcentage));
    }  
    
    @Then("^I enter the total amount (\\d+)$")
    public void selectTotalAmount(int amount){
        driver.findElement(By.id("loanAmountInput")).sendKeys(Integer.toString(amount));
        assert  driver.findElement(By.id("loanAmountInput")).getAttribute("value").equals(Integer.toString(amount));
    }
    
    @Then("^I click submit button on the loan page$")
    public void submitClickLoan() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/form/button")).click(); 
        Thread.sleep(10000);
    }
    
    
    
}
