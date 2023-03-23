package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.DrawingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = DrawingScreenBase.class)
public class DrawingScreen extends DrawingScreenBase{
    @FindBy(xpath = "//*[@resource-id='com.saucelabs.mydemoapp.android:id/drawingTV']")
    private ExtendedWebElement drawingTxt;
    public DrawingScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDrawingTxtPresent() {
        return drawingTxt.isElementPresent();
    }
}
