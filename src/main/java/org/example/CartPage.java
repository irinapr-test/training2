package org.example;

import org.openqa.selenium.By;
import java.util.Scanner;

public class CartPage {
    //cart
    private static final String CONTINUE_SHOPPING_BUTTON_XPATH = "//button[text()='Continue Shopping']";
    private static final String CHECKOUT_BUTTON_XPATH = "//button[text()='Checkout']";
    private static final String CART_ITEM_NAME_XPATH = "//div[@class='inventory_item_name' and text()='%s']";
    private static final String CART_ITEM_QUANTITY_XPATH = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']";
    private static final String PRICE_XPATH_ON_CART= "//div[@class='inventory_item_name' and contains(text(),'%s')]/ancestor::div[@class='cart_item_label']/descendant::div[@class='inventory_item_price']";


    //Checkout: Overview
    private static final String SUMMARY_INFO_ITEM_XPATH= "//div[contains(text(),'%s')]";

    public MainPage mainPage;

//
//    //cart page
//    public void verifyUIElementsOnCartPage(){
//        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
//        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Your Cart"));
//        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("shopping_cart_container")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("cart_list")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("cart_quantity_label")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("cart_desc_label")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(CONTINUE_SHOPPING_BUTTON_XPATH)).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(CHECKOUT_BUTTON_XPATH)).isDisplayed());
//    }
//
//    public void verifyThatProductIsDisplayedInCart(String itemName, String quantity, String price){
//        Assert.assertTrue(driver.findElement(By.xpath(String.format(CART_ITEM_NAME_XPATH, itemName))).isDisplayed());
//        String itemPrice = returnItemPriceOnCart(itemName).toString();
//        Assert.assertTrue(itemPrice.equals(price));
//        Assert.assertTrue(driver.findElement(By.xpath(String.format(CART_ITEM_QUANTITY_XPATH, itemName))).getText().equals(quantity));
//    }
//
//    public Double returnItemPriceOnCart(String itemName) {
//        String priceString = driver.findElement(By.xpath(String.format(PRICE_XPATH_ON_CART, itemName))).getText();
//        Double price = extractDouble3(priceString);
//        return price;
//    }
//    public void clickOnContinueShoppingButton (){
//        driver.findElement(By.xpath(CONTINUE_SHOPPING_BUTTON_XPATH)).click();
//        mainPage.verifyUIElementsOnMainPage();
//    }
//
//    public void clickOnCheckoutButton (){
//        driver.findElement(By.xpath(CHECKOUT_BUTTON_XPATH)).click();
//    }
//
//    public void verifyUIElementsOnCheckoutPage(){
//        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
//        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Checkout: Your Information"));
//        Assert.assertTrue(driver.findElement(By.className("checkout_info")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("firstName")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("lastName")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("postalCode")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("cancel")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("continue")).isDisplayed());
//    }
//
//    public void addUserInfoAddContinue(String firstName, String lastName, String zipCode){
//        driver.findElement(By.name("firstName")).sendKeys(firstName);
//        driver.findElement(By.name("lastName")).sendKeys(lastName);
//        driver.findElement(By.name("postalCode")).sendKeys(zipCode);
//        driver.findElement(By.name("continue")).click();
//    }
//
//    public void verifyUIElementsOnCheckoutOverView(){
//        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
//        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Checkout: Overview"));
//        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("shopping_cart_container")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("cart_list")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("cart_quantity_label")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("cart_desc_label")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Payment Information"))).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Shipping Information"))).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Price Total"))).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Total:"))).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("cancel")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.name("finish")).isDisplayed());
//    }
//
//
//    public void verifyItemTotal(String expectedItemTotal){
//        String priceString = driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Item total:"))).getText();
//        Double price = extractDouble3(priceString);
//        Assert.assertEquals(expectedItemTotal, price.toString());
//    }
//
//    public void verifyTotalPrice(Double expectedItemTotal){
//        String getActualTotal = driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Total:"))).getText();
//        Double actualTotal = extractDouble3(getActualTotal);
//        String getActualTax= driver.findElement(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Tax: "))).getText();
//        Double taxprice = extractDouble3(getActualTax);
//        Assert.assertEquals(taxprice + expectedItemTotal, actualTotal);
//    }
//
//
//    public void verifyUIElementsOnFinishPage(){
//        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
//        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Checkout: Complete!"));
//        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("complete-header")).getText().equals("Thank you for your order!"));
//        Assert.assertTrue(driver.findElement(By.name("back-to-products")).isDisplayed());
//    }
//
//    static Double extractDouble3(String str)
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

}
