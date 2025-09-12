package com.palakgupta.ex02_SeleniumBsics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium04_WebDriver {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
    }
}
