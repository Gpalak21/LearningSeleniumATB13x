package com.palakgupta.ex07_WaitHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium30 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");

        driver.findElement(By.xpath("//input[@id='sex-0']")).click();


    }
}
