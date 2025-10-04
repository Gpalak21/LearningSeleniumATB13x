package com.palakgupta.ex08_OwnPractice;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice_ShadowDom {

    @Test
    public void test_ShadowDom(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/shadowdom");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement button =(WebElement) js.executeScript("return document.querySelector(\"div#shadow-host\").shadowRoot.querySelector(\"button#my-btn\")");
        System.out.println(button.getText());

        driver.quit();
    }
}
