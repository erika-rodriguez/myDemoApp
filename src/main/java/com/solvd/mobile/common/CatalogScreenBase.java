package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class CatalogScreenBase extends AbstractPage implements IMobileUtils {

    public CatalogScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuScreenBase clickOnMenu();

    public abstract boolean isPageOpened();
}
