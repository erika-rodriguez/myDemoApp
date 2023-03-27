package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginScreenBase.class)
public class LoginScreen extends LoginScreenBase {
    @FindBy(xpath = "//*[@resource-id='com.saucelabs.mydemoapp.android:id/loginTV']")
    private ExtendedWebElement loginTxt;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private ExtendedWebElement loginText;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    private ExtendedWebElement loginButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/username1TV")
    private ExtendedWebElement bobUser;

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoginTxtPresent() {
        return loginTxt.isElementPresent();
    }

    @Override
    public void selectUsers() {
        bobUser.click();
    }
    @Override
    public CatalogScreenBase clickOnLogin() {
        loginButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }

}
