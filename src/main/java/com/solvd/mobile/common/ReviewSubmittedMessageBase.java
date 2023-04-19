package com.solvd.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ReviewSubmittedMessageBase extends AbstractPage {
    public ReviewSubmittedMessageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isReviewSubmitted();
}
