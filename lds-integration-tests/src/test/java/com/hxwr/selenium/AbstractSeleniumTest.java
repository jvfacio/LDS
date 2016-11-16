/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.selenium;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Training
 */
public abstract class AbstractSeleniumTest {
    
    public WebDriver driver;
    
    public WebDriver getDriver() {
        return driver;
    }
    
    @Before
    public void initDriver() {
        
       String temp=((System.getProperty("os.name").contains("Win"))? "C:\\chromedriver.exe":"/bin/chromedriver");
       if(System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver",temp);
       }
        driver = new ChromeDriver();
    }
    
}
