package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import com.solvd.mobile.common.*;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

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

    @Test(description = "[TC04]-testFingerPrintButton - ANDROID")
    public void testFingerPrintButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        BiometricAlertScreenBase alert = menu.clickOnFingerPrintButton();
        FingerPrintScreenBase fingerPrint = alert.clickOnOkButton();

        Assert.assertTrue(fingerPrint.isFingerPrintTextPresent(), "The FingerPrint button does not work");
    }

    @Test(description = "[TC05]-testWebViewButton")
    public void testWebViewButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        WebViewScreenBase webView = menu.clickOnWebViewButton();

        Assert.assertTrue(webView.isWebViewTxtPresent(), "The WebView screen is not opened");
    }

    @Test(description = "[TC06]-testDrawingButton")
    public void testDrawingButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        DrawingScreenBase drawing = menu.clickOnDrawingButton();

        Assert.assertTrue(drawing.isDrawingTxtPresent(), "The Drawing button does not work");
    }

    @Test(description = "[TC07]-testFaceIdButton - iOS")
    public void testFaceIdButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);

        MenuScreenBase menu = catalog.clickOnMenu();
        FaceIdScreenBase faceIdScreen = menu.clickOnFaceIDButton();
        Assert.assertTrue(faceIdScreen.isFaceIdScreenOpened(), "The button FaceId does not Work");

    }


    @Test(description = "[TC09]-testLoginButton")
    public void testLoginButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        LoginScreenBase login = menu.clickOnLoginButton();

        Assert.assertTrue(login.isLoginTxtPresent(), "The Login button does not work");

    }

    @Test(description = "[TC10]-testLogin")
    public void testLogin() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        LoginScreenBase login = menu.clickOnLoginButton();
        login.selectUsers();
        login.clickOnLogin();

        Assert.assertTrue(catalog.isPageOpened(), "The Login button does not work");
    }

    @Test(description = "[TC11]-testLogout - iOS", dependsOnMethods = {"testLogin"})
    public void testLogout() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        menu.clickOnLogout();
    }

    @Test(description = "[TC08]-testResetAppButton",dataProvider = "DataProvider")
    @CsvDataSourceParameters(path = "parallelDevices.csv",
            dsUid = "TUID")
    public void testResetAppButton(HashMap<String,String> data) {
        R.CONFIG.put("capabilities.deviceName", data.get("deviceName"), true);
        R.CONFIG.put("capabilities.platformVersion",data.get("platformVersion"), true);
        R.CONFIG.put("capabilities.platformName", data.get("platformName"), true);
        R.CONFIG.put("selenium_url", data.get("selenium_url"), true);
        R.CONFIG.put("capabilities.app", data.get("app"), true);
//        R.CONFIG.put("capabilities.build", "Parallel-Running-Android", true);
//        R.CONFIG.put("capabilities.name", "ios-training-cycle", true);

        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        ResetAppScreenBase reset = menu.clickOnResetAppButton();

        Assert.assertTrue(reset.isResetAlertShown(), "The Reset App button does not work");
    }



//    @DataProvider(parallel = true, name = "capabilitiesDataProvider")
//    public static Object[][] capabilitiesDataProvider() {
//        return new Object[][]{
//                {"Motorola Moto G7 Play", "9.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"Samsung Galaxy A52", "11.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"OnePlus 8", "10.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"Huawei P30", "9.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"Xiaomi Redmi Note 7", "9.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"Samsung Galaxy S6", "5.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"Samsung Galaxy S8 Plus", "7.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"Motorola Moto X 2nd Gen", "5.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"OnePlus 7T", "10.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//                {"Xiaomi Redmi Note 11", "11.0", "Android", "http://hub.browserstack.com/wd/hub", "bs://347a6d1482a53335e01e4966c36f1bc9577b09bf"},
//        };
//    }
}
