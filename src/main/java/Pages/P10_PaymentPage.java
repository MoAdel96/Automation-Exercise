package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

public class P10_PaymentPage {
    private final WebDriver driver;
    private final By nameOnCard =By.cssSelector("[data-qa='name-on-card']");
    private final By cardNum =By.cssSelector("[data-qa='card-number']");
    private final By CVC =By.cssSelector("[data-qa='cvc']");
    private final By expMonth =By.cssSelector("[data-qa='expiry-month']");
    private final By expYear =By.cssSelector("[data-qa='expiry-year']");
    private final By payButton =By.cssSelector("[data-qa='pay-button']");
    private final By successMsg =By.xpath("//div[contains(@class,'col-md-12')]//div[contains(@class,'alert-success')]");

    public P10_PaymentPage(WebDriver driver) {
        this.driver=driver;
    }
    public P10_PaymentPage enterNameOnCard(){
        Utility.sendData(driver,nameOnCard, DataUtils.getData("dynamicData","validPayment.name"));
        return this;
    }
    public P10_PaymentPage enterCardNum(){
        Utility.sendData(driver,cardNum, DataUtils.getData("dynamicData","validPayment.cardNum"));
        return this;
    }
    public P10_PaymentPage enterCVC(){
        Utility.sendData(driver,CVC, DataUtils.getData("dynamicData","validPayment.cvc"));
        return this;
    }
    public P10_PaymentPage enterExpMonth(){
        Utility.sendData(driver,expMonth, DataUtils.getData("dynamicData","validPayment.expMonth"));
        return this;
    }
    public P10_PaymentPage enterExpYear(){
        Utility.sendData(driver,expYear, DataUtils.getData("dynamicData","validPayment.expYear"));
        return this;
    }
    public P11_ConfirmPage clickOnPayButton(){
        Utility.clickingOnElement(driver,payButton);

        return new P11_ConfirmPage(driver);
    }


    public Boolean verifySuccessMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 1: Wait for the element to be present in the DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(successMsg));

        // Step 2: Wait for the element to be visible on the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));

        // At this point, the element should be both present and visible
        return driver.findElement(successMsg).isDisplayed();
    }



}
