package com.palakgupta.ex04_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium20 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        String firstPart = "//table[@id=\"customers\"]/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";

        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        System.out.println("number of rows are: "+row);

        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
        System.out.println("number of cols are: "+col);

        for(int i =2 ; i<=row;i++)
        {
            for(int j =1;j<=col;j++){
                String dynamicPath= firstPart+i+secondPart+j+thirdPart;
//                System.out.println(dynamicPath);
                String data = driver.findElement(By.xpath(dynamicPath)).getText();
                System.out.println(data);
                if(data.contains("Helen Bennett")){
                    String country_Path = dynamicPath+"/following-sibling::td";
                    String countryText = driver.findElement(By.xpath(country_Path)).getText();
                    System.out.println("Helen Bennett is in: "+countryText);
                }
            }
        }
        driver.quit();
    }


}
