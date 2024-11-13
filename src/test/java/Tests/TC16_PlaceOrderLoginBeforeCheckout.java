package Tests;

import Pages.*;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;


public class TC16_PlaceOrderLoginBeforeCheckout {
    //to Get dynamic Credential from json file:
    String password = DataUtils.getData("dynamicData", "ValidLoginTest.Password");
    String email = DataUtils.getData("dynamicData", "ValidLoginTest.Email");

    @BeforeMethod(alwaysRun = true)


    public void setup() {

        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(groups = {"order"})

    public void placeOrder() {

        //TODO:Go to Login page
        new P01_HomePage(getDriver()).clickOnSignUpLoginButton();
        LogsUtils.info("Login page is opened successfully");
        //TODO: enter login credentials
        new P02_LoginPage(getDriver()).enterLoginEmail(email).enterLoginPassword(password).clickOnLoginButton();
        //TODO:Verify that usr logged in successfully
        Assert.assertTrue(new P01_HomePage(getDriver()).LoggedInfo().contains("Logged in as"));
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //TODO: click on view first product button:
        new P06_ProductsPage(getDriver()).scrollingToFirstProduct().clickOnViewProductButton();
        //Assert user is navigated to product details page:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).VerifyLandingOnProductDetailsPage(getDriver().getCurrentUrl()));
        //TODO: Increase Quantity, add to cart and view cart:
        new P07_ProductDetailsPage(getDriver()).changeQuantity().clickOnAddToCart().clickOnViewCart();
        //assert product is displayed with exact quantity"
        Assert.assertTrue(new P08_CartPage(getDriver()).verifyTC13ProductIsDisplayed());
        LogsUtils.info("product is displayed");
        //TODO: click on checkout button:
        new P08_CartPage(getDriver()).clickOnCheckOutButton();
        //verify review order and address details are displayed:
        Assert.assertTrue(new P09_CheckOutPage(getDriver()).verifyAddressDetails());
        Assert.assertTrue(new P09_CheckOutPage(getDriver()).verifyReviewOrder());
        //TODO: entering comment and clicking on place order button:
        new P09_CheckOutPage(getDriver()).enterComment().clickOnPlaceOrderButton();
        //TODO: filling payment form and click on pay:
        new P10_PaymentPage(getDriver()).enterNameOnCard().enterCardNum().enterCVC().enterExpMonth().enterExpYear().clickOnPayButton();
        LogsUtils.info("msg is: "+ new P10_PaymentPage(getDriver()).locateMsg());
        //assert success msg:
        Assert.assertTrue(new P10_PaymentPage(getDriver()).verifySuccessMsg());
        LogsUtils.info("payment is done");


    }


    @AfterMethod(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
    }
}
