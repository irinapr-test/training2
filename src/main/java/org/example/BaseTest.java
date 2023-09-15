package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public static ChromeOptions options;
    public static String URL = "https://www.saucedemo.com/";

    protected static WebDriver driver1;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Iryna.Prankevich/Documents/chromedriver.exe");
       options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver1 = new ChromeDriver(options);
        wait = new WebDriverWait(driver1, Duration.ofSeconds(2));
        driver1.manage().window().maximize();
    }

    @AfterClass
    public static void teardown() {
        driver1.close();
        driver1.quit();
    }
}


 //    @BeforeClass
 //   public void setUpBrowser(){
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Iryna.Prankevich/Documents/chromedriver.exe");
//        options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
 ///          }




//    @AfterMethod(alwaysRun = true)
//    public void teardown() {
//        driver.close();
//        driver.quit();
//    }


