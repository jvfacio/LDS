/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.tests.selenium;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Training
 */
public abstract class AbstractSeleniumTest {
    
    public static WebDriver driver = new ChromeDriver();
    
    public  WebDriver getDriver() {
        return driver;
    }
    
    @Before
    public void initDriver() {
       String temp=((System.getProperty("os.name").contains("Win"))? "C:\\chromedriver.exe":"/usr/bin/chromedriver");
       System.out.println(System.getProperty("webdriver.chrome.driver"));
       if(System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver",temp);
       }
        
    }
    
}
