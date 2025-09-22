package com.palakgupta.ex09_ActionClass;

import com.palakgupta.ex07_WaitHelpers.TestSelenium28_WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium40_BrowserStack_Upload {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        TestSelenium28_WaitHelpers waitHelpers = new TestSelenium28_WaitHelpers();

        driver.get("https://www.browserstack.com/users/sign_in");



        WebElement username = driver.findElement(By.id("user_email_login"));
        username.sendKeys("lnn76@1secmail.website");

        waitHelpers.waitJVM(2000);

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("lnn76@1secmail.website");

       waitHelpers.waitJVM(2000);

        WebElement user_submit = driver.findElement(By.id("user_submit"));
        user_submit.click();


    }
}
