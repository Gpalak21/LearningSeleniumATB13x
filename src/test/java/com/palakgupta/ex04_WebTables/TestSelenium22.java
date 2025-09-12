package com.palakgupta.ex04_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium22 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]/a")).click();



        String firstPart="//div[@class='oxd-table-body']/div[@class='oxd-table-card'][";
        String secondPart ="]//div[@class='oxd-table-cell oxd-padding-cell'][";
        String thirdPart="]";

        int rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card']")).size();
        int cols = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[@class='oxd-table-card'][1]//div[@class='oxd-table-cell oxd-padding-cell']")).size();

        for(int i = 2;i<=rows;i++){
            for(int j=2;j<=cols;j++){
                String dynamicPath = firstPart+i+secondPart+j+thirdPart;
                String getData = driver.findElement(By.xpath(dynamicPath)).getText();
                System.out.println(getData);
            }
        }



//        driver.quit();
    }
}
