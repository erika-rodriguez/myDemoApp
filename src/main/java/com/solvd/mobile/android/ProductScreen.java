package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.ProductScreenBase;
import com.solvd.mobile.common.ReviewSubmittedMessageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {
    @ExtendedFindBy(text = "Add to cart")
    private ExtendedWebElement addToCartBtn;

    //@FindBy(xpath = "//*[resource-id='com.saucelabs.mydemoapp.android:id/start1IV']")
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView[2]")
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
