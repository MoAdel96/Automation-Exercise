package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_HomePage {
    private final By Logo = By.cssSelector("[src='/static/images/home/logo.png'");
    private final By SignUp_Login_Button = By.cssSelector("[href='/login']");
    private final WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isLogoVisible() {
        try {
            WebElement logoElement = driver.findElement(Logo);
            return logoElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Logo not found on the page.");
            return false;
        }
    }

    public P02_LoginPage clickOnSignUpLoginButton(){
        Utility.clickingOnElement(driver,SignUp_Login_Button);

        return new P02_LoginPage(driver);

    }
    public Boolean assertSignUpTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }



}
