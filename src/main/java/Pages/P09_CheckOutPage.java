package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P09_CheckOutPage {
    private final WebDriver driver;
    private final By addressDetails = By.xpath("//div[@class='step-one']/h2[text()='Address Details']");
    private final By reviewOrder = By.xpath("//div[@class='step-one']/h2[text()='Review Your Order']");
    private final By commentArea = By.className("form-control");
    private final By placeOrderButton = By.xpath("//a[contains(@class,'check_out')]");


    public P09_CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean verifyAddressDetails() {
        return driver.findElement(addressDetails).isDisplayed();
    }

    public Boolean verifyReviewOrder() {
        return driver.findElement(reviewOrder).isDisplayed();
    }

    public P09_CheckOutPage enterComment() {
        Utility.sendData(driver, commentArea, DataUtils.getData("dynamicData", "comment"));
        return this;
    }

    public P10_PaymentPage clickOnPlaceOrderButton() {
        Utility.clickingOnElement(driver, placeOrderButton);
        return new P10_PaymentPage(driver);

    }


}
