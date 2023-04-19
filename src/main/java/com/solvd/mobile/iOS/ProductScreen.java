package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.ProductScreenBase;
import com.solvd.mobile.common.ReviewSubmittedMessageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Add To Cart\"`]")
    private ExtendedWebElement addToCartBtn;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"StarSelected Icons\"`][1]")
    private ExtendedWebElement oneStarBtn;
    @ExtendedFindBy(iosPredicate = "label == \"AddPlus Icons\"")
    private ExtendedWebElement plusButton;
    @ExtendedFindBy(iosPredicate = "name == \"Amount\"")
    private ExtendedWebElement amount;

    @ExtendedFindBy(iosPredicate = "label == \"BlueColorUnSelected Icons\"")
    private ExtendedWebElement blueButton;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
    }

    @Override
    public ReviewSubmittedMessageBase clickOneStarReview() {
        oneStarBtn.click();
        return initPage(getDriver(), ReviewSubmittedMessageBase.class);
    }

    @Override
    public void clickOnPlusButton() {
        plusButton.click();
    }

    @Override
    public int productAmount() {
        String x = amount.getText();
        int x1 = Integer.parseInt(x);
        return x1;
    }

    @Override
    public void clickOnBlueSelectionButton() {
        blueButton.click();
    }

    @Override
    public boolean isColorButtonSelected() {
        return blueButton.isElementPresent();
    }


}
