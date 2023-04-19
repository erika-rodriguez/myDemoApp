package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.CartScreenBase;
import com.solvd.mobile.common.NoItemScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private ExtendedWebElement addedItems;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/removeBt")
    private ExtendedWebElement removeButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private ExtendedWebElement plusButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private ExtendedWebElement productPrice;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/totalPriceTV")
    private ExtendedWebElement calculatorResult;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public NoItemScreenBase clickOnRemove() {
        removeButton.click();

        return initPage(getDriver(), NoItemScreenBase.class);
    }

    @Override
    public boolean isProductAdded() {
        return addedItems.isElementPresent();
    }

    @Override
    public void clickOnPlusButton() {
        plusButton.click();
    }

    @Override
    public boolean isCalculatorWorking() {
        String x = calculatorResult.getText();
        String updatedResult = x.replace("$ ", "").replace(".", "");
        int s2 = Integer.parseInt(updatedResult);
        int s1 = 5998;
        if (s1 == s2) {
            return true;
        }
        return false;
    }

}
