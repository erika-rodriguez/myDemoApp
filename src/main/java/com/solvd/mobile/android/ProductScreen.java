package com.solvd.mobile.android;

import com.solvd.mobile.common.ProductScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {
    public ProductScreen(WebDriver driver) {
        super(driver);
    }
}
