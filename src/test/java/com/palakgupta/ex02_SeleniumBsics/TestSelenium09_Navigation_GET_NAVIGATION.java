package com.palakgupta.ex02_SeleniumBsics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium09_Navigation_GET_NAVIGATION {
    @Description("Open The URL")
    @Test
    public void test_Selenium01(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");

        driver.navigate().to("https://www.bing.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        driver.quit();
    }
}
