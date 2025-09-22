package com.palakgupta.ex09_ActionClass;

import com.palakgupta.ex07_WaitHelpers.TestSelenium28_WaitHelpers;
import com.palakgupta.utils.CommonToAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestSelenium36_ActionClass extends CommonToAll {
    @Test
    public void test_Action()  {
        TestSelenium28_WaitHelpers waitHelper = new TestSelenium28_WaitHelpers();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");


        waitHelper.waitForVisibility(driver,5,"//span[@data-cy='closeModal']");
        WebElement modal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));

        modal.click();

        waitHelper.waitJVM(3);

        WebElement from_city = driver.findElement(By.id("fromCity"));
       WebElement to_city=driver.findElement(By.id("toCity"));

       Actions actions = new Actions(driver);
       actions.moveToElement(from_city).click().sendKeys("IXC").build().perform();

        waitHelper.waitJVM(3);

        List<WebElement> cities = driver.findElements(By.xpath("//li[contains(@id,'react-autowhatever')]//p"));

        try {
            for(WebElement city :cities){
                if(city.getText().contains("Chandigarh")){
                    city.click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        waitHelper.waitJVM(5);
        closeBrowser(driver);




        driver.quit();

    }
}
