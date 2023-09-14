package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;


public class Navigation {
    public ChromeOptions options;
    public WebDriver driver;


    private static final String USERNAME_XPATH = "//input[@placeholder='Username']";
    private static final String PASSWORD_XPATH = "//input[@placeholder='Password']";
    private static final String LOGIN_BUTTON_XPATH = "//input[@data-test='login-button']";
    private static final String ADD_TO_CART_BUTTON_XPATH1 = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Add to cart')]";
    private static final String REMOVE_BUTTON_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Remove')]";
    private static final String PRICE_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price']";




    public Navigation() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Iryna.Prankevich/Documents/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public void navigateToShop(){
        driver.get("https://www.saucedemo.com/");
        boolean result = driver.getTitle().equals("Swag Labs");
        assert true;
        // Assert.isTrue(title == "Swag Labs", "page is not opened");
    }

    //loigin
    public void logIntoShopWithUserNameAndPassword(String username, String password){
         driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(username);
         driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(password);
         driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
         boolean result = driver.getCurrentUrl().equals("Swag Labs");
         assert true;
    }

    //main page
       public void clickOnAddToCartButtonForItem(String itemName){
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH1, itemName))).click();
        boolean result = driver.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemName))).isDisplayed();
        assert result;
    }

    public void clickOnRemoveButtonForItem(String itemName){
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemName))).click();
        boolean result = driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH1, itemName))).isDisplayed();
    }

      public Double returnItemPrice(String itemName) {
        String priceString = driver.findElement(By.xpath(String.format(PRICE_XPATH, itemName))).getText();
        Double price = extractDouble2(priceString);
        return price;
    }


        static Double extractDouble2(String str)
    {
        Double price = Double.valueOf(0);
        str = str.replaceAll("[^0-9]", " ");
        str = str.replaceAll(" +", " ");
        if (str.equals(""));
        Scanner scanner = new Scanner(str);
        Double  dollars = Double.valueOf(scanner.nextInt());
        Double  cents = Double.valueOf(scanner.nextInt());
        price = cents/100 + dollars;
        return price;
    }

    public void clickOnCart (){
        driver.findElement(By.className("shopping_cart_container")).click();
    }

    public Integer getCartValue (){
        return Integer.parseInt(driver.findElement(By.className("shopping_cart_badge")).getText());
    }

    //cart page
       public void verifyThatProductIsDisplayedInCart(){
           driver.findElement()
       }



}
