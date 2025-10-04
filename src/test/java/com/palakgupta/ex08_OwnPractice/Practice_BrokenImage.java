package com.palakgupta.ex08_OwnPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice_BrokenImage {

    @Test
    public void test_BrokenImageUsingNaturalWidth(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/broken-images");

        String imgxpath="//img[@alt='Image";
        String imgXpath2=" ";
        String imgXpath3="']";

        int brokenCount=0;
        int correctCount=0;


        for(int i=1;i<=3;i++){

            String dymanicImagePath = imgxpath + imgXpath2+i + imgXpath3;
//            System.out.println(dymanicImagePath);
            WebElement image = driver.findElement(By.xpath(dymanicImagePath));

            Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].complete && arguments[0].naturalWidth>0",image);
            if(imageLoaded){
                System.out.println("Image is displayed correctly");
                correctCount++;
            }
            else {
                System.out.println("Image is broken");
                brokenCount++;
            }



    }
        System.out.println("No. of broken images are: "+brokenCount);
        System.out.println("No. of Correct Images are: "+correctCount);

        driver.quit();

    }
}
