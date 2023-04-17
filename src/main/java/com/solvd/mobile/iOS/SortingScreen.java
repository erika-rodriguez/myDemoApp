package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.SortingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SortingScreenBase.class)
public class SortingScreen extends SortingScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Price - Ascending\"`]")
    private ExtendedWebElement ascendingPriceButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Price - Descending\"`]")
    private ExtendedWebElement descendingPriceButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Name - Ascending\"`]")
    private ExtendedWebElement ascendingNameButton;

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

    @Override
    public CatalogScreenBase clickOnNameAscendingOption() {
        ascendingNameButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }
}
