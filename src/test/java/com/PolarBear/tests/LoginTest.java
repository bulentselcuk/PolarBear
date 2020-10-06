package com.PolarBear.tests;

import com.PolarBear.pages.LoginPage;
import com.PolarBear.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class LoginTest extends BaseTest{

    public void loginTest(){
        extentTest = extentReports.createTest("Verify page Title");
        LoginPage loginPage = new LoginPage ();
        loginPage.login ();

        System.out.println (Driver.getDriver ().getTitle ());
        Assert.assertEquals(Driver.getDriver ().getTitle(), "Dashboard");
        extentTest.pass("Page Title verified!");
    }
}
