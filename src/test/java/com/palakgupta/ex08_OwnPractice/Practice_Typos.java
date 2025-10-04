package com.palakgupta.ex08_OwnPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice_Typos {

    @Test
    public void verifyTextContainsValidSetOfTypos() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/typos");

        String[] expectedTexts={
                "Sometimes you'll see a typo, other times you won't.",
                "Sometimes you'll see a typo, other times you won,t."
        };

        for(int i=1;i<=5;i++){
            driver.navigate().refresh();

            Thread.sleep(3000);
            String actualText = driver.findElement(By.xpath("//div[@class='container']/p[2]")).getText();

            boolean match = false;
            for(String exp:expectedTexts){
                if(actualText.contains(exp)){
                    match=true;
                    break;
                }
            }
            Assert.assertTrue(match);

        }


    }
}
