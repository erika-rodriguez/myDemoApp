package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.FaceIdScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = FaceIdScreenBase.class)
public class FaceIdScreen extends FaceIdScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Face ID\"`]")
    private ExtendedWebElement faceIdText;
    public FaceIdScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFaceIdScreenOpened() {
        return faceIdText.isElementPresent();
    }
}
