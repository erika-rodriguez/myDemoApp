package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.NoItemScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = NoItemScreenBase.class)
public class NoItemScreen extends NoItemScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Go Shopping\"`]")
    private ExtendedWebElement goShoppingElement;

    public NoItemScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementPresent() {
        return goShoppingElement.isElementPresent();
    }
}
