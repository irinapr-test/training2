package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class MainProductsPage extends BasePage {

    private static final String PRODUCT_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']";
    private static final String ADD_TO_CART_BUTTON_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Add to cart')]";
    private static final String REMOVE_BUTTON_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Remove')]";
    private static final String PRICE_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price']";
    private By shopping_cart_container = By.className("shopping_cart_container");


    public MainProductsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isProductDisplayed(String productName){
            return isDisplayed(By.xpath(String.format(PRODUCT_XPATH, productName)));
    }

    public void clickOnAddToCartButtonForItem(String productName){
        click(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, productName)));
    }

    public void clickOnRemoveButtonForItem(String productName){
        click(By.xpath(String.format(REMOVE_BUTTON_XPATH, productName)));
    }

    public Double getProductPrice(String productName){
        String priceString = find(By.xpath(String.format(PRICE_XPATH, productName))).getText();
        Double price = extractDouble2(priceString);
        return price;
    }

    static Double extractDouble2(String s)
    {
        Double price = Double.valueOf(0);
        s = s.replaceAll("[^0-9]", " ");
        s = s.replaceAll(" +", " ");
        if (s.equals(""));
        Scanner scanner = new Scanner(s);
        Double  dollars = Double.valueOf(scanner.nextInt());
        Double  cents = Double.valueOf(scanner.nextInt());
        price = cents/100 + dollars;
        return price;
    }
    public String getCartValue(){
        return find(shopping_cart_container).getText();
    }

}