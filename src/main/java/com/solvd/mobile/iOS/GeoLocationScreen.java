package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.GeoLocationScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = GeoLocationScreenBase.class)
public class GeoLocationScreen extends GeoLocationScreenBase{
    @ExtendedFindBy(iosPredicate = "label == \"Geo Location\"")
    private ExtendedWebElement geoLocationTxt;

    public GeoLocationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isGeoLocationTxtPresent() {
        return geoLocationTxt.isElementPresent();
    }
}
