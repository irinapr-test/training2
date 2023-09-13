package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Navigation {
    public ChromeOptions options;
    public WebDriver driver;
    public WebElement usernameField, passwordField, loginButton;

    private static final String USERNAME_XPATH = "//input[@placeholder='Username']";
    private static final String PASSWORD_XPATH = "//input[@placeholder='Password']";
    private static final String LOGIN_BUTTON_XPATH = "//input[@data-test='login-button']";



    public Navigation() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Iryna.Prankevich/Documents/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public void navigateToShop(){
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        // Assert.isTrue(title == "Swag Labs", "page is not opened");
    }
    public void inputUserNameAndPassword(String username, String password){
        navigateToShop();
         driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(username);
         driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(password);
         driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }
    public void logIntoShop(String username, String password){
        inputUserNameAndPassword(username, password);
        String url = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl + "   " + url );
       // Assert.isTrue(url == actualUrl, "wrong page is not opened");
    }
    
}
