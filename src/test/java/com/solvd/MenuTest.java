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
    @Test(description = "[TC05]-testWebViewButton")
    public void testWebViewButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        WebViewScreenBase webView = menu.clickOnWebViewButton();

        Assert.assertTrue(webView.isWebViewTxtPresent(), "The WebView screen is not opened");
    }

    @Test(description = "[TC04]-testFaceIdButton")
    public void testFingerPrintButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        BiometricAlertScreenBase alert = menu.clickOnFingerPrintButton();
        FingerPrintScreenBase fingerPrint = alert.clickOnOkButton();

        Assert.assertTrue(fingerPrint.isFingerPrintTextPresent(),"The FingerPrint button does not work");
    }

    @Test(description = "[TC06]-testDrawingButton")
    public void testDrawingButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        DrawingScreenBase drawing = menu.clickOnDrawingButton();

        Assert.assertTrue(drawing.isDrawingTxtPresent(),"The Drawing button does not work");
    }

    @Test(description = "[TC08]-testResetAppButton")
    public void testResetAppButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        ResetAppScreenBase reset = menu.clickOnResetAppButton();

        Assert.assertTrue(reset.isResetAlertShown(),"The Reset App button does not work");
    }

    @Test(description = "[TC09]-testLoginButton")
    public void testLoginButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        LoginScreenBase login = menu.clickOnLoginButton();

        Assert.assertTrue(login.isLoginTxtPresent(),"The Login button does not work");
    }

}
