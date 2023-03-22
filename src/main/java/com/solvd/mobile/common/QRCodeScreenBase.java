package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class QRCodeScreenBase extends AbstractPage {
    public QRCodeScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isQRCodeTxtVisible();
}
