package com.palakgupta.ex11_Windows_Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab44 {

    @Test
    public void test_interview_vwo_project() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/analyze/heatmap/3/reports?token=eyJhY2NvdW50X2lkIjoxMTM0NTkxLCJleHBlcmltZW50X2lkIjozLCJjcmVhdGVkX29uIjoxNzU2MDA4MDkyLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiZTlmNmY0ZGZlMGJhMGIxNmQxMjZmMGJlOTUyMDQ3MmEiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&accountId=1134591");

        Thread.sleep(5000);

       String parentWindowHandle= driver.getWindowHandle();
        System.out.println("Parent ->"+parentWindowHandle);

        WebElement url_input = driver.findElement(By.name("primaryUrl"));
        url_input.clear();
        url_input.sendKeys("https://thetestingacademy.com/");

        driver.findElement(By.xpath("//button[text()=' View Heatmap ']")).click();

        Thread.sleep(10000);

        Set<String> all_handles = driver.getWindowHandles();
        System.out.println(all_handles);

        for(String handle: all_handles){
            if(!handle.equalsIgnoreCase(parentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }



    }
}
