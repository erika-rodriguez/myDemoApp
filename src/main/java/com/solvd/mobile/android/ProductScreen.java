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
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/start1IV")
    private ExtendedWebElement oneStarBtn;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private ExtendedWebElement amount;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private ExtendedWebElement plusButton;
   @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Blue color\"]")
    private ExtendedWebElement blueButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/aroundIV")
    private ExtendedWebElement aroundColor;

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

    @Override
    public void clickOnPlusButton() {
        plusButton.click();
    }

    @Override
    public int productAmount() {
        String x = amount.getText();
        int x1 = Integer.parseInt(x);
        return x1;
    }

    @Override
    public void clickOnBlueSelectionButton() {
        blueButton.click();
    }

    @Override
    public boolean isColorButtonSelected() {
        return aroundColor.isElementPresent();
    }

}
