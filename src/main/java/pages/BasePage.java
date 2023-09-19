package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Scanner;


public abstract class BasePage {
    protected WebDriver driver;



    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    protected WebElement find (By locator){
        return driver.findElement(locator);
    }

    protected void click (By locator){
        find(locator).isDisplayed();
        find(locator).click();
    }
    protected boolean isDisplayed (By locator){
        try {
            return find(locator).isDisplayed();
        }
        catch (NoSuchElementException exc){
            return false;
        }
    }

    protected void type(String text, By locator) {
        find(locator).isDisplayed();
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void clearField(By locator) {
        find(locator).isDisplayed();
        find(locator).clear();

    }


}
