package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CartScreenBase;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.NoItemScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {
    @ExtendedFindBy(iosPredicate = "type == \"XCUIElementTypeCell\"")
    private ExtendedWebElement addedItem;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Remove Item\"`]")
    private ExtendedWebElement removeButton;

    @ExtendedFindBy(iosPredicate = "label == \"AddPlus Icons\"")
    private ExtendedWebElement plusbutton;

    @FindBy(xpath = "//*[contains(@name, '$')]")
    private List<ExtendedWebElement>price;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"2\"`][1]")
    private ExtendedWebElement productAmount;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Go Shopping\"`]")
    private ExtendedWebElement goShoppingBtn;

    @Override
    public NoItemScreenBase clickOnRemove() {
        removeButton.click();
        return initPage(getDriver(), NoItemScreenBase.class);
    }

    @Override
    public boolean isProductAdded() {
        return addedItem.isElementPresent();
    }

    @Override
    public void clickOnPlusButton() {
        plusbutton.click();
    }

    @Override
    public int calculatorSum() {
        String x = price.get(1).getText();
        String y = productAmount.getText();

        String y2 = y.replace("$ ", "").replace(".", "");
        String x2 = x.replace("$ ", "").replace(".", "");

        int price = Integer.parseInt(y2);
        int amount = Integer.parseInt(x2);

        return price*amount;
    }

    @Override
    public CatalogScreenBase clickOnGoShoppingBtn() {
        goShoppingBtn.click();
        return initPage(getDriver(),CatalogScreenBase.class);
    }


}
