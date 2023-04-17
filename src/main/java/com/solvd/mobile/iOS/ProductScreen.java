package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.ProductScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase{
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Add To Cart\"`]")
    private ExtendedWebElement addToCartBtn;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }
    @Override
    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
    }


}
