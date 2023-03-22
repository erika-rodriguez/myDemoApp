package com.solvd.mobile.android;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.AboutAppScreenBase;
import com.solvd.mobile.common.MenuScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = MenuScreenBase.class)
public class MenuScreen extends MenuScreenBase {
    @FindBy(xpath = "//*[@text='About']")
    private ExtendedWebElement aboutButton;
    public MenuScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public AboutAppScreenBase clickOnAboutButton() {
        aboutButton.click();
        return initPage(getDriver(), AboutAppScreenBase.class);

    }

}
