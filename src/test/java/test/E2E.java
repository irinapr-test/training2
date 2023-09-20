package test;


import org.testng.annotations.Test;
import pages.*;


public class E2E extends BaseTest {

    private final String PRODUCT_NAME_1 = "Sauce Labs Backpack";
    private final String PRODUCT_PRICE_1 = "29.99";
    private final String PRODUCT_PRICE_2 = "9.99";
    private final String PRODUCT_NAME_2 = "Sauce Labs Bike Light";
    private final String PRODUCT_NAME_3 = "Sauce Labs Bolt T-Shirt";

    @Test
       public void E2E() {

        //verify login page elements
        loginPage.verifyUIElementsOnLoginPage();

        //log in with valid credentials
        MainProductsPage mainPage = loginPage.logInWith("standard_user", "secret_sauce");
        //verify main products page elements
        mainPage.verifyMainProductsPageUiElements();

        //click on product item
        ProductPage productPage = mainPage.clickOnProduct(PRODUCT_NAME_1);
        //verify product is displayed
        productPage.verifyProductPageUiElements(PRODUCT_NAME_1);
        //click on Add to cart and verify that remove button is displayed
        productPage.clickOnAddToCart();
        //click on Remove and verify that Add to cart  button is displayed
        productPage.clickOnRemove();
        //click on Add to cart
        productPage.clickOnAddToCart();
        //click on back to products
        productPage.clickOnBackToProducts();


        //verify cart value
        mainPage.verifyCartBadge("1");
        mainPage.clickOnAddToCartButtonForItem(PRODUCT_NAME_2);
        mainPage.clickOnAddToCartButtonForItem(PRODUCT_NAME_3);
        //verify cart value
        mainPage.verifyCartBadge("3");
        //remove one item
        mainPage.clickOnRemoveButtonForItem(PRODUCT_NAME_3);
        //verify cart value
        mainPage.verifyCartBadge("2");

        //get selected items price
        Double price1 = mainPage.getProductPrice(PRODUCT_NAME_1);
        Double price2 = mainPage.getProductPrice(PRODUCT_NAME_2);
        Double sum = price1 + price2;

        //go to cart
        CartPage cartPage = mainPage.clickOnCart();
        //verify ui elements and selected products
        cartPage.verifyUIElementsOnCartPage();
        cartPage.verifyThatProductIsDisplayedInCart(PRODUCT_NAME_1, "1", PRODUCT_PRICE_1 );
        cartPage.verifyThatProductIsDisplayedInCart(PRODUCT_NAME_2, "1", PRODUCT_PRICE_2);

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
        checkoutPage.verifyThatProductIsDisplayedInCart(PRODUCT_NAME_1, "1");
        checkoutPage.verifyThatProductIsDisplayedInCart(PRODUCT_NAME_2, "1");
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
