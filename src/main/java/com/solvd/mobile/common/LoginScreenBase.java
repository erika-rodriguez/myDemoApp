package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginScreenBase extends AbstractPage {
    public LoginScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLoginTxtPresent();
    public abstract void selectUsers();
    public abstract CatalogScreenBase clickOnLogin();
}
