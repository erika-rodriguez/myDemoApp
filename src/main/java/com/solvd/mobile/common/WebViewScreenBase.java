package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewScreenBase extends AbstractPage {
    public WebViewScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isWebViewTxtPresent();

}
