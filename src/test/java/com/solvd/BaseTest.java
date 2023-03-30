package com.solvd;

import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class BaseTest extends AbstractPage {
    public BaseTest(WebDriver driver) {
        super(driver);
    }

    @BeforeMethod
    @Test(description = "[TC08]-testResetAppButton",dataProvider = "DataProvider")
    @CsvDataSourceParameters(path = "parallelDevices.csv", dsUid = "TUID")
    public void setCapabilities(HashMap<String,String> data){
        R.CONFIG.put("capabilities.deviceName", data.get("deviceName"), true);
        R.CONFIG.put("capabilities.platformVersion",data.get("platformVersion"), true);
        R.CONFIG.put("capabilities.platformName", data.get("platformName"), true);
        R.CONFIG.put("selenium_url", data.get("selenium_url"), true);
        R.CONFIG.put("capabilities.app", data.get("app"), true);
        R.CONFIG.put("capabilities.build", "Using_data_provider_thread_count", true);
        R.CONFIG.put("capabilities.name", "ios-training-cycle", true);
    }
}
