package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.w3c.dom.html.HTMLImageElement;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Navigation {
//    public ChromeOptions options;
//    public WebDriver driver;
     protected static WebDriver driver1;


    private static final String USERNAME_XPATH = "//input[@placeholder='Username']";
    private static final String PASSWORD_XPATH = "//input[@placeholder='Password']";
    private static final String LOGIN_BUTTON_XPATH = "//input[@data-test='login-button']";


    public Navigation() {
        driver1 = new ChromeDriver();

    }

    public void verifyUIElementsOnLoginPage(){
        Assert.assertTrue(driver1.findElement(By.cssSelector("div[class='login_logo']")).isDisplayed());
        Assert.assertTrue(driver1.findElement(By.className("form_column")).isDisplayed());
        Assert.assertTrue(driver1.findElement(By.xpath(USERNAME_XPATH)).isDisplayed());
        Assert.assertTrue(driver1.findElement(By.xpath(PASSWORD_XPATH)).isDisplayed());
        Assert.assertTrue(driver1.findElement(By.xpath(LOGIN_BUTTON_XPATH)).isDisplayed());
        Assert.assertTrue(driver1.findElement(By.id("login_credentials")).isDisplayed());
        Assert.assertTrue(driver1.findElement(By.className("login_password")).isDisplayed());
    }


//    //loigin
//    public void logIntoShopWithUserNameAndPassword(String username, String password){
//        driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(username);
//        driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(password);
//        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
//    }
//
//    //main page
//    public void verifyUIElementsOnMainPage(){
//        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
//        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Products"));
//        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("shopping_cart_container")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("product_sort_container")).isDisplayed());
//    }
//
//        static Double extractDouble2(String str)
//    {
//        Double price = Double.valueOf(0);
//        str = str.replaceAll("[^0-9]", " ");
//        str = str.replaceAll(" +", " ");
//        if (str.equals(""));
//        Scanner scanner = new Scanner(str);
//        Double  dollars = Double.valueOf(scanner.nextInt());
//        Double  cents = Double.valueOf(scanner.nextInt());
//        price = cents/100 + dollars;
//        return price;
//    }
//
//    public void clickOnCart (){
//        driver.findElement(By.className("shopping_cart_container")).click();
//    }
//
//    public String getCartValue (){
//        return driver.findElement(By.className("shopping_cart_badge")).getText();
//    }
//
//
//    //burger
//
//    public void clickOnBurgerMenu()  {
//        driver.findElement(By.id("react-burger-menu-btn")).click();
//    }
//


}
