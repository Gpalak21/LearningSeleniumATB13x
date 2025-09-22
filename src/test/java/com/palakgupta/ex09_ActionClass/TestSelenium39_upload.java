package com.palakgupta.ex09_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium39_upload {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement file = driver.findElement(By.id("fileToUpload"));

        String user_dir = System.getProperty("user.dir");
       //  /Users/palakgupta/IdeaProjects/LearningSeleniumATB13x
        String path = user_dir+ "/src/test/java/com/palakgupta/ex09_ActionClass/testdata.txt";
        file.sendKeys(path);


    }
}
