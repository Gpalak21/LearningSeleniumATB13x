package com.palakgupta.ex07_WaitHelpers;

import com.palakgupta.utils.CommonToAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium32_Alerts extends CommonToAll {
    @Test
    public void test_alerts(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        new TestSelenium28_WaitHelpers().waitForAlert(driver,3);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Palak");
        alert.accept();
//        alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(result,"You successfully clicked an alert");
        Assert.assertEquals(result,"You entered: Palak");

        closeBrowser(driver);
    }
}
