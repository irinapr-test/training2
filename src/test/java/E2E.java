
import org.example.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class E2E extends BaseTest {
  //public static

//    @BeforeClass()
//    private void setup() {
//        loginPage = new LoginPage(driver);
//    }
    @Test
    public void E2E() {
        loginPage.verifyUIElementsOnLoginPage();
        MainProductsPage mainPage = loginPage.logInWith("standard_user", "secret_sauce");
        mainPage.verifyMainProductsPageUiElements();

        //add to chart
        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Backpack");
        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Bike Light");
        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Bolt T-Shirt");
        mainPage.verifyCartBadge("3");
        mainPage.clickOnRemoveButtonForItem("Sauce Labs Bolt T-Shirt");
        mainPage.verifyCartBadge("2");

        //get selected items price
        Double price1 = mainPage.getProductPrice("Sauce Labs Backpack");
        Double price2 = mainPage.getProductPrice("Sauce Labs Bike Light");
        Double sum = price1 + price2;

       //go to cart
        CartPage cartPage = mainPage.clickOnCart();
        cartPage.verifyUIElementsOnCartPage();
        cartPage.verifyThatProductIsDisplayedInCart("Sauce Labs Backpack", "1", "29.99");
        cartPage.verifyThatProductIsDisplayedInCart("Sauce Labs Bike Light", "1", "9.99");

        //verify that ContinueShoppingButton redirects to main page

        cartPage.clickOnContinueShoppingButton();
        mainPage.verifyMainProductsPageUiElements();


        mainPage.clickOnCart();
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutShoppingButton();

        checkoutPage.verifyUIElementsOnCheckoutPage();

        checkoutPage.clickOnCancelButton();
        cartPage.verifyUIElementsOnCartPage();

        cartPage.clickOnCheckoutShoppingButton();
        checkoutPage.addUserInfoAndContinue("s", "s", "s");

        checkoutPage.verifyUIElementsOnCheckoutOverView();

        checkoutPage.verifyThatProductIsDisplayedInCart("Sauce Labs Backpack", "1");
        checkoutPage.verifyThatProductIsDisplayedInCart("Sauce Labs Bike Light", "1");
        checkoutPage.verifyTotalPrice(sum);
        checkoutPage.clickOnFinishButton();

        checkoutPage.verifyUIElementsOnFinishPage();
        checkoutPage.clickOnBackToProductsButton();
        mainPage.verifyMainProductsPageUiElements();

        BurgerMenu burgerMenu = mainPage.clickOnBurgerMenu();
        burgerMenu.clickOnLogoutButton();
        loginPage.verifyUIElementsOnLoginPage();


    }
}
