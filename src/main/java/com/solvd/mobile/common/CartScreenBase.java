package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartScreenBase extends AbstractPage {
    public CartScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract NoItemScreenBase clickOnRemove();

    public abstract boolean isProductAdded();

    public abstract void clickOnPlusButton();

    public abstract int calculatorSum();
}
