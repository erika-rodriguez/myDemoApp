package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.Screenshot;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.MenuScreenBase;
import com.solvd.mobile.common.SortingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {
    public CatalogScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private ExtendedWebElement menu;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private ExtendedWebElement productTitle;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private List<ExtendedWebElement> pricesList;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
    private ExtendedWebElement sortingOrderButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/LinkedInIV")
    private ExtendedWebElement linkedIdn;

    @Override
    public MenuScreenBase clickOnMenu() {
        menu.click();
        return initPage(getDriver(), MenuScreenBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return productTitle.isElementPresent();
    }

    @Override
    public SortingScreenBase clickOnSortingItem() {
        sortingOrderButton.click();
        return initPage(getDriver(), SortingScreenBase.class);
    }

    public List<Double> sortList(){
        List<Double> doubleList = removeDollarSymbol();
        return doubleList.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public List<Double> removeDollarSymbol() {
        List<ExtendedWebElement> myList = createList();
        List<String> stringList = myList.stream().map(e -> e.getText().replace("$ ", "")).collect(Collectors.toList());
        return stringList.stream().map(e -> Double.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public List<ExtendedWebElement> createList() {
        List<ExtendedWebElement> myList = new ArrayList<>();
        myList.addAll(pricesList);
        swipe(linkedIdn);
        myList.addAll(pricesList);
        return myList;
    }

    @Override
    public boolean swipe(ExtendedWebElement locator) {
        return swipe(locator, Direction.UP);
    }

    @Override
    public List<Double> getRawList() {
        List<ExtendedWebElement> myList = createList();
        List<String> stringList = myList.stream().map(e -> e.getText().replace("$ ", "")).collect(Collectors.toList());
        return stringList.stream().map(e -> Double.valueOf(e)).collect(Collectors.toList());
    }


}
