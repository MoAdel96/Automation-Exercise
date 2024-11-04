package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_DeletePage {
    private final WebDriver driver;
    private final By deleteText = By.xpath("//*[text()='Account Deleted!']");
    private final By continueButton = By.cssSelector("[data-qa='continue-button']");

    public P05_DeletePage(WebDriver driver) {
        this.driver = driver;
    }


    public P01_HomePage clickOnContinueButton() {
        Utility.clickingOnElement(driver, continueButton);
        return new P01_HomePage(driver);
    }

    // assertions:
    public boolean assertRedirectingToHomePage(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);

    }

    public boolean assertDeleteText() {
        return driver.findElement(deleteText).isDisplayed();

    }
}
