package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    private final By Signup_Login_Button= By.cssSelector("a[href='/login']");
    private final By NewUserSignup= By.xpath("//*[text()='New User Signup!']");

    private final WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public P02_LoginPage clickOnLoginButton (){
        Utility.clickingOnElement(driver,Signup_Login_Button);
        return new P02_LoginPage(driver);
    }
    public boolean verifyHomePage(String expectedValue){
        return driver.getCurrentUrl().equals(expectedValue);
    }

    public boolean NewUserSignupIsVisiable(){
        return driver.findElement(NewUserSignup).isDisplayed();
    }

}
