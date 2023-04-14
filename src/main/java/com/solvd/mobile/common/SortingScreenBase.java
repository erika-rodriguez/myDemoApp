package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class SortingScreenBase extends AbstractPage {
    public SortingScreenBase(WebDriver driver) {
        super(driver);
    }
    public abstract CatalogScreenBase clickOnPriceAscendingOrder();
    public abstract CatalogScreenBase clickOnPriceDescendingOrder();
}
