package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.AboutAppScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = AboutAppScreenBase.class)
public class AboutAppScreen extends AboutAppScreenBase {
    public AboutAppScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/characterIV")
    private ExtendedWebElement sauceLabMascot;

    @Override
    public boolean isSauceLabMascotPresent() {
        return sauceLabMascot.isElementPresent();
    }
}
