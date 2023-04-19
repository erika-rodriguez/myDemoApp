package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import com.solvd.mobile.common.*;
import com.zebrunner.agent.core.annotation.Maintainer;
import com.zebrunner.agent.core.registrar.Screenshot;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.report.ReportContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;

public class MenuTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test(description = "[TC01]-testAboutButton")
    public void testAboutButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        AboutAppScreenBase options = menu.clickOnAboutButton();

        Assert.assertTrue(options.isSauceLabMascotPresent(), "The About button does not work");
    }

    @Test(description = "[TC02]-testQRScannerButton")
    public void testQRScannerButton() throws Exception {
        LOGGER.info("Artifact's folder: {}", ReportContext.getArtifactsFolder().getAbsolutePath());
        LOGGER.info("Directory project : {}", ReportContext.getTestDir().getName());
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        byte[] screenShot4 = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        Screenshot.upload(screenShot4, null);
        MenuScreenBase menu = catalog.clickOnMenu();
        LOGGER.info("This is another logger info");
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

    @Test(description = "[TC08]-testResetAppButton", dataProvider = "DataProvider")
    @Maintainer("ErikaAndGerman")
    @CsvDataSourceParameters(path = "parallelDevices.csv", dsUid = "TUID")
    public void testResetAppButton(HashMap<String, String> data) {
        R.CONFIG.put("capabilities.deviceName", data.get("deviceName"), true);
        R.CONFIG.put("capabilities.platformVersion", data.get("platformVersion"), true);
        R.CONFIG.put("capabilities.platformName", data.get("platformName"), true);
        R.CONFIG.put("selenium_url", data.get("selenium_url"), true);
        R.CONFIG.put("capabilities.app", data.get("app"), true);
        R.CONFIG.put("capabilities.build", "30_Devices_Running", true);
        R.CONFIG.put("capabilities.name", "ios-training-cycle", true);

        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        ResetAppScreenBase reset = menu.clickOnResetAppButton();

        Assert.assertTrue(reset.isResetAlertShown(), "The Reset App button does not work");
    }

    @Test(description = "[TC14]-testAscendingPriceButton")
    public void testAscendingPriceButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        SortingScreenBase sortingOptions = catalog.clickOnSortingItem();
        CatalogScreenBase sortedCatalog = sortingOptions.clickOnPriceAscendingOrder();

        Assert.assertTrue(sortedCatalog.isCatalogAscendingSorted(), "The catalog is not sorted in ascending order.");
    }

    @Test(description = "[TC13]-testDescendingPriceOrder")
    public void testDescendingPriceOrder() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        SortingScreenBase sortingOptions = catalog.clickOnSortingItem();
        CatalogScreenBase sortedCatalog = sortingOptions.clickOnPriceDescendingOrder();

        Assert.assertTrue(sortedCatalog.isCatalogDescendingSorted(), "The catalog is not sorted in descending order.");
    }

    @Test(description = "[TC-15]-testAscendingNameButton")
    public void testAscendingNameButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        SortingScreenBase sortingOptions = catalog.clickOnSortingItem();
        sortingOptions.clickOnNameAscendingOption();

        Assert.assertTrue(catalog.isAscendingNameSorted(), "The catalog is not sorted in ascending order.");
    }

    @Test(description = "[TC12]-testDescendingNameOrder")
    public void testDescendingNameOrder() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        SortingScreenBase sortingOptions = catalog.clickOnSortingItem();
        CatalogScreenBase sortedCatalog = sortingOptions.clickOnNameDescendingOrder();

        Assert.assertTrue(sortedCatalog.isCatalogDescendingNameSorted(), "Catalog's names are not sorted in descending order.");
    }

    @Test(description = "[TC17]-testRemoveProductFromCartButton", dependsOnMethods = "testAddProductToCart")
    public void testRemoveProductFromCartButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        CartScreenBase product = catalog.clickOnCart();
        NoItemScreenBase noItemScreenBase = product.clickOnRemove();

        Assert.assertTrue(noItemScreenBase.isElementPresent(), "The product was not deleted");
    }

    @Test(description = "[TC16]-testAddProductToCart")
    public void testAddProductToCart() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product = catalog.clickOnProduct();
        product.clickOnAddToCartBtn();
        CartScreenBase cart = catalog.clickOnCart();

        Assert.assertTrue(cart.isProductAdded(), "The product was not added to the cart.");
    }

    @Test(description = "[TC18]-testCalculatorOnCart")
    public void testCalculatorOnCart() {
        //As a precondition the cart must be empty
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product = catalog.clickOnProduct();
        product.clickOnAddToCartBtn();
        CartScreenBase cart = catalog.clickOnCart();
        cart.clickOnPlusButton();

        Assert.assertEquals(cart.calculatorSum(),5998,"The Calculator is not working");
    }
}
