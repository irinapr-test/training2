package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage extends BasePage{

    private By productItemName = By.xpath("//div[contains(@class, 'name')]");
    private By productItemDescription = By.xpath("//div[contains(@class, 'desc')]");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By backToProducts = By.id("back-to-products");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void verifyProductPageUiElements(String productName){
        find(productItemName).isDisplayed();
        Assert.assertTrue(find(productItemName).getText().equals(productName));
    }

     public void clickOnAddToCart(){
        click(addToCartButton);
        find(removeButton).isDisplayed();
    }

    public void clickOnRemove(){
        click(removeButton);
        find(addToCartButton).isDisplayed();
    }

    public void clickOnBackToProducts(){
        click(backToProducts);
    }



}
