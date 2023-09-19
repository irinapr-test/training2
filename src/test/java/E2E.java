
import org.example.BasePage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class E2E {
  //public static
    private BasePage navigation;

  @BeforeTest()
  private void setup() {
  //  navigation = new BasePage();
  }

    @Test
    public void E2E() {
        //navigate to url
//        navigation.navigateToShop();
//       //verify Ui elements
//        navigation.verifyUIElementsOnLoginPage();
//
//       //input 1st username and valid password
//        navigation.logIntoShopWithUserNameAndPassword("standard_user", "secret_sauce");
//        //verify UI elements
//        navigation.verifyUIElementsOnMainPage();
//
//        //add to chart
//        navigation.clickOnAddToCartButtonForItem("Sauce Labs Backpack");
//        navigation.clickOnAddToCartButtonForItem("Sauce Labs Bike Light");
//        navigation.clickOnAddToCartButtonForItem("Sauce Labs Bolt T-Shirt");
//        navigation.verifyCartBadge("3");
//        navigation.clickOnRemoveButtonForItem("Sauce Labs Bolt T-Shirt");
//        navigation.verifyCartBadge("2");
//
//        //get selected items price
//        Double price1 = navigation.returnItemPrice("Sauce Labs Backpack");
//        Double price2 = navigation.returnItemPrice("Sauce Labs Bike Light");
//        Double sum = price1 + price2;
//
//
//       //go to cart
//        navigation.clickOnCart();
//        navigation.verifyUIElementsOnCartPage();
//        navigation.verifyCartBadge("2");
//        navigation.verifyThatProductIsDisplayedInCart("Sauce Labs Backpack", "1", "29.99");
//        navigation.verifyThatProductIsDisplayedInCart("Sauce Labs Bike Light", "1", "9.99");
//
//        //verify thty ContinueShoppingButton redirects to main page
//        navigation.clickOnContinueShoppingButton();
//
//        navigation.clickOnCart();
//        navigation.clickOnCheckoutButton();
//        navigation.verifyUIElementsOnCheckoutPage();
//        navigation.driver.findElement(By.name("cancel")).click();
//        navigation.verifyUIElementsOnCartPage();
//
//        navigation.clickOnCheckoutButton();
//        navigation.addUserInfoAddContinue("FN", "LN", "Zip");
//        navigation.verifyUIElementsOnCheckoutOverView();
//        navigation.verifyThatProductIsDisplayedInCart("Sauce Labs Backpack", "1", "29.99");
//        navigation.verifyThatProductIsDisplayedInCart("Sauce Labs Bike Light", "1", "9.99");
//        navigation.verifyTotalPrice(sum);
//        navigation.driver.findElement(By.name("finish")).click();
//
//        navigation.verifyUIElementsOnFinishPage();
//        navigation.driver.findElement(By.name("back-to-products")).click();
//        navigation.verifyUIElementsOnMainPage();
//        navigation.driver.findElement(By.id("react-burger-menu-btn")).click();
//
//        navigation.clickOnLogoutButton();
//
//        navigation.verifyUIElementsOnLoginPage();
//


    }
}
