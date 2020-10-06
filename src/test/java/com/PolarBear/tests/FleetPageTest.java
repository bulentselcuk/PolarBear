package com.PolarBear.tests;

import com.PolarBear.pages.LoginPage;
import com.PolarBear.utilities.BrowserUtilities;
import com.PolarBear.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class FleetPageTest extends BaseTest {
    @Test
    public void fleetMenuTest() {
        extentTest=extentReports.createTest ( "Verify Fleet Page Title" );
        LoginPage loginPage=new LoginPage ();
        loginPage.login ();
        BrowserUtilities.waitForPageToLoad ( 10L );
        Actions action=new Actions ( driver );
        BrowserUtilities.wait ( 2 );
        WebElement fleet=driver.findElement ( By.xpath ( "//*[@id=\"main-menu\"]/ul/li[2]/a/span" ) );
        fleet.click ();
        WebElement vehicles=driver.findElement ( (By.xpath ( "//span[.='Vehicles']" )) );
        vehicles.click ();
        BrowserUtilities.wait ( 2 );
        WebElement carCreate=driver.findElement ( By.cssSelector ( ".main-group" ) );
        carCreate.click ();

        System.out.println ( Driver.getDriver ().getTitle () );
        Assert.assertEquals ( Driver.getDriver ().getTitle (), "All - Car - Entities - System - Car - Entities - System" );
        extentTest.pass ( "Fleet Page Title verified!" );
    }

    @Test
    public void menu() {
        extentTest=extentReports.createTest ( "Verify Menu List" );
        LoginPage loginPage=new LoginPage ();
        loginPage.login ();
        BrowserUtilities.waitForPageToLoad ( 10L );
        Actions action = new Actions ( driver );
        List<WebElement>element=driver.findElements ( By.xpath ( "//ul[@class='nav-multilevel main-menu']/li" ) );
        for(WebElement each: element){
            action.moveToElement ( each ).perform ();
            System.out.println (each.getText ());
            BrowserUtilities.wait ( 1 );
        }
        extentTest.pass ( "Menu has listed" );
    }
}
