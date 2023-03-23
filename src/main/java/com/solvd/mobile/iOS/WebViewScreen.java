package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.WebViewScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewScreenBase.class)
public class WebViewScreen extends WebViewScreenBase{
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Webview\"`]")
    private ExtendedWebElement webViewTxt;

    public WebViewScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isWebViewTxtPresent() {
        return webViewTxt.isVisible();
    }
}
