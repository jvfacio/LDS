/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.integration.tests.clientTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Training
 */
public class loginClient {
    
    private static WebDriver driver;
         public static void getBrowserRunning(String url){
             System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Downloads\\seleinum files\\chromedriver.exe");
             driver= new ChromeDriver();
             driver.get(url);
         }
         //testing
         public static void testcase1(){
             driver.navigate().to("http://localhost:8080/lds-web-app/customer/login");
             String title=driver.getTitle();
             assert(title.equals("Login"));// checking if the title works fine
             
              WebElement nickName= driver.findElement(By.id("custNickName"));
              nickName.sendKeys("xxx");
             String textBoxName= nickName.getAttribute("value");
             WebElement passWord= driver.findElement(By.id("custPassword"));
             passWord.sendKeys("xxx");
             String textBoxPassword= passWord.getAttribute("value");
             if(!textBoxName.isEmpty()&& !textBoxPassword.isEmpty()){
                 driver.findElement(By.className("btn btn-default"));
             }
             else {
                 
             }
             
            
             
         }
              
    }
