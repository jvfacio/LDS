/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.selenium;

import java.util.Random;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Training
 */
public class RegisterClientTest extends AbstractSeleniumTest {
    /***
     * Test case to check the happy path
     * @param driver 
     */
    @Test
    public void testCase1() throws InterruptedException{
        String url="http://localhost:8080/lds-web-app/";
        driver.get(url);
        String user="u"+Integer.toString(new Random().nextInt(50000)+1);
        driver.findElement(By.id("navRegisterUrl")).click();
        driver.findElement(By.id("nickName")).sendKeys(user);
        driver.findElement(By.id("pass")).sendKeys("12345");
        driver.findElement(By.id("name")).sendKeys("Antony");
        driver.findElement(By.id("lastName")).sendKeys("Ramirez");
        driver.findElement(By.id("address")).sendKeys("ahdiasuhdiuahsiuh");
        driver.findElement(By.id("phoneNumber")).sendKeys("8887778891");
        driver.findElement(By.id("salary")).sendKeys("100000");
        driver.findElement(By.id("submitUser")).click();
        driver.findElement(By.id("navLogoutLink")).click();
        Thread.sleep(1000);
        driver.close();
    }
    /***
     * Test case to know if the web program accepts negative values 
     * @param driver 
     */
    @Test
    public void testCase2() throws InterruptedException{ 
        String url="http://localhost:8080/lds-web-app/";
        driver.get(url);
        //random user
        String user="un"+Integer.toString(new Random().nextInt(50000)+1);
        driver.findElement(By.id("navRegisterUrl")).click();
        driver.findElement(By.id("nickName")).sendKeys(user);
        // assert(driver.findElement(By.id("nickName")).getText().equals(user));
        driver.findElement(By.id("pass")).sendKeys("12345");
        driver.findElement(By.id("name")).sendKeys("Antony");
        driver.findElement(By.id("lastName")).sendKeys("Ramirez");
        driver.findElement(By.id("address")).sendKeys("ahdiasuhdiuahsiuh");
        driver.findElement(By.id("phoneNumber")).sendKeys("8887778891");
        driver.findElement(By.id("salary")).sendKeys("-100000");
        //assert(driver.findElement(By.id("salary")).getText().equals("100000"));
        driver.findElement(By.id("submitUser")).click();
        Thread.sleep(1000);
        driver.close();
    }
    
    
}

