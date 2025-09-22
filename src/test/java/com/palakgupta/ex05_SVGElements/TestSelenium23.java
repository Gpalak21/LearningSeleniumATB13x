package com.palakgupta.ex05_SVGElements;

import com.palakgupta.ex07_WaitHelpers.TestSelenium28_WaitHelpers;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestSelenium23 {

    @Description("TC#1 - Verify SVG on Flipkart")
    @Owner("Palak Gupta")
    @Test
    public void test_SVG(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("macmini");
        List<WebElement> searchSVG = driver.findElements(By.xpath("//*[name()='svg']"));
        searchSVG.get(0).click();



        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class,'slAVV4')]/a[2]"));

        for(WebElement title: titles){
            System.out.println(title.getText());
        }

        //until next button is visible, for loop
        WebElement nextButton = driver.findElement(By.xpath("//a[normalize-space()='Next']"));
        while (nextButton.isDisplayed()){
            nextButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'slAVV4')]/a[2]")));
            for(WebElement title: titles){
                System.out.println(title.getText());
            }

        }


        driver.quit();
    }
}
