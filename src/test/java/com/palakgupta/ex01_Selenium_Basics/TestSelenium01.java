package com.palakgupta.ex01_Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium01 {

    @Test
    public void test_code(){
        Assert.assertEquals("palak","Palak");
    }

    @Test
    public void test_OpenTheTestingAcademy(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://thetestingacademy.com/");
    }
}
