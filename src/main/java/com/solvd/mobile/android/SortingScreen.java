package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.SortingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = SortingScreenBase.class)
public class SortingScreen extends SortingScreenBase {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuPriceAscIV")
    private ExtendedWebElement ascendingPriceButton;

    public SortingScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CatalogScreenBase clickOnPriceAscendingOrder() {
       ascendingPriceButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }

    @Override
    public CatalogScreenBase clickOnPriceDescendingOrder() {
        return null;
    }

    @Override
    public List<WebElement> gettingProductsName() {
        return null;
    }

    @Override
    public List<String> sortProducts(List<WebElement> elements) {
        List<String> sortedElements = new ArrayList<>();
        for (WebElement data : elements) {
            sortedElements.add(data.getText());
        }
        Collections.sort(sortedElements);
        return sortedElements;
    }

    @Override
    public List<String> parsingWebElementToString(List<WebElement> elements) {
        List<String> firstSortedElements = new ArrayList<>();
        for (WebElement data : elements) {
            firstSortedElements.add(data.getText());
        }
        Collections.sort(firstSortedElements);
        return firstSortedElements;
    }

    @Override
    public List<String> reverseOrderProductTextFunction(List<WebElement> elements) {
        return null;
    }
    @Override
    public List<Double> removeDollarSymbol(List<WebElement> elements) {
        List<Double> elementsToString = new ArrayList<>();
        for (WebElement data : elements) {
            elementsToString.add(Double.valueOf(data.getText().replace("$ ", "")));
        }
        return elementsToString;
    }
}
