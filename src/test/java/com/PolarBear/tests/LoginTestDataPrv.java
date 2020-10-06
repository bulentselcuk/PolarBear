package com.PolarBear.tests;

import com.PolarBear.pages.LoginPage;
import com.PolarBear.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestDataPrv extends BaseTest{

    @Test(dataProvider="data-provider")

    public void login(String username, String password){
        extentTest = extentReports.createTest("Verify page Title");
        LoginPage loginPage = new LoginPage ();
        loginPage.login ();
        System.out.println ( Driver.getDriver ().getTitle ());
        Assert.assertEquals(Driver.getDriver ().getTitle(), "Dashboard");
        extentTest.pass("Page Title verified!");
    }
    @DataProvider(name="data-provider")
    public Object[][] dataProviderMethod(){
        return new Object[][]{
                {"user1", "UserUser123"},
                {"user2", "UserUser123"},
                {"user3", "UserUser123"},
                {"user4", "UserUser123"},
                {"user5", "UserUser123"},
                {"storemanager51","UserUser123"},
                {"storemanager53", "UserUser123"},
                {"storemanager54", "UserUser123"},
                {"storemanager55", "UserUser123"},
                {"salesmanager101","UserUser123"},
                {"salesmanager102","UserUser123"},
                {"salesmanager103","UserUser123"},
                {"salesmanager104","UserUser123"},
                {"salesmanager105","UserUser123"}

        };
    }
}
