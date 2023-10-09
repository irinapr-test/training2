package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.LoginPage;

import static utils.UIPropertiesLoader.getShopURL;


public class BaseTest {
    private static final String SHOP_URL = getShopURL();
    public static ChromeOptions options;
    public static WebDriver driver;
    protected LoginPage loginPage;

     @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(SHOP_URL);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
        System.out.println("test has been executed");
    }
}

