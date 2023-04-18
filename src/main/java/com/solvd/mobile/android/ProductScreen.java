package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.ProductScreenBase;
import com.solvd.mobile.common.ReviewSubmittedMessageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {
    @ExtendedFindBy(text = "Add to cart")
    private ExtendedWebElement addToCartBtn;
    @ExtendedFindBy(text = "")
    private ExtendedWebElement oneStarBtn;
    public ProductScreen(WebDriver driver) {
        super(driver);
    }
    @Override
    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
    }

    @Override
    public ReviewSubmittedMessageBase clickOneStarReview() {
        oneStarBtn.click();
        return initPage(getDriver(), ReviewSubmittedMessageBase.class);
    }

}
