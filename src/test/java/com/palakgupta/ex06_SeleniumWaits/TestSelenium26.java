package com.palakgupta.ex06_SeleniumWaits;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestSelenium26 {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://app.vwo.com/#/login");
    }
}
