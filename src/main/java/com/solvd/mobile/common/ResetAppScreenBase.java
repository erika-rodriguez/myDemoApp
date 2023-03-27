package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ResetAppScreenBase extends AbstractPage {
    public ResetAppScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isResetAlertShown();
}
