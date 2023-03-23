package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.FingerPrintScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = FingerPrintScreenBase.class)
public class FingerPrintScreen extends FingerPrintScreenBase {
    @FindBy(xpath = "//*[@text='FingerPrint']")
    private ExtendedWebElement fingerPrintText;
    public FingerPrintScreen(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isFingerPrintTextPresent() {
        return fingerPrintText.isVisible();
    }
}
