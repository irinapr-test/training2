package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.example.MainProductsPage.extractDouble2;

public class CartPage extends BasePage{
    private MainProductsPage mainPage;

    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private static final String CART_ITEM_NAME_XPATH = "//div[@class='inventory_item_name' and text()='%s']";
    private static final String CART_ITEM_QUANTITY_XPATH = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']";
    private static final String PRICE_XPATH_ON_CART= "//div[@class='inventory_item_name' and contains(text(),'%s')]/ancestor::div[@class='cart_item_label']/descendant::div[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void verifyCartBadge(String expectedQuantity){
        Assert.assertTrue(mainPage.getCartValue().equals(expectedQuantity));
    }

    public void verifyThatProductIsDisplayedInCart(String itemName, String quantity, String price){
            isDisplayed(By.xpath(String.format(CART_ITEM_NAME_XPATH, itemName)));
           String itemPrice = returnItemPriceOnCart(itemName).toString();
           Assert.assertTrue(itemPrice.equals(price));
           Assert.assertTrue(find(By.xpath(String.format(CART_ITEM_QUANTITY_XPATH, itemName))).getText().equals(quantity));
    }

    public Double returnItemPriceOnCart(String itemName) {
        String priceString = driver.findElement(By.xpath(String.format(PRICE_XPATH_ON_CART, itemName))).getText();
        Double price =  extractDouble2(priceString);
        return price;
    }

     public MainProductsPage clickOnContinueShoppingButton (){
        click(continueShoppingButton);
         return new MainProductsPage(driver);
     }

    public CheckoutPage clickOnCheckoutShoppingButton (){
        click(checkoutButton);
        return new CheckoutPage(driver);
    }

    public void verifyUIElementsOnCartPage(){
        Assert.assertTrue(find(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(find(By.className("title")).getText().equals("Your Cart"));
        Assert.assertTrue(find(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(find(By.className("shopping_cart_container")).isDisplayed());
        Assert.assertTrue(find(By.className("cart_list")).isDisplayed());
        Assert.assertTrue(find(By.className("cart_quantity_label")).isDisplayed());
        Assert.assertTrue(find(By.className("cart_desc_label")).isDisplayed());
        Assert.assertTrue(find(checkoutButton).isDisplayed());
        Assert.assertTrue(find(continueShoppingButton).isDisplayed());
    }


}
