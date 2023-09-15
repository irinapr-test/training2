
import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class E2E extends BaseTest {
     private Navigation navigation;



    @BeforeTest()
    public void setup1() {
        navigation = new Navigation();
     }

    @Test
    public void E2E() {
        //navigate to url

     //verify Ui elements
        driver1.get(URL);
       navigation.verifyUIElementsOnLoginPage();
//
//       //input 1st username and valid password
//        navigation.logIntoShopWithUserNameAndPassword("standard_user", "secret_sauce");
//        //verify UI elements
//        navigation.verifyUIElementsOnMainPage();
//
//        //add to chart
//        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Backpack");
//        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Bike Light");
//        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Bolt T-Shirt");
//        mainPage.verifyCartBadge("3");
//        mainPage.clickOnRemoveButtonForItem("Sauce Labs Bolt T-Shirt");
//        mainPage.verifyCartBadge("2");
//
//        //get selected items price
//        Double price1 = mainPage.returnItemPrice("Sauce Labs Backpack");
//        Double price2 = mainPage.returnItemPrice("Sauce Labs Bike Light");
//        Double sum = price1 + price2;
//
//
//       //go to cart
//        navigation.clickOnCart();
//        cartPage.verifyUIElementsOnCartPage();
//        mainPage.verifyCartBadge("2");
//        cartPage.verifyThatProductIsDisplayedInCart("Sauce Labs Backpack", "1", "29.99");
//        cartPage.verifyThatProductIsDisplayedInCart("Sauce Labs Bike Light", "1", "9.99");
//
//        //verify thty ContinueShoppingButton redirects to main page
//        cartPage.clickOnContinueShoppingButton();
//
//        navigation.clickOnCart();
//        cartPage.clickOnCheckoutButton();
//        cartPage.verifyUIElementsOnCheckoutPage();
//        cartPage.driver.findElement(By.name("cancel")).click();
//        cartPage.verifyUIElementsOnCartPage();
//
//        cartPage.clickOnCheckoutButton();
//        cartPage.addUserInfoAddContinue("FN", "LN", "Zip");
//        cartPage.verifyUIElementsOnCheckoutOverView();
//        cartPage.verifyThatProductIsDisplayedInCart("Sauce Labs Backpack", "1", "29.99");
//        cartPage.verifyThatProductIsDisplayedInCart("Sauce Labs Bike Light", "1", "9.99");
//        cartPage.verifyTotalPrice(sum);
//        cartPage.driver.findElement(By.name("finish")).click();
//
//        cartPage.verifyUIElementsOnFinishPage();
//        cartPage.driver.findElement(By.name("back-to-products")).click();
//        mainPage.verifyUIElementsOnMainPage();
//        cartPage.driver.findElement(By.id("react-burger-menu-btn")).click();
//
//        burgerMenu.clickOnLogoutButton();
//        navigation.verifyUIElementsOnLoginPage();
    }
}
