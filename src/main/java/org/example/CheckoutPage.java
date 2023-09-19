package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

import static org.example.MainProductsPage.extractDouble2;

public class CheckoutPage extends BasePage{

    private By cancelButton = By.id("cancel");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By codeField = By.name("postalCode");
    private By errorMessage = By.cssSelector("h3[@data-test='error']");
    private By backToProducts =  By.name("back-to-products") ;

    private static final String CART_ITEM_NAME_XPATH = "//div[@class='inventory_item_name' and text()='%s']";
    private static final String CART_ITEM_QUANTITY_XPATH = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']";
    private static final String SUMMARY_INFO_ITEM_XPATH= "//div[contains(text(),'%s')]";


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    public void verifyUIElementsOnCheckoutPage(){
        Assert.assertTrue(find(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(find(By.className("title")).getText().equals("Checkout: Your Information"));
        Assert.assertTrue(find(By.className("checkout_info")).isDisplayed());
        Assert.assertTrue(find(firstNameField).isDisplayed());
        Assert.assertTrue(find(lastNameField).isDisplayed());
        Assert.assertTrue(find(codeField).isDisplayed());
        Assert.assertTrue(find(continueButton).isDisplayed());
        Assert.assertTrue(find(cancelButton).isDisplayed());
    }

    public void addUserInfoAndContinue(String firstName, String lastName, String zipCode){
        type(firstName, firstNameField);
        type(lastName, lastNameField);
        type(zipCode, codeField);
        click(continueButton);
    }

    public String getErrorMessageForFields(){
        return find(errorMessage).getText();
    }


    public void verifyUIElementsOnCheckoutOverView(){
        Assert.assertTrue(find(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(find(By.className("title")).getText().equals("Checkout: Overview"));
        Assert.assertTrue(find(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(find(By.className("shopping_cart_container")).isDisplayed());
        Assert.assertTrue(find(By.className("cart_list")).isDisplayed());
        Assert.assertTrue(find(By.className("cart_quantity_label")).isDisplayed());
        Assert.assertTrue(find(By.className("cart_desc_label")).isDisplayed());
        Assert.assertTrue(find(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Payment Information"))).isDisplayed());
        Assert.assertTrue(find(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Shipping Information"))).isDisplayed());
        Assert.assertTrue(find(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Price Total"))).isDisplayed());
        Assert.assertTrue(find(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Total:"))).isDisplayed());
        Assert.assertTrue(find(cancelButton).isDisplayed());
        Assert.assertTrue(find(finishButton).isDisplayed());
    }

    public void verifyItemTotal(String expectedItemTotal){
        String priceString = find(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Item total:"))).getText();
        Double price = extractDouble2(priceString);
        Assert.assertEquals(expectedItemTotal, price.toString());
    }

        public void verifyTotalPrice(Double expectedItemTotal){
        String getActualTotal =find(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Total:"))).getText();
        Double actualTotal = extractDouble2(getActualTotal);
        String getActualTax= find(By.xpath(String.format(SUMMARY_INFO_ITEM_XPATH,"Tax: "))).getText();
        Double taxprice = extractDouble2(getActualTax);
        Assert.assertEquals(taxprice + expectedItemTotal, actualTotal);
    }


    public void clickOnFinishButton(){
        click(finishButton);
    }
    public void clickOnCancelButton(){
        click(cancelButton);
    }
    public void clickOnBackToProductsButton(){
        click(backToProducts);
    }


    public void verifyUIElementsOnFinishPage(){
        Assert.assertTrue(find(By.className("app_logo")).getText().equals("Swag Labs"));
        Assert.assertTrue(find(By.className("title")).getText().equals("Checkout: Complete!"));
        Assert.assertTrue(find(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(find(By.className("complete-header")).getText().equals("Thank you for your order!"));
        Assert.assertTrue(find(By.name("back-to-products")).isDisplayed());
    }

    public void verifyThatProductIsDisplayedInCart(String itemName, String quantity){
        isDisplayed(By.xpath(String.format(CART_ITEM_NAME_XPATH, itemName)));
        Assert.assertTrue(find(By.xpath(String.format(CART_ITEM_QUANTITY_XPATH, itemName))).getText().equals(quantity));
    }


}
