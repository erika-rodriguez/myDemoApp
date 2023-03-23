package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.WebViewScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewScreenBase.class)
public class WebViewScreen extends WebViewScreenBase {

    @FindBy(xpath = "//*[@resource-id='com.saucelabs.mydemoapp.android:id/webViewTV']")
    private ExtendedWebElement webViewTxt;

    public WebViewScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isWebViewTxtPresent() {
        return webViewTxt.isElementPresent();
    }
}
