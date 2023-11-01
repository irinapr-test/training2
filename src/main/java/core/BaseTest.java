package core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

import static utils.UIPropertiesLoader.getShopURL;


public class BaseTest {
    public static final String SHOP_URL = getShopURL();
    public static ChromeOptions options;
    public static WebDriver driver;
    public LoginPage loginPage;

   @BeforeClass
    public LoginPage setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(SHOP_URL);
        return loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
        System.out.println("test has been executed");
    }

    @AfterMethod
    public void takeScreenshotForFailures(ITestResult testResult){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        if(ITestResult.FAILURE == testResult.getStatus()) {
            File destination = new File("D:\\JAVA\\New\\" + testResult.getName() + "_Failed.png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(ITestResult.SUCCESS == testResult.getStatus()) {
            File destination = new File("D:\\JAVA\\New\\" + testResult.getName() + "_Success.png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }
    }
}

