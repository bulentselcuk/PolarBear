package com.PolarBear.pages;

import com.PolarBear.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver=Driver.getDriver ();
    protected WebDriverWait wait=new WebDriverWait ( driver, 20 );

    @FindBy(xpath="//h1[@class='logo logo-text']/a[.='Fleet Management']")
    protected WebElement title;
    @FindBy(xpath="//h1[@class='oro-subtitle']")
    protected WebElement subTitle;


    public BasePage() {
        PageFactory.initElements ( Driver.getDriver (),this );

    }


}
