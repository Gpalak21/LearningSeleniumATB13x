package com.palakgupta.ex06_SeleniumWaits;

import com.palakgupta.ex07_WaitHelpers.TestSelenium28_WaitHelpers;
import com.palakgupta.utils.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium29_MMT extends CommonToAll {
    @Description("Verify MMT opens with Modal")
    @Test
    public void testCloseModal(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        System.out.println(driver.getTitle());

        new TestSelenium28_WaitHelpers().waitForVisibility(driver,5,"//span[@data-cy=\"closeModal\"]");

        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

        closeBrowser(driver);
    }
}
