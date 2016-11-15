/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds.integration.tests;
import com.hxwr.lds.integration.tests.clientTests.*;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	
/**
 *
 * @author Training
 */
public class SeleniumTestRunner {
    
    public static void main(String[] args){
        WebDriver driver = null;
        RegisterClient a = new RegisterClient();
        driver = a.initialize(driver);
        
        a.testCase1(driver);
        a.testCase2(driver);
        
        
        
    }
   
        
   
}
