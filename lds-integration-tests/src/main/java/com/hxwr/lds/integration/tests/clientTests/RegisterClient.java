/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.integration.tests.clientTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Training
 */
public class RegisterClient {
    static{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Google Drive\\Hexaware\\Training\\SDET\\Selenium\\Files\\chromedriver_win32\\chromedriver.exe");
    }
    public RegisterClient(){
    }
    public RegisterClient(WebDriver driver){
        initialize(driver);
    }
    
    public WebDriver initialize(WebDriver driver){
        return new ChromeDriver();       
    }
    
    public void testCase1(WebDriver driver){
        String url="http://localhost:8080/lds-web-app/";
        driver.get(url);
        driver.findElement(By.id("navRegisterUrl")).click();
        driver.findElement(By.id("nickName")).sendKeys("Antony1234");
        driver.findElement(By.id("c")).sendKeys("123455");
        driver.findElement(By.id("name")).sendKeys("Antony");
        driver.findElement(By.id("lastName")).sendKeys("Ramirez");
        driver.findElement(By.id("address")).sendKeys("ahdiasuhdiuahsiuh");
        driver.findElement(By.id("phoneNumber")).sendKeys("8887778891");
        driver.findElement(By.id("salary")).sendKeys("100000");
        driver.findElement(By.id("client")).submit();
    }
    
    
}

