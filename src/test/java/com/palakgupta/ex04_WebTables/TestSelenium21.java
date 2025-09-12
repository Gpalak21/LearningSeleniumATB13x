package com.palakgupta.ex04_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestSelenium21 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));

        //rows and columns
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("no of rows: "+rows.size());
        for(int i =0;i<rows.size();i++){
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for(WebElement c:cols){
                System.out.println(c.getText());
            }

        }
    }
}

