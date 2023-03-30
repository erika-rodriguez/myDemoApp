package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.CsvDataSourceParameters;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class BaseTest extends AbstractPage implements IAbstractTest {


    static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

    public BaseTest(WebDriver driver) {
        super(driver);
    }



    public static byte[] getScreenshot() throws Exception
    {
        Calendar now = Calendar.getInstance();


        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        String fileName = formatter.format(now.getTime()) + ".jpg";
        ImageIO.write(screenShot, "JPG", new File("src/main/resources/screenshot/"+fileName));
        System.out.println(formatter.format(now.getTime()));
        ByteArrayOutputStream byteArray;
        try {
            BufferedImage toByteArray = ImageIO.read(new File("src/main/resources/screenshot/"+fileName));
            byteArray = new ByteArrayOutputStream();
            ImageIO.write(toByteArray, "JPG", byteArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArray.toByteArray();
    }

//    @BeforeClass
//    @Test(dataProvider = "DataProvider")
//    @CsvDataSourceParameters(path = "parallelDevices.csv", dsUid = "TUID")
//    public void setCapabilities(HashMap<String,String> data){
//        R.CONFIG.put("capabilities.deviceName", data.get("deviceName"), true);
//        R.CONFIG.put("capabilities.platformVersion",data.get("platformVersion"), true);
//        R.CONFIG.put("capabilities.platformName", data.get("platformName"), true);
//        R.CONFIG.put("selenium_url", data.get("selenium_url"), true);
//        R.CONFIG.put("capabilities.app", data.get("app"), true);
//        R.CONFIG.put("capabilities.build", "Using_data_provider_thread_count", true);
//        R.CONFIG.put("capabilities.name", "ios-training-cycle", true);
//    }
}
