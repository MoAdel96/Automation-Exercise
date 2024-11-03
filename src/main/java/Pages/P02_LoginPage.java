package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {
    private final By Name = By.cssSelector("input[name=\"name\"]");
    private final By Email = By.cssSelector("input[data-qa=\"signup-email\"]");
    private final By SignUpButton = By.cssSelector("button[data-qa=\"signup-button\"]");
    private final WebDriver driver;

    public P02_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P02_LoginPage enterName(String NameText){
        Utility.sendData(driver,Name,NameText);
        return this;
    }

    public P02_LoginPage enterEmail(String EmailText){
        Utility.sendData(driver,Email,EmailText);
        return this;
    }

    public P03_SignupPage clickOnSignUpButton(){
        Utility.clickingOnElement(driver, SignUpButton);
        return new P03_SignupPage(driver);
    }



}
