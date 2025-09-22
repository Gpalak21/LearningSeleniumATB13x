package com.palakgupta.ex09_ActionClass;

import com.palakgupta.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestSelenium34_ActionClass extends CommonToAll {

    @Test
    public void test_Action(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");

        WebElement from_inputbox = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input"));
        WebElement to_inputbox = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(from_inputbox).click().sendKeys("BLR").moveToElement(to_inputbox).click().sendKeys("DEL").build().perform();


        driver.quit();

    }
}
