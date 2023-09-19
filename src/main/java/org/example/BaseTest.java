package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    private final String URL = "https://www.saucedemo.com/";
    WebDriver driver;

    @BeforeClass
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Iryna.Prankevich/Documents/chromedriver.exe");
       // WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
       // driver.get("URL");
    }

   // @AfterClass
 //   static void quitBrowser() {
      //  driver.quit();
  //  }
    //  System.setProperty("webdriver.chrome.driver", "C:/Users/Iryna.Prankevich/Documents/chromedriver.exe");
    //        options = new ChromeOptions();
    //        options.addArguments("--remote-allow-origins=*");
    //        driver = new ChromeDriver(options);
}

