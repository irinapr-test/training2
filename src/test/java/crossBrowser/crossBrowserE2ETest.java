package crossBrowser;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.*;

import static utils.UIPropertiesLoader.getShopURL;

public class crossBrowserE2ETest {
    private static final String SHOP_URL = getShopURL();
    protected LoginPage loginPage;
    public static WebDriver driver;

    private final Logger logger = LoggerFactory.getLogger(test.E2ETest.class);

    private final String PRODUCT_NAME_1 = "Sauce Labs Backpack";
    private final String PRODUCT_PRICE_1 = "29.99";
    private final String PRODUCT_PRICE_2 = "9.99";
    private final String PRODUCT_NAME_2 = "Sauce Labs Bike Light";
    private final String PRODUCT_NAME_3 = "Sauce Labs Bolt T-Shirt";

    @BeforeTest
    @Parameters("browser")
    public void initialize(String browser) {
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(edgeOptions);
        } else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
        }
                driver.get(SHOP_URL);
                loginPage = new LoginPage(driver);
              }

    @Test
    public void crossBrowserE2ETest() {
        //TODO let's remove all the commented lines and implement a logger, like log4j, and log that instead.
        logger.info("verify login page elements");
        loginPage.verifyUIElementsOnLoginPage();

        logger.info("log in with valid credentials");
        MainProductsPage mainPage = loginPage.logInWith("standard_user", "secret_sauce");

        logger.info("main products page elements");
        mainPage.verifyMainProductsPageUiElements();

        logger.info("click on product item");
        ProductPage productPage = mainPage.clickOnProduct(PRODUCT_NAME_1);

        logger.info("verify product is displayed");
        productPage.verifyProductPageUiElements(PRODUCT_NAME_1, PRODUCT_PRICE_1);

        logger.info("click on Add to cart and verify that remove button is displayed");
        productPage.clickOnAddToCart();

        logger.info("click on Remove and verify that Add to cart  button is displayed");
        productPage.clickOnRemove();
        logger.info("click on Add to cart");
        productPage.clickOnAddToCart();
        logger.info("click on back to products");
        productPage.clickOnBackToProducts();

        logger.info("verify cart value");
        mainPage.verifyCartBadge("1");
        mainPage.clickOnAddToCartButtonForItem(PRODUCT_NAME_2);
        mainPage.clickOnAddToCartButtonForItem(PRODUCT_NAME_3);
        mainPage.verifyCartBadge("3");

        logger.info("remove one item");
        mainPage.clickOnRemoveButtonForItem(PRODUCT_NAME_3);
        logger.info("verify cart value");
        mainPage.verifyCartBadge("2");

        logger.info("get selected items price");
        Double price1 = mainPage.getProductPrice(PRODUCT_NAME_1);
        Double price2 = mainPage.getProductPrice(PRODUCT_NAME_2);
        Double sum = price1 + price2;

        logger.info("go to cart");
        CartPage cartPage = mainPage.clickOnCart();
        logger.info("verify ui elements and selected products");
        cartPage.verifyUIElementsOnCartPage();
        cartPage.verifyThatProductIsDisplayedInCart(PRODUCT_NAME_1, "1", PRODUCT_PRICE_1);
        cartPage.verifyThatProductIsDisplayedInCart(PRODUCT_NAME_2, "1", PRODUCT_PRICE_2);

        logger.info("verify that Continue Shopping Button redirects to main page");
        cartPage.clickOnContinueShoppingButton();
        mainPage.verifyMainProductsPageUiElements();

        //go back to cart
        mainPage.clickOnCart();
        logger.info("click on checkout button and verify Checkout: Your Information UI elements");
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutShoppingButton();
        checkoutPage.verifyUIElementsOnCheckoutPage();
        logger.info("click on cancel button verify that user is on cart page");
        checkoutPage.clickOnCancelButton();
        cartPage.verifyUIElementsOnCartPage();

        logger.info("click on checkout button");
        cartPage.clickOnCheckoutShoppingButton();

        logger.info("input user data, click Continue and verify Checkout: Overview UI elements");
        checkoutPage.addUserInfoAndContinue("s", "s", "s");
        checkoutPage.verifyUIElementsOnCheckoutOverView();

        logger.info("verify that selected products and the Total: price");
        checkoutPage.verifyThatProductIsDisplayedInCart(PRODUCT_NAME_1, "1");
        checkoutPage.verifyThatProductIsDisplayedInCart(PRODUCT_NAME_2, "1");
        checkoutPage.verifyTotalPrice(sum);

        logger.info("click on finish button and verify finish prompt");
        checkoutPage.clickOnFinishButton();
        checkoutPage.verifyUIElementsOnFinishPage();
        logger.info("click on go back button and verify that the main page is displayed");
        checkoutPage.clickOnBackToProductsButton();
        mainPage.verifyMainProductsPageUiElements();

        logger.info("logout");
        mainPage.logout();
        loginPage.verifyUIElementsOnLoginPage();

    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
        System.out.println("test has been executed");
    }

}
