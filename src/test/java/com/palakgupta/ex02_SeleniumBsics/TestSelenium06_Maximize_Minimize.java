package com.palakgupta.ex02_SeleniumBsics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium06_Maximize_Minimize
{
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        driver.quit();
    }
}
