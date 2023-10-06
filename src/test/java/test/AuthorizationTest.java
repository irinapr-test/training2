package test;

import core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.testng.Assert.*;
import static utils.UIPropertiesLoader.*;
import static utils.UIPropertiesLoader.getValidationMessage;

import org.testng.annotations.Test;
import pages.MainProductsPage;

public class AuthorizationTest extends BaseTest {
    public final String USERNAME1 = getUserProperties("USERNAME1");
    public final String USERNAME2 = getUserProperties("USERNAME2");
    private final Logger logger = LoggerFactory.getLogger(E2ETest.class);
    public final String PASSWORD = getUserProperties("PASSWORD");


    @Test
    public void authorizationTest() {

        logger.info("verify UI elements");
        loginPage.verifyUIElementsOnLoginPage();

        logger.info("login without username and passwords");
        loginPage.clickOnLoginButton();
        assertEquals(loginPage.getErrorMessageForLogIn(), getValidationMessage("USERNAME_REQUIRED"));

        logger.info("login without username");
        loginPage.closeErrorMessage();
        loginPage.setPassword(PASSWORD);
        loginPage.clickOnLoginButton();
        logger.info("somehow it's possible to log in");
        assertEquals(loginPage.getErrorMessageForLogIn(), getValidationMessage("USERNAME_REQUIRED"));

        logger.info("log in with valid credentials");
        MainProductsPage mainPage = loginPage.logInWith(USERNAME1, PASSWORD);
        logger.info("verify main products page elements");
        mainPage.verifyMainProductsPageUiElements();

        logger.info("logout");
        mainPage.logout();
        loginPage.verifyUIElementsOnLoginPage();


        logger.info("login without password");
        loginPage.setUserName(USERNAME1);
        loginPage.clickOnLoginButton();
        assertEquals(loginPage.getErrorMessageForLogIn(), getValidationMessage("PASSWORD_REQUIRED"));

        logger.info("login with valid username and not valid password");
        loginPage.logInWith(USERNAME1, "RANDOM");
        loginPage.getErrorMessageForLogIn();
        assertEquals(loginPage.getErrorMessageForLogIn(), getValidationMessage("USERNAME_PASSWORD_REQURIED"), "error is not displayed");

        logger.info("login with valid username and password in UPPERCASE");
        loginPage.logInWith(USERNAME1.toUpperCase(), PASSWORD.toUpperCase() );
        loginPage.getErrorMessageForLogIn();
        assertEquals(loginPage.getErrorMessageForLogIn(), getValidationMessage("USERNAME_PASSWORD_DOES_NOT_MATCH"), "error is not displayed");

        logger.info("login with locked  username and valid password");
        loginPage.logInWith(USERNAME2, PASSWORD);
        loginPage.getErrorMessageForLogIn();
        assertEquals(loginPage.getErrorMessageForLogIn(),  getValidationMessage("USER_LOCKED"));
    }


}
