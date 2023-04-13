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
    public abstract List<WebElement> gettingProductsName();

    public abstract List<String> sortProducts(List<WebElement> elements);

    public abstract List<String> parsingWebElementToString(List<WebElement> elements);

    public abstract List<String> reverseOrderProductTextFunction(List<WebElement> elements);

    public abstract List<Double> removeDollarSymbol(List<WebElement> elements);
}
