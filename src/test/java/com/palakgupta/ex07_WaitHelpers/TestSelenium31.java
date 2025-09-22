package com.palakgupta.ex07_WaitHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSelenium31 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
//        select.selectByVisibleText("Option 2");
        select.selectByIndex(1);

//        driver.quit();

    }
}
