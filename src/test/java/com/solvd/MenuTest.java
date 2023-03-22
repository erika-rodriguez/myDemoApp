package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.mobile.common.AboutAppScreenBase;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.MenuScreenBase;
import com.solvd.mobile.common.QRCodeScreenBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest implements IAbstractTest {

    @Test
    @TestLabel(name = "testAboutButton", value = "iOS-Mobile")
    public void testAboutButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        Assert.assertTrue(catalog.isPageOpened(),"Catalog screen isn't opened");

        MenuScreenBase menu = catalog.clickOnMenu();
        AboutAppScreenBase options = menu.clickOnAboutButton();

       Assert.assertTrue(options.isSauceLabMascotPresent(),"The About button does not work");
    }

    @Test (description = "[TC02]-testQRScannerButton")
    public void testQRScannerButton(){
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        MenuScreenBase menu = catalog.clickOnMenu();
        QRCodeScreenBase qr=menu.clickOnQRCodeButton();

        Assert.assertTrue(qr.isQRCodeTxtVisible());
    }


}
