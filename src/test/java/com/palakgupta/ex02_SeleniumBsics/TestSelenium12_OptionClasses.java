package com.palakgupta.ex02_SeleniumBsics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestSelenium12_OptionClasses {
    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();

//       firefoxOptions.addArguments("--headless");
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
