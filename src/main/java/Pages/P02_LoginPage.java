package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage {
    private final By signupName = By.cssSelector("input[name=\"name\"]");
    private final By signupEmail = By.cssSelector("input[data-qa=\"signup-email\"]");
    private final By SignUpButton = By.cssSelector("button[data-qa=\"signup-button\"]");
    private final By loginEmail = By.cssSelector("input[data-qa=\"login-email\"]");
    private final By loginPassword = By.cssSelector("input[data-qa=\"login-password\"]");
    private final By loginButton = By.cssSelector("button[data-qa=\"login-button\"]");
    private final By invalidCreValidation = By.xpath("//*[text()='Your email or password is incorrect!']");
    private final WebDriver driver;

    public P02_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: signup credentials :
    public P02_LoginPage enterName(String NameText) {
        Utility.sendData(driver, signupName, NameText);
        return this;
    }

    public P02_LoginPage enterSignupEmail(String EmailText) {
        Utility.sendData(driver, signupEmail, EmailText);
        return this;
    }

    public P03_SignupPage clickOnSignUpButton() {
        Utility.clickingOnElement(driver, SignUpButton);
        return new P03_SignupPage(driver);
    }

    //TODO: Login credentials :
    public P02_LoginPage enterLoginEmail(String loginEmailText) {
        Utility.sendData(driver, loginEmail, loginEmailText);
        return this;
    }

    public P02_LoginPage enterLoginPassword(String LoginPassword) {
        Utility.sendData(driver, loginPassword, LoginPassword);
        return this;
    }


    public P01_HomePage clickOnLoginButton() {
        Utility.clickingOnElement(driver, loginButton);
        return new P01_HomePage(driver);
    }

    //Assertions:
    public boolean assertInvalidCre() {
        return driver.findElement(invalidCreValidation).isDisplayed();
    }

}
