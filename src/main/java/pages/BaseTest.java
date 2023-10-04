package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    // TODO let's think about transfering this address into a resource file.
    private static final String SHOP_URL = "https://www.saucedemo.com/";

    public static ChromeOptions options;
    public static WebDriver driver;
    protected LoginPage loginPage;

    //TODO let's see if we can find a solution for chromedriver to be included in the project
    //     either way, it should have a relative path to the project, not something with c:\\users\\ etc..
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Iryna.Prankevich/Documents/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(SHOP_URL);

        loginPage = new LoginPage(driver);
        System.out.println("the shop page is opened " + SHOP_URL);

    }
    //TODO this should be public, that's why it doesn't work. And I think we should also remove static
   @AfterClass
     static void quitBrowser() {
        driver.quit();
       System.out.println("test has been executed");
   }

}

