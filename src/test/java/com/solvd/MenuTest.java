package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.mobile.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest implements IAbstractTest {

    @Test(description = "[TC01]-testAboutButton")
    public void testAboutButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        AboutAppScreenBase options = menu.clickOnAboutButton();

        Assert.assertTrue(options.isSauceLabMascotPresent(), "The About button does not work");
    }

    @Test(description = "[TC02]-testQRScannerButton")
    public void testQRScannerButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        QRCodeScreenBase qr = menu.clickOnQRCodeButton();

        Assert.assertTrue(qr.isQRCodeTxtVisible(), "The QR Screen is not opened");
    }

    @Test(description = "[TC03]-testGeoLocationButton")
    public void testGeoLocationButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        GeoLocationScreenBase geoLocation = menu.clickOnGeoLocationButton();

        Assert.assertTrue(geoLocation.isGeoLocationTxtPresent(), "The GeoLocation screen is not opened");
    }


}
