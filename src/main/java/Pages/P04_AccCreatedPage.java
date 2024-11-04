package Pages;

import Utilities.Utility;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_AccCreatedPage {

    private final By accountCreatedText = By.xpath("//*[text()='Account Created!']");
    private final By continueButton = By.cssSelector("[data-qa='continue-button']");
    private final WebDriver driver;

    public P04_AccCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean assertionCreatingAccount() {

        return driver.findElement(accountCreatedText).isDisplayed();
    }

    public P04_AccCreatedPage clickOnContinueButton() {
        Utility.clickingOnElement(driver, continueButton);
        return new P04_AccCreatedPage(driver);
    }


}
