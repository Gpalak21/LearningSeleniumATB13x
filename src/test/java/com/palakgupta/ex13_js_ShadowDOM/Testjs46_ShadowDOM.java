package com.palakgupta.ex13_js_ShadowDOM;

import com.palakgupta.ex07_WaitHelpers.TestSelenium28_WaitHelpers;
import com.palakgupta.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testjs46_ShadowDOM extends CommonToAll {

    @Test
    public void test_js(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page");

        TestSelenium28_WaitHelpers wait = new TestSelenium28_WaitHelpers();

        wait.waitJVM(3000);

//        driver.findElement(By.id("pizza")).sendKeys("cheesePizza");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement pizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"#pizza\");");
        pizza.sendKeys("cheesPizza");

        closeBrowser(driver);
    }

}
