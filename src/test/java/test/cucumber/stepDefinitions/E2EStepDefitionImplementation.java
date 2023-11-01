package test.cucumber.stepDefinitions;

import core.BaseTest;
import cucumberClases.CredentialsCucumber;
import cucumberClases.ProductCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import pages.MainProductsPage;
import pages.ProductPage;
import test.E2ETest;

import static org.testng.AssertJUnit.assertTrue;
import static utils.UIPropertiesLoader.getUserProperties;

public class E2EStepDefitionImplementation extends BaseTest {

    public final String USERNAME = getUserProperties("USERNAME1");
    public final String PASSWORD = getUserProperties("PASSWORD");
    private final String PRODUCT_NAME_1 = "Sauce Labs Backpack";
    private final String PRODUCT_PRICE_1 = "29.99";
    private final Logger logger = LoggerFactory.getLogger(E2ETest.class);
    private MainProductsPage mainPage;
    private CredentialsCucumber credentials;
    public LoginPage loginPage;

    @Given("Page saucedemo is opened")
    public void page_saucedemo_is_opened(){
        loginPage = setUp();
    }

    @Given("LogIn page is displayed with all elements")
    public void login_page_is_displayed_with_all_elements() {
        logger.info("verify login page elements");
        loginPage.verifyUIElementsOnLoginPage();
    }

    @When("user is logged in with valid credentials {username} and {password}")
    public void user_login_in_with_valid_credentials(String username, String password) {
        logger.info("log in with valid credentials");
        //credentials = new CredentialsCucumber(username, password);
        mainPage = loginPage.logInWith(username, password);
    }

    @Then("Main page with correct UI elements is displayed")
    public void main_page_with_UI_elements_is_displayed() {
        logger.info("main products page elements");
        mainPage.verifyMainProductsPageUiElements();
    }



}
