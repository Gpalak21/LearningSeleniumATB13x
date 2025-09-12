package com.palakgupta.ex03_Selenium_Locators;

import com.palakgupta.utils.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium18_Project_Locators2 extends CommonToAll {
    @Description("TC#1 - Verify error message is coming while signing up with invalid email")
    @Owner("Palak Gupta")
    @Test
    public void test_invalid_signup_email(){
        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://app.vwo.com/");


        clickOnStartAFreeTrialLink(driver);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));
        driver.findElement(By.name("email")).sendKeys("abc");
        driver.findElement(By.name("gdpr_consent_checkbox")).click();
        driver.findElement(By.tagName("button")).click();
        WebElement error_msg = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_msg.getText(),"The email address you entered is incorrect.");



       closeBrowser(driver);
    }
}
