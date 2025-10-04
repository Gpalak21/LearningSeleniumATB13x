package com.palakgupta.ex08_OwnPractice;

import com.palakgupta.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practice_ChallengingDOM extends CommonToAll {

    @Test
    public void test_locators(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/challenging-dom");

        driver.findElement(By.xpath("(//div[@class='large-2 columns'])[1]/a[1]")).click();

        closeBrowser(driver);
    }

    @Test
    public void test_DynamicTable(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/challenging-dom");

        String firstPart="//table[@class='table table-bordered']/tbody/tr[";
        String secondPart ="]/td[";
        String thirdPart ="]";

        int rows=driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr")).size();
        int cols = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td")).size();
        System.out.println(rows);
        System.out.println(cols);

        for(int i =1;i<=rows;i++){
            for(int j=1;j<cols;j++){
                String dynamicPath=firstPart+i+secondPart+j+thirdPart;
//                System.out.println(dynamicPath);
                String data = driver.findElement(By.xpath(dynamicPath)).getText();
                System.out.println(data);
            }
        }
        closeBrowser(driver);
    }
}
