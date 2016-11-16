/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.integration.tests.clientTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Training
 */
public class loginClient {
    
    private static WebDriver driver;
         public static void getBrowserRunning(String url){
             System.setProperty("webdriver.chrome.driver","C:\\Users\\Training\\Downloads\\seleinum files\\chromedriver");
             driver= new ChromeDriver();
             driver.get(url);
         }
         
    
}
