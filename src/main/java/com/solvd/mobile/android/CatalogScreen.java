package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.CartScreenBase;
import com.solvd.mobile.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {
    public CatalogScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/menuIV")
    private ExtendedWebElement menu;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private ExtendedWebElement cartIcon;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private ExtendedWebElement productTitle;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private List<ExtendedWebElement> pricesList;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private List<ExtendedWebElement> namesList;
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortIV")
    private ExtendedWebElement sortingOrderButton;
    @FindBy(xpath = "//*[contains(@name, 'Sauce Lab')]")
    private List<ExtendedWebElement> name;

    @FindBy(xpath = "//*[contains(@content-desc, 'Sauce Lab')]")
    private List<ExtendedWebElement> products;


//    @FindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
//    private ExtendedWebElement cartIcon;

    @Override
    public MenuScreenBase clickOnMenu() {
        menu.click();
        return initPage(getDriver(), MenuScreenBase.class);
    }

    @Override
    public CartScreenBase clickOnCart() {
        cartIcon.click();
        return initPage(getDriver(), CartScreenBase.class);
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

    @Override
    public List<Double> removeDollarSymbol(List<ExtendedWebElement> originalList) {
        List<String> stringList = originalList.stream().map(e -> e.getText().replace("$ ", "")).collect(Collectors.toList());
        return stringList.stream().map(e -> Double.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public List<String> removeSpace() {
        List<ExtendedWebElement> list = createNameList();
        return list.stream().map(e -> e.getText().replace(" ", "")).collect(Collectors.toList());
    }

    @Override
    public List<String> turnIntoStringList(List<ExtendedWebElement> originalList) {
        return originalList.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    @Override
    public List<ExtendedWebElement> createList() {
        return pricesList;
    }

    @Override
    public List<ExtendedWebElement> createNamesList() {
        return namesList;
    }

    @Override
    public boolean isCatalogAscendingSorted(){
        List<Double> ascendingSortedList=removeDollarSymbol(createList());
        for (int i = 0; i < ascendingSortedList.size()-1; i++) {
            if (ascendingSortedList.get(i)<ascendingSortedList.get(i+1)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isCatalogDescendingSorted(){
        List<Double> ascendingSortedList=removeDollarSymbol(createList());
        for (int i = 0; i < ascendingSortedList.size()-1; i++) {
            if (ascendingSortedList.get(i)>ascendingSortedList.get(i+1)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAscendingNameSorted() {
        List<String> list= removeSpace();
        for (int i = 0; i < list.size() - 1; i++) {
            String current = list.get(i);
            String next = list.get(i + 1);
            if (current.compareTo(next) > 0) {
                return false; // If current > next, list is not in ascending order
            }
        }
        return true; // If loop completes, list is in ascending order
    }

    @Override
    public List<ExtendedWebElement> createNameList() {
        return name;
    }

    @Override
    public boolean isCatalogDescendingNameSorted() {
        List<String> namesList=turnIntoStringList(createNamesList());
        for (int i = 0; i < namesList.size()-1; i++) {
            if (namesList.get(i).compareTo(namesList.get(i+1))>0){
                return true;
            }
        }
        return false;
    }

//    @Override
//    public CartScreenBase clickOnCart() {
//       cartIcon.click();
//        return initPage(getDriver(), CartScreenBase.class);
//    }

    @Override
    public ProductScreenBase clickOnProduct() {
        products.get(0).click();
        return initPage(getDriver(), ProductScreenBase.class);
    }
}
