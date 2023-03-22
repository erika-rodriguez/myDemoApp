package com.solvd.mobile.iOS;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobile.common.AboutAppScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = AboutAppScreenBase.class)
public class AboutAppScreen extends AboutAppScreenBase {

    @ExtendedFindBy(iosPredicate = "name == \"Robot Icons\"")
    private ExtendedWebElement image;
    public AboutAppScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSauceLabMascotPresent() {
        return image.isVisible();
    }
}
