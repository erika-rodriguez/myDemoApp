package com.solvd.mobile.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CatalogScreenBase extends AbstractPage implements IMobileUtils {

    public CatalogScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuScreenBase clickOnMenu();

    public abstract boolean isPageOpened();

    public abstract SortingScreenBase clickOnSortingItem();

    public abstract List<Double> removeDollarSymbol(List<ExtendedWebElement> originalList);

    public abstract List<ExtendedWebElement> createList();
    public abstract boolean isCatalogAscendingSorted();

    public abstract boolean isCatalogDescendingSorted();
}
