package com.solvd.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobile.common.ReviewSubmittedMessageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ReviewSubmittedMessageBase.class)
public class ReviewSubmittedMessage extends ReviewSubmittedMessageBase {
    @FindBy(id = "com.saucelabs.mydemoapp.android:id/sortTV")
    private ExtendedWebElement reviewSubmittedTxt;
    public ReviewSubmittedMessage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isReviewSubmitted() {
        return reviewSubmittedTxt.isElementPresent();
    }
}
