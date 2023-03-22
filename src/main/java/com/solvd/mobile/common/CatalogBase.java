package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class CatalogBase extends AbstractPage implements IMobileUtils {
    public CatalogBase(WebDriver driver) {
        super(driver);
    }


}
