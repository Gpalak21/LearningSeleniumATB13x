package com.palakgupta.ex12_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium45 {

    @Test
    public void test_js(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js =  (JavascriptExecutor)driver;
        js.executeScript("window.location = 'https://www.google.com/?zx=1758767618025&no_sw_cr=1'");

        driver.get("https://selectorshub.com/");

        WebElement to_scroll = driver.findElement(By.xpath("//div[@data-id='dbe2ab9']//span[text()='Try Now']"));

        js.executeScript("window.scrollBy(0,500);");
        js.executeScript("window.scrollBy(0,500);");

    }
}
