package com.palakgupta.ex08_OwnPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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

        driver.findElement(By.name("contactnumber")).sendKeys("7983945132");
        WebElement dateInput = driver.findElement(By.name("pickupdate"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='24/09/2025';", dateInput);
        WebElement dropdown = driver.findElement(By.id("validationCustom04"));



        Select select = new Select(dropdown);
        select.selectByVisibleText("card");


    }
}
