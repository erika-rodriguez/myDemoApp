package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginScreenBase extends AbstractPage {
    public LoginScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLoginTxtPresent();

    public abstract void setUsername(String username);
    public abstract void setPassword(String password);

    public abstract CatalogScreenBase clickOnLogin();
}


