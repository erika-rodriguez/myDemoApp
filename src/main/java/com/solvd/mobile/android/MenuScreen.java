package com.solvd.mobile.android;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = MenuScreenBase.class)
public class MenuScreen extends MenuScreenBase {
    @FindBy(xpath = "//*[@text='About']")
    private ExtendedWebElement aboutButton;
    @FindBy(xpath = "//*[@text='QR Code Scanner']")
    private ExtendedWebElement qrCodeBtn;
    @FindBy(xpath = "//*[@text='Geo Location']")
    private ExtendedWebElement geoLocationBtn;
    @FindBy(xpath = "//*[@text='WebView']")
    private ExtendedWebElement webViewBtn;

    public MenuScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public AboutAppScreenBase clickOnAboutButton() {
        aboutButton.click();
        return initPage(getDriver(), AboutAppScreenBase.class);

    }
    @Override
    public QRCodeScreenBase clickOnQRCodeButton() {
        qrCodeBtn.click();
        return initPage(getDriver(), QRCodeScreenBase.class);
    }

    @Override
    public GeoLocationScreenBase clickOnGeoLocationButton() {
        geoLocationBtn.click();
        return initPage(getDriver(), GeoLocationScreenBase.class);
    }

    @Override
    public WebViewScreenBase clickOnWebViewButton() {
        webViewBtn.click();
        return initPage(getDriver(), WebViewScreenBase.class);
    }

}
