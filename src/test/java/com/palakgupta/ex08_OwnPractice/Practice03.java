package com.palakgupta.ex08_OwnPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice03 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

        String firstPart = "//table[@id='example']/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart ="]";

        WebElement dropdown = driver.findElement(By.xpath("//div[@id='example_length']//select"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("3");



//        int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
//        int cols = driver.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td")).size();





        while(true){

            WebElement next = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='Next']"));
            String disbaled = next.getAttribute("aria-disabled");
            int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
            int cols = driver.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td")).size();


            for(int i =1 ; i<=rows ; i++){
                for(int j=1 ; j<=cols ; j++){

                    String dynamicPath = firstPart + i + secondPart + j + thirdPart;
                    System.out.println(driver.findElement(By.xpath(dynamicPath)).getText());

                }

            }

            if(disbaled !=null && disbaled.contains("true")){
                break;
            }
            next.click();

        }



        driver.quit();
    }
}
