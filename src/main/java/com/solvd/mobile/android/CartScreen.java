package com.solvd.mobile.android;

import com.solvd.mobile.common.CartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {

    public CartScreen(WebDriver driver) {
        super(driver);
    }
}
