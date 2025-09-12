package com.palakgupta.ex05_SVGElements;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium23 {

    @Description("TC#1 - Verify SVG on Flipkart")
    @Owner("Palak Gupta")
    @Test
    public void test_SVG(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("macmini");
        List<WebElement> searchSVG = driver.findElements(By.xpath("//*[name()='svg']"));
        searchSVG.get(0).click();


        driver.quit();
    }
}
