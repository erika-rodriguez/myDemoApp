package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.ReviewSubmittedMessageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ReviewSubmittedMessageBase.class)
public class ReviewSubmittedMessage extends ReviewSubmittedMessageBase {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Thank you for submitting your review!\"`]")
    private ExtendedWebElement reviewSubmittedTxt;
    public ReviewSubmittedMessage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean isReviewSubmitted() {
        return reviewSubmittedTxt.isElementPresent();
    }
}
