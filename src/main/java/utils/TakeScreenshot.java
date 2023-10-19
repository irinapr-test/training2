package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.BaseTest.driver;
import static java.lang.System.getProperty;

public class TakeScreenshot {

    public void takeScreenShot(String testName){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SourceFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(getProperty("SCREENSHOT_LOCATION") + testName + ".png");
        try {
            FileUtils.copyFile(SourceFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}