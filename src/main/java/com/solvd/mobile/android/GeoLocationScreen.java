package com.solvd.mobile.android;

import com.solvd.mobile.common.GeoLocationScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeoLocationScreenBase.class)
public class GeoLocationScreen extends GeoLocationScreenBase{
    public GeoLocationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isGeoLocationTxtPresent() {
        return false;
    }
}
