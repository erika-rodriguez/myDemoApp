package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.QRCodeScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = QRCodeScreenBase.class)
public class QRCodeScreen extends QRCodeScreenBase {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"QR Code Scanner\"`]")
    private ExtendedWebElement qrCodeTxt;

    public QRCodeScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isQRCodeTxtVisible() {
        return qrCodeTxt.isVisible();
    }
}
