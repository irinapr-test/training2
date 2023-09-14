
import org.example.Navigation;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class E2E {
  //public static
    private Navigation navigation;

  @BeforeTest()
  private void setup() {
    navigation = new Navigation();
  }

    @Test
    public void E2E() {
    //navigate to url
     navigation.navigateToShop();

      //input 1st username and valid password
        navigation.logIntoShopWithUserNameAndPassword("standard_user", "secret_sauce");
        navigation.clickOnAddToCartButtonForItem("Sauce Labs Backpack");
        navigation.clickOnAddToCartButtonForItem("Sauce Labs Bike Light");
        navigation.clickOnAddToCartButtonForItem("Sauce Labs Bolt T-Shirt");

        navigation.clickOnRemoveButtonForItem("Sauce Labs Bolt T-Shirt");



        //get selected items price
        Double price1 = navigation.returnItemPrice("Sauce Labs Backpack");
        Double price2 = navigation.returnItemPrice("Sauce Labs Bike Light");
        Double sum = price1 + price2;


        System.out.println(price1);
        System.out.println(price2);










    }
}
