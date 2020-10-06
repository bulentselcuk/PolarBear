package com.PolarBear.pages;

import com.PolarBear.utilities.BrowserUtilities;
import com.PolarBear.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="prependedInput")
    private WebElement userName;
    @FindBy(id="prependedInput2")
    private WebElement password;
    @FindBy(id="_submit")
    private WebElement submit;

    public void login() {

        String usernameValue=ConfigurationReader.getProperty ( "uSer" );
        String userPasswordValue=ConfigurationReader.getProperty ( "pAss" );
        userName.click ();
        userName.sendKeys ( usernameValue );
        password.sendKeys ( userPasswordValue );
        submit.click ();

    }

    public void login(String usernameValue, String passwordValue) {
        this.userName.sendKeys ( new CharSequence[]{usernameValue} );
        this.password.sendKeys ( new CharSequence[]{passwordValue, Keys.ENTER} );
        BrowserUtilities.waitForPageToLoad ( 10L );
        BrowserUtilities.wait ( 2 );
    }
}