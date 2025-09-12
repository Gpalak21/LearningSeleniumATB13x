package com.palakgupta.ex02_SeleniumBsics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium10_NOHTTP {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        //driver.get("bing.com");//HTTP is important
        driver.quit();
    }
}
