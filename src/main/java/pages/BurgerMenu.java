package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenu extends BasePage{

    private static final String BURGER_MENU_BUTTON_XPATH = "//a[contains(text(),'%s')]";


    public BurgerMenu(WebDriver driver) {
        super(driver);
    }



    public LoginPage clickOnLogoutButton (){
        click(By.xpath(String.format(BURGER_MENU_BUTTON_XPATH, "Logout")));
         return new LoginPage(driver);
    }


}
