package com.palakgupta.ex06_SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium27 {

    @Test
    public void test_vwo_login_invalid(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();

        WebElement email_input_box = driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("Demo_name@app.com");

        WebElement password_input_box = driver.findElement(By.name("password"));
        password_input_box.sendKeys("1234");

        WebElement submit_button = driver.findElement(By.id("js-login-btn"));
        submit_button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));

        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_message.getText());

        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
