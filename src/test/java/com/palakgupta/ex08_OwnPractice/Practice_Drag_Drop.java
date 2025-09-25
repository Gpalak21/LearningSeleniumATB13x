package com.palakgupta.ex08_OwnPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Practice_Drag_Drop {

    @Test
            public void DragAndDrop() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");

        WebElement red = driver.findElement(By.className("red"));
        WebElement green = driver.findElement(By.className("green"));
        WebElement blue = driver.findElement(By.className("blue"));
        WebElement target = driver.findElement(By.id("target"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(red, target).build().perform();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.dragAndDrop(green,target).build().perform();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.dragAndDrop(blue,target).build().perform();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }


}
