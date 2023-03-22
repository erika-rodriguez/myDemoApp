package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class AboutAppScreenBase extends AbstractPage {
    public AboutAppScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSauceLabMascotPresent();
}
