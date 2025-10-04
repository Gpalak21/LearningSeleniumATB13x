package com.palakgupta.ex08_OwnPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice_FormValidation {

    @Test
    public void FormValidation(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://practice.expandtesting.com/form-validation");

        WebElement name = driver.findElement(By.id("validationCustom01"));
        name.clear();
        name.sendKeys("Palak");

        driver.findElement(By.name("contactnumber")).sendKeys("798-3945132");
        WebElement dateInput = driver.findElement(By.name("pickupdate"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='24/09/2025';", dateInput);
        dateInput.clear();
        dateInput.sendKeys("14/11/2000");
        WebElement dropdown = driver.findElement(By.id("validationCustom04"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("cash on delivery ");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//button[text()=' Register ']")).click();
        String expectedText="Form Confirmation page for Automation Testing Practice";
        String actualText=driver.findElement(By.xpath("//div[@class='container']/h1")).getText();

        Assert.assertEquals(actualText,expectedText);

driver.quit();




    }
}
