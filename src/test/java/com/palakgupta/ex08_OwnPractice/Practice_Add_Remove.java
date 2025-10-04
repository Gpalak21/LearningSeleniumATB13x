package com.palakgupta.ex08_OwnPractice;

import com.palakgupta.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice_Add_Remove extends CommonToAll {

    @Test
    public void testOnClickOneDeletDisplayed(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/add-remove-elements");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Delete']")).isDisplayed());
        Assert.assertEquals("Delete",driver.findElement(By.xpath("//button[text()='Delete']")).getText());

        closeBrowser(driver);
    }

    @Test
    public void testAddMultipleElements(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/add-remove-elements");

        int count =0;

        for(int i =1; i<=5;i++){
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
            count++;
        }

        int noOfDeleteButton = driver.findElements(By.xpath("//div[@id='elements']//button")).size();
        Assert.assertEquals(count,noOfDeleteButton);

    }

    @Test
    public void testRemoveElement(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/add-remove-elements");

        int count =0;

        for(int i =1; i<=3;i++){
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
            count++;
        }
        System.out.println("count is : "+count);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//div[@id='elements']/button"+"["+count+"]")).click();
        count--;
        System.out.println("count is :"+count);
        int noOfDeleteButton = driver.findElements(By.xpath("//div[@id='elements']/button")).size();
        System.out.println("no of deete buttons: "+noOfDeleteButton);

        Assert.assertEquals(count,noOfDeleteButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(int i=0;i<=count;i++){
            driver.findElement(By.xpath("//div[@id='elements']/button"+"["+count+"]")).click();
            count--;
        }
        System.out.println("count is :"+count);

        int NoDelete = driver.findElements(By.xpath("//div[@id='elements']/button")).size();

        Assert.assertEquals(count,NoDelete);

    }



}
