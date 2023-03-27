package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginScreenBase.class)
public class LoginScreen extends LoginScreenBase {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Login\"`][1]")
    private ExtendedWebElement loginTxt;
    @FindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    private ExtendedWebElement userName;
    @FindBy(xpath = "//*[@type='XCUIElementTypeSecureTextField']")
    private ExtendedWebElement passWord;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Login\"`]")
    private ExtendedWebElement loginButton;
    public LoginScreen(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isLoginTxtPresent() {
        return loginTxt.isElementPresent();
    }
    @Override
    public void setUsername(String username) {
    userName.type(username);
    }
    @Override
    public void setPassword(String password) {
    passWord.type(password);
    }
    @Override
    public CatalogScreenBase clickOnLogin() {
       loginButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }
}
