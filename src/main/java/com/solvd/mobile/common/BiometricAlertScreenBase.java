package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BiometricAlertScreenBase extends AbstractPage {
    public BiometricAlertScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract FingerPrintScreenBase clickOnOkButton();
}
