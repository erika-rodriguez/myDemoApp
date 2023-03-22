package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.QRCodeScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = QRCodeScreenBase.class)
public class QRCodeScreen extends QRCodeScreenBase {
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/qrCodeTV")
    private ExtendedWebElement qrCodeTxt;

    public QRCodeScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isQRCodeTxtVisible() {
        return qrCodeTxt.isVisible();
    }
}
