package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.CartScreenBase;
import com.solvd.mobile.common.NoItemScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/removeBt")
    private ExtendedWebElement removeButton;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public NoItemScreenBase clickOnRemove() {
       removeButton.click();

        return initPage(getDriver(), NoItemScreenBase.class);
    }
}
