package Tests;

import Pages.P01_HomePage;
import Pages.P06_ProductsPage;
import Pages.P07_ProductDetailsPage;
import Pages.P08_CartPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TC13_VerifyProductQuantityInCart {
    //to Get dynamic Credential from json file:
    String name = DataUtils.getData("dynamicData", "validRegisterTest.Name") + Utility.getTimeStamp();
    String email = DataUtils.getData("dynamicData", "validRegisterTest.Email") + Utility.getTimeStamp() + "@gmail.com";


    @BeforeMethod(alwaysRun = true)


    public void setup() {

        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void openHomePage() {
        //TODO:Go to home page
        new P01_HomePage(getDriver());
        //TODO:Verify that home page is visible successfully
        Assert.assertTrue(new P01_HomePage(getDriver()).isLogoVisible());
        LogsUtils.info("Home page is opened successfully");
    }

    @Test
    public void clickOnFirstProductButton(){
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: "+getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));

        //TODO: click on view first product button:
        new P06_ProductsPage(getDriver()).scrollingToFirstProduct().clickOnViewProductButton();
        //Assert user is navigated to product details page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyLandingOnProductDetailsPage(getDriver().getCurrentUrl()));
    }
    @Test
    public void increaseQuantity(){
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: "+getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));

        //TODO: click on view first product button:
        new P06_ProductsPage(getDriver()).scrollingToFirstProduct().clickOnViewProductButton();
        //Assert user is navigated to product details page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyLandingOnProductDetailsPage(getDriver().getCurrentUrl()));
        //TODO: Increase Quantity:
        new P07_ProductDetailsPage(getDriver()).changeQuantity();
    }
    @Test
    public void ClickOnAddToCart(){
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: "+getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));

        //TODO: click on view first product button:
        new P06_ProductsPage(getDriver()).scrollingToFirstProduct().clickOnViewProductButton();
        //Assert user is navigated to product details page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyLandingOnProductDetailsPage(getDriver().getCurrentUrl()));
        //TODO: Increase Quantity, add to cart :
        new P07_ProductDetailsPage(getDriver()).changeQuantity().clickOnAddToCart();
    }
     @Test
    public void ClickOnViewCartButton(){
         //TODO: Open Products Page:
         new P01_HomePage(getDriver()).clickOnProductsButton();
         LogsUtils.info("Current URL is: "+getDriver().getCurrentUrl());
         //Assert opening Products page:
         Assert.assertTrue(new P06_ProductsPage(getDriver())
                 .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));

         //TODO: click on view first product button:
         new P06_ProductsPage(getDriver()).scrollingToFirstProduct().clickOnViewProductButton();
         //Assert user is navigated to product details page:
         Assert.assertTrue(new P06_ProductsPage(getDriver())
                 .VerifyLandingOnProductDetailsPage(getDriver().getCurrentUrl()));
         //TODO: Increase Quantity, add to cart and view cart:
         new P07_ProductDetailsPage(getDriver()).changeQuantity().clickOnAddToCart().clickOnViewCart();
    }



    @Test(groups = {"Quantity"})
    public void VerifyProductIsDisplayedInCartWithExactQuantity()
    {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: "+getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));

        //TODO: click on view first product button:
        new P06_ProductsPage(getDriver()).scrollingToFirstProduct().clickOnViewProductButton();
        //Assert user is navigated to product details page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyLandingOnProductDetailsPage(getDriver().getCurrentUrl()));
        //TODO: Increase Quantity, add to cart and view cart:
        new P07_ProductDetailsPage(getDriver()).changeQuantity().clickOnAddToCart().clickOnViewCart();
        //assert product is displayed with exact quantity"
        Assert.assertTrue(new P08_CartPage(getDriver()).verifyTC13ProductIsDisplayed());
        LogsUtils.info("product is displayed");
        Assert.assertTrue(new P08_CartPage(getDriver()).verifyTC13ProductQuantity());
        LogsUtils.info("Quantity is right");




    }





    @AfterMethod(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
    }
}
