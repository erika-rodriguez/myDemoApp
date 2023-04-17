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

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"More-tab-item\"`]")
    private ExtendedWebElement menuBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Products\"`]")
    private ExtendedWebElement products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Button\"`]")
    private ExtendedWebElement sortingOrderButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=contains(.,'$')]")
    private ExtendedWebElement price;
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
        return null;
    }

    @Override
    public List<String> turnIntoStringList(List<ExtendedWebElement> originalList) {
        return null;
    }

    @Override
    public List<ExtendedWebElement> createList() {
        return null;
    }

    @Override
    public List<ExtendedWebElement> createNamesList() {
        return null;
    }

    @Override
    public boolean isCatalogAscendingSorted() {
        return false;
    }

    @Override
    public boolean isCatalogDescendingSorted() {
        return false;
    }

    @Override
    public boolean isCatalogDescendingNameSorted() {
        return false;
    }
}
