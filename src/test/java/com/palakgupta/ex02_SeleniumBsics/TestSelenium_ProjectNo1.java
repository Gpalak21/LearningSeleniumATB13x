package com.palakgupta.ex02_SeleniumBsics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium_ProjectNo1 {

    @Description("TC#1 - Verify that a particular text exists on the Katalon Website")
    @Test
    public void test_verifyTextOnKatalonWebsite(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");

//        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
//        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
//        System.out.println(driver.getPageSource());
        if(driver.getPageSource().contains("CURA Healthcare Services")){
            System.out.println("Test Case Passed!");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Test Case Failed!");
            Assert.fail();
        }

        driver.quit();


    }
}
