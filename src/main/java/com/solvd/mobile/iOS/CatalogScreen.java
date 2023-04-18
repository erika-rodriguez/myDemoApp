package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CartScreenBase;
import com.solvd.mobile.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement menuBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Products\"`]")
    private ExtendedWebElement products;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Button\"`]")
    private ExtendedWebElement sortingOrderButton;
    @FindBy(xpath = "//*[contains(@name, '$')]")
    private List<ExtendedWebElement> price;
    @FindBy(xpath = "//*[contains(@name, 'Sauce Lab')]")
    private List<ExtendedWebElement> name;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Sauce')]")
    private List<ExtendedWebElement>  namesList;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Linkedin Icons\"`]\n")
    private ExtendedWebElement linkedinIcon;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Cart-tab-item\"`]")
    private ExtendedWebElement cartIcon;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductItem\"`][1]")
    private ExtendedWebElement firstProduct;

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
    public List<String> removeSpace() {
        List<ExtendedWebElement> list = createNameList();
        return list.stream().map(e -> e.getText().replace(" ", "")).collect(Collectors.toList());
    }

    @Override
    public List<String> turnIntoStringList(List<ExtendedWebElement> originalList) {
        return originalList.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    @Override
    public List<ExtendedWebElement> createList() {
        return price;
    }

    @Override
    public List<ExtendedWebElement> createNamesList() {
        return namesList;
    }

    @Override
    public boolean isCatalogAscendingSorted() {
        List<Double> ascendingSortedList = removeDollarSymbol(createList());
        for (int i = 0; i < ascendingSortedList.size() - 1; i++) {
            if (ascendingSortedList.get(i) < ascendingSortedList.get(i + 1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAscendingNameSorted() {
        List<String> list = removeSpace();
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
    public boolean isCatalogDescendingSorted() {
        List<Double> ascendingSortedList = removeDollarSymbol(createList());
        for (int i = 0; i < ascendingSortedList.size() - 1; i++) {
            if (ascendingSortedList.get(i) > ascendingSortedList.get(i + 1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ExtendedWebElement> createNameList() {
        return name;
    }

    @Override
    public boolean isCatalogDescendingNameSorted() {
        List<String> namesList = turnIntoStringList(createNamesList());
        for (int i = 0; i < namesList.size() - 1; i++) {
            if (namesList.get(i).compareTo(namesList.get(i + 1)) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ProductScreenBase clickOnProduct() {
        firstProduct.click();
        return initPage(getDriver(), ProductScreenBase.class);
    }

    @Override
    public void clickOnStarReview() {

    }

    @Override
    public boolean isReviewSubmitted() {
        return false;
    }

    @Override
    public CartScreenBase clickOnCart() {
        cartIcon.click();
        return initPage(getDriver(), CartScreenBase.class);
    }
}
