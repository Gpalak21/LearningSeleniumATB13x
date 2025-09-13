package com.palakgupta.ex05_SVGElements;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium25 {
    @Owner("Palak")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that with valid email, pass, appointment page is loaded")
    @Test
    public void test_valid_email_pass_appointment(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Make Appointment']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement h2 = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        Assert.assertEquals(h2.getText(),"Make Appointment");
        Assert.assertTrue(h2.isDisplayed());

        driver.quit();
    }

}
