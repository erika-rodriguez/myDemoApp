package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.BiometricAlertScreenBase;
import com.solvd.mobile.common.FingerPrintScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = BiometricAlertScreenBase.class)
public class BiometricAlertScreen extends BiometricAlertScreenBase {

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okButton;

    public BiometricAlertScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public FingerPrintScreenBase clickOnOkButton() {
       okButton.click();
        return initPage(getDriver(), FingerPrintScreenBase.class);
    }
}
