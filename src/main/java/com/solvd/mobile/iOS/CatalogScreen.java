package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.MenuScreenBase;
import com.solvd.mobile.common.SortingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement menuBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Products\"`]")
    private ExtendedWebElement products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Button\"`]")
    private ExtendedWebElement sortingOrderButton;

    @FindBy(xpath = "//*[contains(@name, '$')]")
    private List<ExtendedWebElement>  price;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Linkedin Icons\"`]\n")
    private ExtendedWebElement linkedinIcon;


    public CatalogScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public MenuScreenBase clickOnMenu() {
        menuBtn.click();
        return initPage(getDriver(), MenuScreenBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return products.isElementPresent();
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
    public List<String> turnIntoStringList(List<ExtendedWebElement> originalList) {
        return null;
    }

    @Override
    public List<ExtendedWebElement> createList() {
        return price;
    }

    @Override
    public List<ExtendedWebElement> createNamesList() {
        return null;
    }

    @Override
    public boolean isCatalogAscendingSorted() {
        List<Double> ascendingSortedList=removeDollarSymbol(createList());
        for (int i = 0; i < ascendingSortedList.size()-1; i++) {
            if (ascendingSortedList.get(i)<ascendingSortedList.get(i+1)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isCatalogDescendingSorted() {
        List<Double> ascendingSortedList=removeDollarSymbol(createList());
        for (int i = 0; i < ascendingSortedList.size()-1; i++) {
            if (ascendingSortedList.get(i)>ascendingSortedList.get(i+1)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isCatalogDescendingNameSorted() {
        return false;
    }
}
