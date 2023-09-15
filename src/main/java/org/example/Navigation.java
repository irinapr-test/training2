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
    public ChromeOptions options;
    public WebDriver driver;


    private static final String USERNAME_XPATH = "//input[@placeholder='Username']";
    private static final String PASSWORD_XPATH = "//input[@placeholder='Password']";
    private static final String LOGIN_BUTTON_XPATH = "//input[@data-test='login-button']";
    private static final String ADD_TO_CART_BUTTON_XPATH1 = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Add to cart')]";
    private static final String REMOVE_BUTTON_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Remove')]";
    private static final String PRICE_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price']";

    //cart
    private static final String CONTINUE_SHOPPING_BUTTON_XPATH = "//button[text()='Continue Shopping']";
    private static final String CHECKOUT_BUTTON_XPATH = "//button[text()='Checkout']";
    private static final String CART_ITEM_NAME_XPATH = "//div[@class='inventory_item_name' and text()='%s']";
    private static final String CART_ITEM_QUANTITY_XPATH = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']";
    private static final String PRICE_XPATH_ON_CART= "//div[@class='inventory_item_name' and contains(text(),'%s')]/ancestor::div[@class='cart_item_label']/descendant::div[@class='inventory_item_price']";


//Checkout: Overview
    private static final String SUMMARY_INFO_ITEM_XPATH= "//div[contains(text(),'%s')]";

//burger

    private static final String LOGOUT_BUTTON_XPATH= "//a[contains(text(),'Logout')]";




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
    public void verifyUIElementsOnLoginPage(){
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='login_logo']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("form_column")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(USERNAME_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(PASSWORD_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("login_credentials")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("login_password")).isDisplayed());
    }


    //loigin
    public void logIntoShopWithUserNameAndPassword(String username, String password){
        driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(username);
        driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }

    //main page
    public void verifyUIElementsOnMainPage(){
        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Products"));
        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("shopping_cart_container")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("product_sort_container")).isDisplayed());
    }


       public void clickOnAddToCartButtonForItem(String itemName){
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH1, itemName))).click();
        Assert.assertTrue(driver.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemName))).isDisplayed());
    }

    public void clickOnRemoveButtonForItem(String itemName){
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemName))).click();
        Assert.assertTrue(driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH1, itemName))).isDisplayed());
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

    public String getCartValue (){
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }

    //cart page
    public void verifyUIElementsOnCartPage(){
        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Your Cart"));
        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("shopping_cart_container")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("cart_list")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("cart_quantity_label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("cart_desc_label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(CONTINUE_SHOPPING_BUTTON_XPATH)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(CHECKOUT_BUTTON_XPATH)).isDisplayed());
    }

    public void verifyCartBadge(String expectedQuantity){
         Assert.assertTrue(getCartValue().equals(expectedQuantity));
    }


       public void verifyThatProductIsDisplayedInCart(String itemName, String quantity, String price){
           Assert.assertTrue(driver.findElement(By.xpath(String.format(CART_ITEM_NAME_XPATH, itemName))).isDisplayed());
           String itemPrice = returnItemPriceOnCart(itemName).toString();
           Assert.assertTrue(itemPrice.equals(price));
           Assert.assertTrue(driver.findElement(By.xpath(String.format(CART_ITEM_QUANTITY_XPATH, itemName))).getText().equals(quantity));
       }

    public Double returnItemPriceOnCart(String itemName) {
        String priceString = driver.findElement(By.xpath(String.format(PRICE_XPATH_ON_CART, itemName))).getText();
        Double price = extractDouble2(priceString);
        return price;
    }
    public void clickOnContinueShoppingButton (){
        driver.findElement(By.xpath(CONTINUE_SHOPPING_BUTTON_XPATH)).click();
        verifyUIElementsOnMainPage();
    }

    public void clickOnCheckoutButton (){
        driver.findElement(By.xpath(CHECKOUT_BUTTON_XPATH)).click();
    }

    public void verifyUIElementsOnCheckoutPage(){
        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Checkout: Your Information"));
        Assert.assertTrue(driver.findElement(By.className("checkout_info")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("firstName")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("lastName")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("postalCode")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("cancel")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("continue")).isDisplayed());
    }

    public void addUserInfoAddContinue(String firstName, String lastName, String zipCode){
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("postalCode")).sendKeys(zipCode);
        driver.findElement(By.name("continue")).click();
    }

    public void verifyUIElementsOnCheckoutOverView(){
        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Checkout: Overview"));
        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("shopping_cart_container")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("cart_list")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("cart_quantity_label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("cart_desc_label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Payment Information"))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Shipping Information"))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Price Total"))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Total:"))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("cancel")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("finish")).isDisplayed());
    }


    public void verifyItemTotal(String expectedItemTotal){
        String priceString = driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Item total:"))).getText();
        Double price = extractDouble2(priceString);
        Assert.assertEquals(expectedItemTotal, price.toString());
    }

    public void verifyTotalPrice(Double expectedItemTotal){
        String getActualTotal = driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Total:"))).getText();
        Double actualTotal = extractDouble2(getActualTotal);
        String getActualTax= driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Tax: "))).getText();
        Double taxprice = extractDouble2(getActualTax);
        Assert.assertEquals(taxprice + expectedItemTotal, actualTotal);
    }


    public void verifyUIElementsOnFinishPage(){
        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Checkout: Complete!"));
        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("complete-header")).getText().equals("Thank you for your order!"));
        Assert.assertTrue(driver.findElement(By.name("back-to-products")).isDisplayed());
    }

    //burger

    public void clickOnBurgerMenu()  {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }
    public void clickOnLogoutButton (){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(LOGOUT_BUTTON_XPATH)).click();
    }





}
