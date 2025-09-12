package com.palakgupta.ex02_SeleniumBsics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class TestSelenium07_Assertions_TestNG {


        @Test
        public void test_selenium_assertion(){
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.google.com/");

            //TestNG
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");

            //AssertJ
            assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");

            driver.quit();
        }

}
