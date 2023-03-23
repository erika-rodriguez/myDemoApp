package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GeoLocationScreenBase extends AbstractPage {
    public GeoLocationScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isGeoLocationTxtPresent();
}
