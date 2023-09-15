package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwagLabsPage extends BaseTest {

   private static final String ADD_TO_CART_BUTTON_XPATH1 = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Add to cart')]";

    private static final String REMOVE_BUTTON_XPATH = "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']/descendant::button[contains(text(),'Remove')]";



    public SwagLabsPage() {
    }
//    public void clickOnAddToCartForItem(String itemName){
//       String  xpath = String.format(ADD_TO_CART_BUTTON_XPATH1, itemName);
//        System.out.println(xpath);
//        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH1, itemName))).click();
//        boolean result = driver.findElement(By.xpath(String.format(REMOVE_BUTTON_XPATH, itemName))).isDisplayed();
//        assert result;
//
//
//    }

}
