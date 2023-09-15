package org.example;

import org.openqa.selenium.By;

import java.time.Duration;

public class BurgerMenu{

    private static final String LOGOUT_BUTTON_XPATH= "//a[contains(text(),'Logout')]";


    public void clickOnLogoutButton (){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //driver.findElement(By.xpath(LOGOUT_BUTTON_XPATH)).click();
    }
}

