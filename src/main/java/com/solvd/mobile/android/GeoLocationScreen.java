package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.GeoLocationScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeoLocationScreenBase.class)
public class GeoLocationScreen extends GeoLocationScreenBase{
    @FindBy(xpath = "//*[@text='Geo Location']")
    private ExtendedWebElement geoLocationTxt;
    public GeoLocationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isGeoLocationTxtPresent() {
        return geoLocationTxt.isElementPresent();
    }
}
