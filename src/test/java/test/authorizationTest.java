package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.BurgerMenu;
import pages.MainProductsPage;

public class authorizationTest extends BaseTest {
    public final String USERNAME1 = "standard_user";
    public final String USERNAME2 = "locked_out_user";

    public final String PASSWORD = "secret_sauce";


    @Test
    public void authorizationTest() {
        //verify UI elements
        loginPage.verifyUIElementsOnLoginPage();

        //login without username and password
        loginPage.clickOnLoginButton();
         Assert.assertEquals(loginPage.getErrorMessageForLogIn(), "Epic sadface: Username is required");

        //login without username
        loginPage.closeErrorMessage();
        loginPage.setPassword(PASSWORD);
        loginPage.clickOnLoginButton();
        // somehow it's possible to log in
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(), "Epic sadface: Username is required");


        //log in with valid credentials
        MainProductsPage mainPage = loginPage.logInWith(USERNAME1, PASSWORD);
        //verify main products page elements
        mainPage.verifyMainProductsPageUiElements();
        //logout
        mainPage.logout();
        loginPage.verifyUIElementsOnLoginPage();

        //login without password
        loginPage.setUserName(USERNAME1);
        loginPage.clickOnLoginButton();
        //bug if it 's on line 31
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(), "Epic sadface: Password is required");

        //login with valid username and not valid password
        loginPage.logInWith(USERNAME1, "RANDOM" );
        loginPage.getErrorMessageForLogIn();
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(), "Epic sadface: Username and password do not match any user in this service", "error is not displayed");

        //login with valid username and password in UPPERCASE
        loginPage.logInWith(USERNAME1.toUpperCase(), PASSWORD.toUpperCase() );
        loginPage.getErrorMessageForLogIn();
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(), "Epic sadface: Username and password do not match any user in this service", "error is not displayed");

        //login with locked  username and valid password
        loginPage.logInWith(USERNAME2, PASSWORD);
        loginPage.getErrorMessageForLogIn();
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(), "Epic sadface: Sorry, this user has been locked out.");

        //login with locked  username and valid password
        loginPage.logInWith(USERNAME2, PASSWORD);
        loginPage.getErrorMessageForLogIn();
        Assert.assertEquals(loginPage.getErrorMessageForLogIn(), "Epic sadface: Sorry, this user has been locked out.");


    }


}
