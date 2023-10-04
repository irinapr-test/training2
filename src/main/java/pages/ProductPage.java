package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;
import static utils.Utils.extractDouble;

//TODO let's import the assertions statically, so we can just call assertEquals(), assertTrue();
// this should be applied for all Pages

public class ProductPage extends BasePage{

    private By productItemName = By.xpath("//div[contains(@class, 'name')]");
    private By productItemDescription = By.xpath("//div[contains(@class, 'desc')]");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By backToProducts = By.id("back-to-products");
    private static final String PRICE_XPATH = "//div[@class='inventory_details_price']";



    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void verifyProductPageUiElements(String productName, String price){
        find(productItemName).isDisplayed();
        String price1 = getProductPrice(productName).toString();
        assertTrue(find(productItemName).getText().equals(productName));
        assertTrue(price1.equals(price));
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

    public Double getProductPrice(String productName){
        String priceString = find(By.xpath(String.format(PRICE_XPATH, productName))).getText();
        Double price = extractDouble(priceString);
        return price;
    }

}
