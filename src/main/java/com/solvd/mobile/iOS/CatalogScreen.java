package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.MenuScreenBase;
import com.solvd.mobile.common.SortingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement menuBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Products\"`]")
    private ExtendedWebElement products;
    public CatalogScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public MenuScreenBase clickOnMenu() {
        menuBtn.click();
        return initPage(getDriver(), MenuScreenBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return products.isElementPresent();
    }

    @Override
    public SortingScreenBase clickOnSortingItem() {
        return null;
    }

    @Override
    public List<Double> removeDollarSymbol() {
        return null;
    }

    @Override
    public List<Double> sortList() {
        return null;
    }

    @Override
    public boolean swipe(ExtendedWebElement webElement) {
        return false;
    }

    @Override
    public List<Double> getRawList() {
        return null;
    }

    @Override
    public List<ExtendedWebElement> createList() {
        return null;
    }


}
