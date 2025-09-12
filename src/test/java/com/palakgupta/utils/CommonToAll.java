package com.palakgupta.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class CommonToAll {

    public WebDriver driver;
    public void openBrowser(WebDriver driver, String url){
        driver.manage().window().maximize();
        driver.get(url);

    }

    public void closeBrowser(WebDriver driver){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void clickOnStartAFreeTrialLink(WebDriver driver){
        driver.findElement(By.linkText("Start a free trial")).click();
    }
}
