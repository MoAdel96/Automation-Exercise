package Tests;

import Pages.P01_HomePage;
import Pages.P06_ProductsPage;
import Pages.P07_ProductDetailsPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TC08_VerifyAllProductsAndProductDetailPage {
    //to Get dynamic Credential from json file:
    String password = DataUtils.getData("dynamicData", "inValidLoginTest.Password");
    String email = DataUtils.getData("dynamicData", "inValidLoginTest.Email");



    @BeforeMethod(alwaysRun = true)
    public void setup() {

        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void clickOnProductsButton ()
    {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: "+getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
    }
    @Test
    public void clickOnViewProductButton () {
        //TODO: click on view first product button:
        new P06_ProductsPage(getDriver()).clickOnViewProductButton();
        //Assert user is navigated to product details page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyLandingOnProductDetailsPage(getDriver().getCurrentUrl()));
    }


        @Test(groups = {"TC08"})
    public void VerifyAllProductsAndProductDetailPage ()
    {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: "+getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //Assert Products list is displayed:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).VerifyProductsListIsDisplayed());
        //TODO: click on view first product button:
        new P06_ProductsPage(getDriver()).clickOnViewProductButton();
        //Assert user is navigated to product details page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyLandingOnProductDetailsPage(getDriver().getCurrentUrl()));
        //Assert visibility of product details:
        Assert.assertTrue(new P07_ProductDetailsPage(getDriver()).verifyProductName());
        Assert.assertTrue(new P07_ProductDetailsPage(getDriver()).verifyProductCategory());
        Assert.assertTrue(new P07_ProductDetailsPage(getDriver()).verifyProductPrice());
        Assert.assertTrue(new P07_ProductDetailsPage(getDriver()).verifyProductCondition());
        Assert.assertTrue(new P07_ProductDetailsPage(getDriver()).verifyProductAvailability());
        Assert.assertTrue(new P07_ProductDetailsPage(getDriver()).verifyProductBrand());


    }







    @AfterMethod(alwaysRun = true)
    public void quit () throws IOException {
        quitDriver();
    }
}
