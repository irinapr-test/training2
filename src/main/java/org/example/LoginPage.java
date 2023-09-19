package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private By logo = By.cssSelector("div[class='login_logo']");
    private By loginForm = By.className("form_column");
    private By usernameField = By.name("user-name");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//input[@data-test='login-button']");
    private By login_credentials = By.id("login_credentials");
    private By login_password = By.className("login_password");
    private By errorMessage = By.cssSelector("h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyUIElementsOnLoginPage(){
        isDisplayed(logo);
        isDisplayed(loginForm);
        isDisplayed(usernameField);
        isDisplayed(passwordField);
        isDisplayed(loginButton);
        isDisplayed(login_credentials);
        isDisplayed(login_password);
    }

    public void setUserName (String username){
        type(username, usernameField);
    }

    public void setPassword(String password){
        type(password, passwordField);
    }

    public void logIntoShopWithUserNameAndPassword(String username, String password){
        setUserName(username);
        setPassword(password);
        driver.findElement(loginButton).click();
    }

    public MainProductsPage clickOnLoginButton(){
        click(loginButton);
        return new MainProductsPage(driver);
    }

    public MainProductsPage logInWith(String username, String password){
        setUserName(username);
        setPassword(password);
        return clickOnLoginButton();
    }

    public String getErrorMessageForLogIn(){
        return find(errorMessage).getText();
    }

}
