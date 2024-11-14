package Tests;

import Pages.P01_HomePage;
import Pages.P06_ProductsPage;
import Pages.P07_ProductDetailsPage;
import Pages.P08_CartPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utility;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TC12_AddProductsInCart {
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
    public void clickOnProductsButton() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
    }

    @Test
    public void hoverOverFirstProduct() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //TODO: Hover over first Product:
        new P06_ProductsPage(getDriver()).hoverOverFirstProduct();
        //Assert hovering on the first product:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyAppearanceOfFirstOverlay());

    }

    @Test
    public void clickOnAddToCartForFirstProduct() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //TODO: Hover over first Product:
        new P06_ProductsPage(getDriver()).hoverOverFirstProduct();
        //Assert hovering on the first product:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyAppearanceOfFirstOverlay());
        //TODO: Click On Add To Cart:
        new P06_ProductsPage(getDriver()).firstProductAddToCart();
        //Assert Click On Add To Cart:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyFirstProductAddingToCart());

    }

    @Test
    public void clickOnContinueButtonForFirstProduct() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //TODO: Hover over first Product:
        new P06_ProductsPage(getDriver()).hoverOverFirstProduct();
        //Assert hovering on the first product:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyAppearanceOfFirstOverlay());
        //TODO: Click On Add To Cart:
        new P06_ProductsPage(getDriver()).firstProductAddToCart();
        //Assert Click On Add To Cart:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyFirstProductAddingToCart());
        //TODO: Click On Continue Button:
        new P06_ProductsPage(getDriver()).clickOnContinueButton();
        //Assert Click On continue button:
        Assert.assertFalse(new P06_ProductsPage(getDriver()).verifyClickOnContinueButton());


    }

    @Test
    public void hoverOverSecondProduct() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //TODO: Hover over second Product:
        new P06_ProductsPage(getDriver()).hoverOverSecondProduct();
        //Assert hovering on the Second product:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyAppearanceOfSecondOverlay());

    }

    @Test
    public void clickOnAddToCartForSecondProduct() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //TODO: Hover over Second Product:
        new P06_ProductsPage(getDriver()).hoverOverSecondProduct();
        //Assert hovering on the Second product:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyAppearanceOfSecondOverlay());
        //TODO: Click On Add To Cart:
        new P06_ProductsPage(getDriver()).secondProductAddToCart();
        //Assert Click On Add To Cart:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifySecondProductAddingToCart());

    }

    @Test
    public void clickOnContinueButtonForSecondProduct() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //TODO: Hover over Second Product:
        new P06_ProductsPage(getDriver()).hoverOverSecondProduct();
        //Assert hovering on the first product:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyAppearanceOfSecondOverlay());
        //TODO: Click On Add To Cart:
        new P06_ProductsPage(getDriver()).secondProductAddToCart();
        //Assert Click On Add To Cart:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifySecondProductAddingToCart());
        //TODO: Click On Continue Button:
        new P06_ProductsPage(getDriver()).clickOnContinueButton();
        //Assert Click On continue button:
        Assert.assertFalse(new P06_ProductsPage(getDriver()).verifyClickOnContinueButton());


    }

    @Test
    public void clickOnViewCartButton() {
        //TODO: Click On Cart Button:
        new P06_ProductsPage(getDriver()).clickOnCartButton();
        //Assert Click On cart button:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).VerifyOpeningCartPage(getDriver().getCurrentUrl()));


    }

    @Test
    public void VerifyBothProductsAreAddedToCart() {
        Assert.assertTrue(new P08_CartPage(getDriver()).verifyProductsAreDisplayed());
    }

    @Test
    public void verifyFirstProductPrice() {
        Assert.assertTrue(new P06_ProductsPage(getDriver()).getFirstProductPrice().equals(new P08_CartPage(getDriver()).locateFirstProductPrice()));

    }

    @Test(groups = {"addToCart"},testName = "Add To Cart")
    @Description("Add products to cart")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("12")
    @Epic("Web interface")
    @Feature("Cart")
    @Story("Order")
    public void addToCart() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //Assert opening Products page:
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
        //TODO: Hover over first Product:
        new P06_ProductsPage(getDriver()).scrollingToFirstProduct().hoverOverFirstProduct();
        //Assert hovering on the first product:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyAppearanceOfFirstOverlay());
        //TODO: Click On Add To Cart:
        new P06_ProductsPage(getDriver()).firstProductAddToCart();
        //Assert Click On Add To Cart:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyFirstProductAddingToCart());
        //TODO: Click On Continue Button:
        new P06_ProductsPage(getDriver()).clickOnContinueButton();
        //Assert Click On continue button:
        Assert.assertFalse(new P06_ProductsPage(getDriver()).verifyClickOnContinueButton());
        //TODO: Hover over Second Product:
        new P06_ProductsPage(getDriver()).hoverOverSecondProduct();
        //Assert hovering on the first product:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifyAppearanceOfSecondOverlay());
        //TODO: Click On Add To Cart:
        new P06_ProductsPage(getDriver()).secondProductAddToCart();
        //Assert Click On Add To Cart:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).verifySecondProductAddingToCart());
        //TODO: Click On Continue Button:
        new P06_ProductsPage(getDriver()).clickOnContinueButton();
        //Assert Click On continue button:
        Assert.assertFalse(new P06_ProductsPage(getDriver()).verifyClickOnContinueButton());
        //TODO: Click On Cart Button:
        new P06_ProductsPage(getDriver()).clickOnCartButton();
        //Assert Click On cart button:
        Assert.assertTrue(new P06_ProductsPage(getDriver()).VerifyOpeningCartPage(getDriver().getCurrentUrl()));
        LogsUtils.info("cart was opened");
        //Assert first product price:
        Assert.assertTrue(new P08_CartPage(getDriver()).verifyFirstProductInfoAreDisplayed());
        LogsUtils.info("first product info are checked");
        //Assert second product price:
        Assert.assertTrue(new P08_CartPage(getDriver()).verifySecondProductInfoAreDisplayed());
        LogsUtils.info("second product info are checked");

    }


    @AfterMethod(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
     }
}
