package com.palakgupta.ex10_DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab41TestDDT {

    @DataProvider(name="loginData", parallel = true)
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass123"},
                new Object[]{"admin124@gmail.com", "pass124"}
        };
    }


    @Test(dataProvider = "loginData")
    public void loginTest(String email, String pass){
        System.out.println(email + " | " + pass);
    }
}
