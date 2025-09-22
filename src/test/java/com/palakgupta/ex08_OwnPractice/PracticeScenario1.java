package com.palakgupta.ex08_OwnPractice;

import com.palakgupta.ex07_WaitHelpers.TestSelenium28_WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeScenario1 extends TestSelenium28_WaitHelpers{

    @Description("Get the value of CPU load for Chrome and compare it")
    @Test
    public static void test_WebTables_Data(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/dynamic-table");

       //TestSelenium28_WaitHelpers.waitForVisibility(driver,3,"//table[@class='table table-striped']");

       String firstPart="//table[@class='table table-striped']/tbody/tr[";
       String secondPart="]/td[";
       String thirdPart ="]";
       String chromeCPUIntable =  null;

       int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
       int cols=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr[1]/td")).size();

       for(int i=1;i<=rows;i++)
       {
           String firstCellPath = firstPart+i+secondPart+1+thirdPart;
           String firstCellValue = driver.findElement(By.xpath(firstCellPath)).getText();

           if(!firstCellValue.equalsIgnoreCase("Chrome"))
           {
               continue;
           }

               for(int j=2;j<=cols;j++)
               {
                   String dynamicPath = firstPart+i+secondPart+j+thirdPart;
                   String data = driver.findElement(By.xpath(dynamicPath)).getText();

                   String headerPath = "//table[@class='table table-striped']/thead/tr/th["+j+"]";
                   String headerText=driver.findElement(By.xpath(headerPath)).getText();
                   if(headerText.equalsIgnoreCase("CPU")){
                       chromeCPUIntable=data;
                   }

               }
               break;


       }
        System.out.println(chromeCPUIntable);
       String yellowParaText = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
       String exactYellowParaText=yellowParaText.split(":")[1].trim();
       Assert.assertEquals(exactYellowParaText,chromeCPUIntable);


       driver.quit();

    }
}
