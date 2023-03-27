package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.ResetAppScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ResetAppScreenBase.class)
public class ResetAppScreen extends ResetAppScreenBase{
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Reset App State\"`][2]")
    private ExtendedWebElement resetAlertTxt;
    public ResetAppScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isResetAlertShown() {
        return resetAlertTxt.isElementPresent();
    }
}
