package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuBase extends AbstractPage {
    public MenuBase(WebDriver driver) {
        super(driver);
    }
    public abstract AboutOptionBase clickOnAboutOption();
}
