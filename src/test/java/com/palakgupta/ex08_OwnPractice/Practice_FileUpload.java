package com.palakgupta.ex08_OwnPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice_FileUpload {

    @Test
    public void test_fileUpload(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/upload");

        WebElement fileUpload = driver.findElement(By.id("fileInput"));

        String user_dir= System.getProperty("user.dir");
        String path = user_dir+"/src/test/resources/Test Data.xlsx";
        fileUpload.sendKeys(path);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("fileSubmit")).click();

        String expectedText=driver.findElement(By.xpath("//div[@class='container']/h1")).getText();
        Assert.assertEquals("File Uploaded!",expectedText);

        driver.quit();
    }
}
