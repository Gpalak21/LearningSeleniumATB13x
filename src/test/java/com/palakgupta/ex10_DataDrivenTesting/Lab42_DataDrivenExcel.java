package com.palakgupta.ex10_DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab42_DataDrivenExcel {


    @Test(dataProvider = "getData" , dataProviderClass = UtilExcel.class)
    public void test_VWO_Login(String email, String pass){

        System.out.println("Email - "+email);
        System.out.println("Password - "+ pass);

    }
}
