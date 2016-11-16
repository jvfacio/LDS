package com.hxwr.selenium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.hxwr.selenium.AbstractSeleniumTest;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Training
 */
public class LoginClientTest extends AbstractSeleniumTest {
    
    @Test
    public void testHappyPath(){
        String url="http://localhost:8080/lds-web-app";
        driver.get(url);
        driver.navigate().to("http://http://localhost:8080/lds-web-app/customer/login");
        String title= driver.getTitle();
        assert(title.equals("Login"));
        driver.findElement(By.id("custNickname")).sendKeys("ok");
        driver.findElement(By.id("custPassword")).sendKeys("ok");
        driver.findElement(By.className("btn btn-default")).click();
        String custTitle=driver.getTitle();
        assert(custTitle.equals("Customer Details"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.id("navLogoutLink")).click();
        driver.close();
    }
    
    @Test
    public void testNickNamePasswordEmpty(){
        String url="http://localhost:8080/lds-web-app";
        driver.get(url);
        driver.navigate().to("http://http://localhost:8080/lds-web-app/customer/login");
        String title= driver.getTitle();
        assert(title.equals("Login"));
        String nickName= driver.findElement(By.id("custNickname")).getAttribute("value");
        String passWord= driver.findElement(By.id("custPassword")).getAttribute("value");
        if(nickName.isEmpty()&& passWord.isEmpty()){
             driver.findElement(By.className("btn btn-default")).click();
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             String titleTest= driver.getTitle();
             assert(titleTest.equals("Login"));
        }
        driver.close();
        
        
    }
}