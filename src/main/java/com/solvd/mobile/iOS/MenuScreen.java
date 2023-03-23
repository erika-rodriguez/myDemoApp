package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.AboutAppScreenBase;
import com.solvd.mobile.common.GeoLocationScreenBase;
import com.solvd.mobile.common.MenuScreenBase;
import com.solvd.mobile.common.QRCodeScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = MenuScreenBase.class)
public class MenuScreen extends MenuScreenBase{
    @ExtendedFindBy(iosPredicate = "name == \"QrCodeScanner-menu-item\"")
    private ExtendedWebElement qrCodeBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"About-menu-item\"`]")
    private ExtendedWebElement aboutButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"GeoLocation-menu-item\"`]")
    private ExtendedWebElement geoLocationBtn;

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
}
