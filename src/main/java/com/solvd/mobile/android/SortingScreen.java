package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.SortingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = SortingScreenBase.class)
public class SortingScreen extends SortingScreenBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuPriceAscIV")
    private ExtendedWebElement ascendingPriceButton;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuPriceDscIV")
    private ExtendedWebElement descendingPriceButton;

    public SortingScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CatalogScreenBase clickOnPriceAscendingOrder() {
       ascendingPriceButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }

    @Override
    public CatalogScreenBase clickOnPriceDescendingOrder() {
        descendingPriceButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }
}
