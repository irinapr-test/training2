package test.cucumber;

import core.BaseTest;
import cucumberClases.CredentialsCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import pages.MainProductsPage;
import test.E2ETest;

import static org.testng.AssertJUnit.assertTrue;
import static utils.UIPropertiesLoader.getShopURL;
import static utils.UIPropertiesLoader.getUserProperties;

public class E2EStepDefinitionImplementation extends CucumberTestRunnerTestNg {
    public static final String SHOP_URL = getShopURL();
    public static ChromeOptions options;
    public static WebDriver driver;
    public LoginPage loginPage;
     private final Logger logger = LoggerFactory.getLogger(E2ETest.class);
    private MainProductsPage mainPage;

    @Given("Page saucedemo is opened")
    public void page_saucedemo_is_opened(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(SHOP_URL);
        loginPage = new LoginPage(driver);
    }

    @Given("LogIn page is displayed with all elements")
    public void login_page_is_displayed_with_all_elements() {
        logger.info("verify login page elements");
        loginPage.verifyUIElementsOnLoginPage();
    }

    @When("^user is logged in with valid credentials (.+) and (.+)$")
    public void user_login_in_with_valid_credentials(String username, String password) {
        logger.info("log in with valid credentials");
        mainPage = loginPage.logInWith(username, password);
    }

    @Then("Main page with correct UI elements is displayed")
    public void main_page_with_UI_elements_is_displayed() {
        logger.info("main products page elements");
        mainPage.verifyMainProductsPageUiElements();
    }



}
