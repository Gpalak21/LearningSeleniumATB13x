package com.palakgupta.ex09_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSelenium38_Drag_Drop {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);

        WebElement column_a = driver.findElement(By.id("column-a"));
        WebElement column_b = driver.findElement(By.id("column-b"));

//       actions.dragAndDrop(column_a,column_b).build().perform();

        actions.clickAndHold(column_a)
                .moveToElement(column_b)
                .release()
                .build()
                .perform();


    }
}
