package com.palakgupta.ex03_Selenium_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium17_Project_Locators {
    @Description("TC#1 - Verify that with invalid login , error message is displaying")
    @Owner("Palak Gupta")
    @Severity(SeverityLevel.BLOCKER)
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

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
