package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FaceIdScreenBase extends AbstractPage {
    public FaceIdScreenBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isFaceIdScreenOpened();
}
