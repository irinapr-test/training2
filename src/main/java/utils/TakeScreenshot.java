package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.BaseTest.driver;

public class TakeScreenshot {


    public void takeScreenShot(){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SourceFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("D:\\JAVA\\screenshot1.png");
        try {
            FileUtils.copyFile(SourceFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}