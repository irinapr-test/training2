package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import static utils.UIPropertiesLoader.getShopURL;


public class BaseTest {
    // TODO let's think about transfering this address into a resource file.
    private static final String SHOP_URL = getShopURL();
    public static ChromeOptions options;
    public static WebDriver driver;


    protected LoginPage loginPage;

    //TODO let's see if we can find a solution for chromedriver to be included in the project
    //     either way, it should have a relative path to the project, not something with c:\\users\\ etc..
    @BeforeClass
    public void setUp()  {
          System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(SHOP_URL);
        loginPage = new LoginPage(driver);
    }

    //TODO this should be public, that's why it doesn't work. And I think we should also remove static
    @AfterClass
    public void quitBrowser() {
        driver.quit();
        System.out.println("test has been executed");
    }
}

