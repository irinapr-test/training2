package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Utils;

import java.time.Duration;


public class MainProductsPage extends BasePage {
    private Utils utils;

    private static final String PRODUCT_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']";
    private static final String ADD_TO_CART_BUTTON_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Add to cart')]";
    private static final String REMOVE_BUTTON_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Remove')]";
    private static final String PRICE_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price']";
   private By shopping_cart_container = By.className("shopping_cart_container");

    private By burgerMenuButton = By.id("react-burger-menu-btn");

    public MainProductsPage(WebDriver driver) {
        super(driver);
    }


    public void verifyMainProductsPageUiElements(){
        Assert.assertTrue(find(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(find(By.className("title")).getText().equals("Products"));
        Assert.assertTrue(find(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(find(By.className("shopping_cart_container")).isDisplayed());
       Assert.assertTrue(find(By.className("product_sort_container")).isDisplayed());
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
        Utils utils = new Utils();
        Double price = utils.extractDouble(priceString);
        return price;
    }

    public String getCartQuantityValue(){
        return find(shopping_cart_container).getText();
    }

    public void verifyCartBadge(String expectedQuantity){
        Assert.assertTrue(getCartQuantityValue().equals(expectedQuantity));
    }

    public CartPage clickOnCart(){
        find(shopping_cart_container).isDisplayed();
        click(shopping_cart_container);
        return new CartPage(driver);
    }

    public BurgerMenu clickOnBurgerMenu()  {
        find(burgerMenuButton).isDisplayed();
        click(burgerMenuButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return new BurgerMenu(driver);
    }


    public void logout (){
        BurgerMenu burgerMenu = clickOnBurgerMenu();
        burgerMenu.clickOnLogoutButton();
    }
}