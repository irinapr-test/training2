package test;


import org.testng.annotations.Test;
import pages.*;


public class E2E extends BaseTest {

    @Test
    public void E2E() {
        //verify login page elements
        loginPage.verifyUIElementsOnLoginPage();

        //log in with valid credentials
        MainProductsPage mainPage = loginPage.logInWith("standard_user", "secret_sauce");
        //verify main products page elements
        mainPage.verifyMainProductsPageUiElements();

        //add 3 items to cart
        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Backpack");
        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Bike Light");
        mainPage.clickOnAddToCartButtonForItem("Sauce Labs Bolt T-Shirt");
        //verify cart value
        mainPage.verifyCartBadge("3");
        //remove one item
        mainPage.clickOnRemoveButtonForItem("Sauce Labs Bolt T-Shirt");
        //verify cart value
        mainPage.verifyCartBadge("2");

        //get selected items price
        Double price1 = mainPage.getProductPrice("Sauce Labs Backpack");
        Double price2 = mainPage.getProductPrice("Sauce Labs Bike Light");
        Double sum = price1 + price2;

        //go to cart
        CartPage cartPage = mainPage.clickOnCart();
        //verify ui elements and selected products
        cartPage.verifyUIElementsOnCartPage();
        cartPage.verifyThatProductIsDisplayedInCart("Sauce Labs Backpack", "1", "29.99");
        cartPage.verifyThatProductIsDisplayedInCart("Sauce Labs Bike Light", "1", "9.99");

        //verify that Continue Shopping Button redirects to main page
        cartPage.clickOnContinueShoppingButton();
        mainPage.verifyMainProductsPageUiElements();

        //go back to cart
        mainPage.clickOnCart();
        //click on checkout button and verify Checkout: Your Information UI elements
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutShoppingButton();
        checkoutPage.verifyUIElementsOnCheckoutPage();
         //click on cancel button verify that user is on cart page
        checkoutPage.clickOnCancelButton();
        cartPage.verifyUIElementsOnCartPage();

        //click on checkout button
        cartPage.clickOnCheckoutShoppingButton();

        //input user data, click Continue and verify Checkout: Overview UI elements
        checkoutPage.addUserInfoAndContinue("s", "s", "s");
        checkoutPage.verifyUIElementsOnCheckoutOverView();

         //verify that selected products and the Total: price
        checkoutPage.verifyThatProductIsDisplayedInCart("Sauce Labs Backpack", "1");
        checkoutPage.verifyThatProductIsDisplayedInCart("Sauce Labs Bike Light", "1");
        checkoutPage.verifyTotalPrice(sum);

        //click on finish button and verify finish prompt
        checkoutPage.clickOnFinishButton();
        checkoutPage.verifyUIElementsOnFinishPage();
        //click on go back button and verify that the main page is displayed
        checkoutPage.clickOnBackToProductsButton();
        mainPage.verifyMainProductsPageUiElements();

        //logout
        mainPage.logout();
        loginPage.verifyUIElementsOnLoginPage();

    }
}
