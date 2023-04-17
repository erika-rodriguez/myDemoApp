package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase{
    @ExtendedFindBy(iosPredicate = "type == \"XCUIElementTypeCell\"")
    private ExtendedWebElement addedItem;
    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductAdded() {
        return addedItem.isElementPresent();
    }
}
