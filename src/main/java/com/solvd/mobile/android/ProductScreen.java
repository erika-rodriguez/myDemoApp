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
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private ExtendedWebElement addItemIcon;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private ExtendedWebElement itemsCount;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private ExtendedWebElement amount;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private ExtendedWebElement plusButton;

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
    public void clickOnAddItem() {
        addItemIcon.click();
    }

    @Override
    public int isItemAdded() {
        int amount=Integer.valueOf(itemsCount.getText());
        return amount;
    }

    public void clickOnPlusButton() {
        plusButton.click();
    }

    @Override
    public int productAmount() {
        String x = amount.getText();
        int x1= Integer.parseInt(x);
        return x1;
    }
}
