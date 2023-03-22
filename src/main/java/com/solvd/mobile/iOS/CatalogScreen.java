package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.MenuScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement menuBtn;

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
        return false;
    }
}
