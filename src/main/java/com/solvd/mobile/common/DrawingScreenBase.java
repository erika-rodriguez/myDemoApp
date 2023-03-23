package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingScreenBase extends AbstractPage {
    public DrawingScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDrawingTxtPresent();
}
