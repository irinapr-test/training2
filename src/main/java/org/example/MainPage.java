package org.example;

import org.openqa.selenium.By;

import java.util.Scanner;

public class MainPage extends BaseTest  {
   // public static void main(String[] args) {
   //     System.out.println("Hello world!");

    private static final String ADD_TO_CART_BUTTON_XPATH1 = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Add to cart')]";
    private static final String REMOVE_BUTTON_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Remove')]";
    private static final String PRICE_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price']";


//    public void verifyUIElementsOnMainPage(){
//        Assert.assertTrue(driver.findElement(By.className("app_logo")).getText().equals("Swag Labs"));
//        Assert.assertTrue(driver.findElement(By.className("title")).getText().equals("Products"));
//        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("shopping_cart_container")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("product_sort_container")).isDisplayed());
//    }
//
//
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
//    public void clickOnAddToCartButtonForItem(String itemName){
//        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH1, itemName))).click();
//        Assert.assertTrue(driver.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemName))).isDisplayed());
//    }
//
//    public void clickOnRemoveButtonForItem(String itemName){
//        driver.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemName))).click();
//        Assert.assertTrue(driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH1, itemName))).isDisplayed());
//    }
//
//    public Double returnItemPrice(String itemName) {
//        String priceString = driver.findElement(By.xpath(String.format(PRICE_XPATH, itemName))).getText();
//        Double price = extractDouble2(priceString);
//        return price;
//    }
//    public void verifyCartBadge(String expectedQuantity){
//        Assert.assertTrue(getCartValue().equals(expectedQuantity));
//    }
//

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
}