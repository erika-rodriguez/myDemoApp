package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.ResetAppScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResetAppScreenBase.class)
public class ResetAppScreen extends ResetAppScreenBase{
    @FindBy(xpath = "//*[@resource-id='com.saucelabs.mydemoapp.android:id/alertTitle']")
    private ExtendedWebElement resetAppTxt;
    public ResetAppScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isResetAlertShown() {
        return resetAppTxt.isElementPresent();
    }
}
