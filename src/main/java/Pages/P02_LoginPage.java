package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {

    private final WebDriver driver;
    public P02_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By Name = By.cssSelector("[data-qa='signup-name']");
    private final By Email = By.cssSelector("[data-qa='signup-email']");
    private final By SignupButton = By.cssSelector("[data-qa='signup-button']");

    public P02_LoginPage enterName (String nameText){
        Utility.sendData(driver,Name,nameText);
        return this;
    }
    public P02_LoginPage enterEmail (String emailText){
        Utility.sendData(driver,Email,emailText);
        return this;
    }
    public P03_SignupPage clickOnSignupButton (){
        Utility.clickingOnElement(driver,SignupButton);
        return new P03_SignupPage(driver);
    }

    public boolean assertSignupPage (String ExpectedValue){
        return driver.getCurrentUrl().equals(ExpectedValue);
    }
}
