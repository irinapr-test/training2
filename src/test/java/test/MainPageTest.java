package test;

import core.BaseTest;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.BurgerMenu;
import pages.MainProductsPage;
import pages.ProductPage;

public class MainPageTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(E2ETest.class);

    private final String PRODUCT_NAME_1 = "Sauce Labs Backpack";
    private final String PRODUCT_PRICE_1 = "29.99";
    private final String PRODUCT_NAME_2 = "Sauce Labs Bike Light";
    private final String PRODUCT_NAME_3 = "Sauce Labs Onesie";
    private final String PRODUCT_NAME_4 = "Sauce Labs Bike Light";
    private final String PRODUCT_NAME_5 = "Sauce Labs Fleece Jacket";
    private final String PRODUCT_NAME_6 = "Test.allTheThings() T-Shirt (Red)";


    @Test
    public void AddingProductsToCartTest() {

        loginPage.verifyUIElementsOnLoginPage();
        logger.info("log in with valid credentials");
        MainProductsPage mainPage = loginPage.logInWith("standard_user", "secret_sauce");

        logger.info("verify main products page elements");
        mainPage.verifyMainProductsPageUiElements();

        logger.info("verify that the list of products are displayed");
        String[] products = {PRODUCT_NAME_1, PRODUCT_NAME_2, PRODUCT_NAME_3, PRODUCT_NAME_4, PRODUCT_NAME_5, PRODUCT_NAME_6};
        for (String i : products) {
            Assert.assertTrue(mainPage.isProductDisplayed(i));
        }

        logger.info("click on Add to cart button");
        mainPage.clickOnAddToCartButtonForItem(PRODUCT_NAME_1);
        logger.info("verify Cart Badge");
        mainPage.verifyCartBadge("1");
        logger.info("click on Add to cart button for 2d product");
        mainPage.clickOnAddToCartButtonForItem(PRODUCT_NAME_2);
        logger.info("verify Cart Badge");
        mainPage.verifyCartBadge("2");

        logger.info("navigate to Product page");
        ProductPage product1Page = mainPage.clickOnProduct(PRODUCT_NAME_1);
        product1Page.verifyProductPageUiElements(PRODUCT_NAME_1, PRODUCT_PRICE_1);
        product1Page.clickOnBackToProducts();

        logger.info("logout");
        mainPage.logout();
        loginPage.verifyUIElementsOnLoginPage();

        logger.info("log in with valid credentials and verify that the chose is saved");
        loginPage.logInWith("standard_user", "secret_sauce");
        mainPage.verifyCartBadge("2");
        mainPage.verifyThatRemoveButtonIsDisplayed(PRODUCT_NAME_1);
        mainPage.verifyThatRemoveButtonIsDisplayed(PRODUCT_NAME_2);

        BurgerMenu burgerMenu = mainPage.clickOnBurgerMenu();
        burgerMenu.clickOnResetAppStateButton();
        mainPage.verifyThatCartIsEmpty();

       /*failed on bug
        logger.info("Verify that previously selected products have been removed from cart");
         mainPage.clickOnAddToCartButtonForItem(PRODUCT_NAME_1);
         mainPage.verifyThatRemoveButtonIsDisplayed(PRODUCT_NAME_2);
*/

        logger.info("verify ordering result");
        mainPage.clickOnOrderingOption("Name (Z to A)");

    }

}