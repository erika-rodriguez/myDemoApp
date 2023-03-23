package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.DrawingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = DrawingScreenBase.class)
public class DrawingScreen extends DrawingScreenBase {
    @ExtendedFindBy(iosClassChain= "**/XCUIElementTypeStaticText[`label == \"Drawing\"`]")
    private ExtendedWebElement drawingTxt;
    public DrawingScreen(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isDrawingTxtPresent() {
        return drawingTxt.isElementPresent();
    }
}
