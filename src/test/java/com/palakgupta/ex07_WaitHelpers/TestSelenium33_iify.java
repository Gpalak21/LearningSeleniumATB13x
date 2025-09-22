package com.palakgupta.ex07_WaitHelpers;

import com.palakgupta.utils.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TestSelenium33_iify extends CommonToAll {

    @Description("TC#1 - Verify Signup on iffy.com")
    @Test
    public void test_signup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://iffy.com/sign-up");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));

        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("fname");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("lname");
        driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("vacahe9067@obirah.com");

        driver.findElement(By.xpath("//span[text()='Continue']")).click();


        wait.until(ExpectedConditions.urlContains("/verify-email-address"));

        String originalHandle = driver.getWindowHandle();

        ((JavascriptExecutor) driver) .executeScript("window.open('about:blank','_blank');");

        Set<String> handles = driver.getWindowHandles();
        String newHandle="";
        for(String h: handles){
            if(!h.equals(originalHandle)){
                newHandle=h;
                break;
            }
        }

        driver.switchTo().window(newHandle);
        driver.get("https://temp-mail.org/en/");

        String fullText = driver.findElement(By.xpath("//span[@class='inboxSubject subject-title']/a[contains(text(),'verification code')]")).getText();

        String code = fullText.replaceAll("\\D+", "");


        System.out.println("Verification code: " + code);

        driver.switchTo().window(originalHandle);

    }
}
