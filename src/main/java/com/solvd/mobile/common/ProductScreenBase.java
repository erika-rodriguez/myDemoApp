package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductScreenBase extends AbstractPage {

    public ProductScreenBase(WebDriver driver) {
        super(driver);
    }
    public abstract void clickOnAddToCartBtn();
    public abstract ReviewSubmittedMessageBase clickOneStarReview();
    public abstract void clickOnAddItem();
    public abstract int isItemAdded();
}
