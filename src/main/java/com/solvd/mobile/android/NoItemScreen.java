package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.NoItemScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = NoItemScreenBase.class)
public class NoItemScreen extends NoItemScreenBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/shoppingBt")
    private ExtendedWebElement goShoppingElement;

    public NoItemScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementPresent() {
        return goShoppingElement.isElementPresent();
    }
}
