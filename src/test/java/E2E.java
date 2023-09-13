
import org.example.Navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
        navigation.logIntoShop("standard_user", "secret_sauce");

    }
}
