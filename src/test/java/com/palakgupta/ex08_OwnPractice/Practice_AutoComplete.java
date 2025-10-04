package com.palakgupta.ex08_OwnPractice;

import com.palakgupta.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Practice_AutoComplete extends CommonToAll {

    @Test
    public void verifyDropDownSuggestionAppear(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/autocomplete");

        driver.findElement(By.id("country")).sendKeys("i");
        WebElement countriesList = driver.findElement(By.id("countryautocomplete-list"));

        assertThat(countriesList.isDisplayed());

        closeBrowser(driver);

    }

    @Test
    public void verifySuggestionContainsTypedText(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/autocomplete");

        driver.findElement(By.id("country")).sendKeys("ind");
        int count = driver.findElements(By.xpath("//div[@id='countryautocomplete-list']/div")).size();
        System.out.println(count);
//        WebElement countriesList = driver.findElement(By.id("countryautocomplete-list"));

        for(int i=1;i<=count;i++){
            String dropdownList = driver.findElement(By.xpath("//div[@id='countryautocomplete-list']/div["+i+"]")).getText();
            System.out.println(dropdownList);
            Assert.assertTrue(dropdownList.toLowerCase().startsWith("ind "));
        }

//        assertThat(countriesList.isDisplayed());

        closeBrowser(driver);
    }

    @Test
    public void verifySelectionByMouseClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/autocomplete");

        driver.findElement(By.id("country")).sendKeys("ind");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='countryautocomplete-list']/div[input[@value='India']]")).click();
        String countyrName = driver.findElement(By.id("country")).getAttribute("value");


//        Assert.assertEquals("India",driver.findElement(By.id("country")).getText());

    }

}
