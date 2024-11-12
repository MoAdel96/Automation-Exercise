package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public P10_PaymentPage clickOnPayButton(){
        Utility.clickingOnElement(driver,payButton);

        return new P10_PaymentPage(driver);
    }
    public P10_PaymentPage locateMsg(){
        driver.findElement(successMsg).getText();

        return this;
    }

    public Boolean verifySuccessMsg() {
        Utility.waitForLocator(driver,successMsg);
        return driver.findElement(successMsg).isDisplayed();
    }


}
