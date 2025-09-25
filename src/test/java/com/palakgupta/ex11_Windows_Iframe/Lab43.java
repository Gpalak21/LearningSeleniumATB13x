package com.palakgupta.ex11_Windows_Iframe;

import com.palakgupta.utils.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab43 extends CommonToAll {

    @Test
    public void test_windows(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> window_handle_ids = driver.getWindowHandles();
        System.out.println(window_handle_ids);

        for(String window: window_handle_ids){
            driver.switchTo().window(window);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed!");
            }
        }

        driver.switchTo().window(parent_id);
        closeBrowser(driver);

    }
}
