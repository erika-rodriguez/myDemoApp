package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.CartScreenBase;
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
    private List<ExtendedWebElement>calculatorResult;

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
    public boolean isCalculatorWorking() {
        String x = calculatorResult.get(0).getText();
        System.out.println(x.toString());
        String updatedResult = x.replace("$", "").replace(".", "");
        int s2 = Integer.parseInt(updatedResult);
        int s1 = 5998;
        if (s1 == s2) {
            return true;
        }
        return false;
    }


}
