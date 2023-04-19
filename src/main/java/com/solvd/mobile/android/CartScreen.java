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

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private ExtendedWebElement productAmount;

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
    public int calculatorSum() {
        String y = productPrice.getText();
        String z = productAmount.getText();

        String y2 = y.replace("$ ", "").replace(".", "");
        String z2 = z.replace("$ ", "").replace(".", "");

        int price = Integer.parseInt(y2);
        int amount = Integer.parseInt(z2);
        return price*amount;
    }

    @Override
    public boolean isColourSelected() {
        //Only works on iOS
        return false;
    }

}
