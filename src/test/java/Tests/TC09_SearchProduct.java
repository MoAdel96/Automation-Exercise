package Tests;

import Pages.P01_HomePage;
import Pages.P06_ProductsPage;
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

public class TC09_SearchProduct {
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
    public void enterProductName() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //TODO: entering Product Name:
        new P06_ProductsPage(getDriver()).enterProductName();
        Assert.assertTrue(new P06_ProductsPage(getDriver()).VerifyProductNameIsWritten());
        LogsUtils.info("The Product name was entered");
    }
    @Test
    public void clickOnSearchButton() {
        //TODO: Open Products Page:
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        //TODO: entering Product Name and click on search button:
        new P06_ProductsPage(getDriver()).enterProductName().clickOnSearchButton();
        Assert.assertFalse(new P06_ProductsPage(getDriver()).VerifySearchResults().isEmpty());
        LogsUtils.info("The Product name was entered");
    }



    @Test
    public void searchForProducts() {
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        new P06_ProductsPage(getDriver()).enterProductName().clickOnSearchButton();
        Assert.assertFalse(new P06_ProductsPage(getDriver()).VerifySearchResults().isEmpty());


    }


    @AfterMethod(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
    }
}
