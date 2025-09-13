package com.palakgupta.ex07_WaitHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSelenium28_WaitHelpers {

    public static void waitJVM(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void implicitWait(WebDriver driver,int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public static void checkVisibility(WebDriver driver, By locator, int time){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void checkVisibility(WebDriver driver, By locator ){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void checkVisibilityOfAndTextToBePresentInElement(WebDriver driver, int time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Your email, password, IP address or location did not match"));
    }

    public void waitForVisibility(WebDriver driver,int timeInSeconds, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }
}
