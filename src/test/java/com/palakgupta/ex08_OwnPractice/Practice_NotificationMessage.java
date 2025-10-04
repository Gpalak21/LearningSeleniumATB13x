package com.palakgupta.ex08_OwnPractice;

import org.assertj.core.api.DurationAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Practice_NotificationMessage {

    @Test
    public void test_NotificationMessageDisplayedAndNotEmpty(){
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/notification-message-rendered");

        driver.findElement(By.linkText("Click here")).click();
        WebElement notificationBox = driver.findElement(By.xpath("//div[@id='flash']"));

        assertThat(notificationBox.isDisplayed()).as("Notification box should be displayed").isTrue();

        assertThat(notificationBox.getText()).as("Notification text should not be empty").isNotBlank();

        driver.quit();


    }

    @Test
    public void test_MessageVariation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/notification-message-rendered");
//        Action unsuccessful, please try again
//        Action successful



        String[] expectedMssg={
                "Action unsuccessful, please try again",
                "Action successful"
        };

        for(int i=1;i<=10;i++){
            Thread.sleep(1000);
            WebElement link = driver.findElement(By.linkText("Click here"));
            (  (JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",link);
            link.click();

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            WebElement mssg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));


            String actualMssg=mssg.getText();
           // String actualMssg=driver.findElement(By.xpath("//div[@id='flash']")).getText();

           boolean match = false;
           for(String exp:expectedMssg){
               if(actualMssg.contains(exp)){
                   match=true;
                   break;
               }
           }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Assert.assertTrue(match,"Message Not Valid: "+actualMssg);

        }
        driver.quit();
    }
}
