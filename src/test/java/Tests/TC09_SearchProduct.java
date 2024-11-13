package Tests;

import Pages.P01_HomePage;
import Pages.P06_ProductsPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TC09_SearchProduct {
    //to Get dynamic Credential from json file:
    String name = DataUtils.getData("dynamicData", "validRegisterTest.Name") + Utility.getTimeStamp();
    String email = DataUtils.getData("dynamicData", "validRegisterTest.Email") + Utility.getTimeStamp() + "@gmail.com";

    @BeforeClass(alwaysRun = true)
    public void setup() {
        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(groups = {"search"})
    public void openHomePage() {
        // Go to home page
        new P01_HomePage(getDriver());
        // Verify that home page is visible successfully
        Assert.assertTrue(new P01_HomePage(getDriver()).isLogoVisible());
        LogsUtils.info("Home page is opened successfully");
    }

    @Test(groups = {"search"}, dependsOnMethods = {"openHomePage"})
    public void clickOnProductsButton() {
        // Open Products Page
        new P01_HomePage(getDriver()).clickOnProductsButton();
        LogsUtils.info("Current URL is: " + getDriver().getCurrentUrl());
        // Assert opening Products page
        Assert.assertTrue(new P06_ProductsPage(getDriver())
                .VerifyNavigatedToALLProductsPage(getDriver().getCurrentUrl()));
    }

    @Test(groups = {"search"}, dependsOnMethods = {"clickOnProductsButton"})
    public void enterProductName() {
        // Entering Product Name
        new P06_ProductsPage(getDriver()).enterProductName();
        LogsUtils.info("The Product name was entered");
    }

    @Test(groups = {"search"}, dependsOnMethods = {"enterProductName"})
    public void clickOnSearchButton() {
        // Enter Product Name and click on search button
        new P06_ProductsPage(getDriver()).clickOnSearchButton();
        Assert.assertFalse(new P06_ProductsPage(getDriver()).VerifySearchResults().isEmpty());
        LogsUtils.info("The search was completed");
    }

    @Test(groups = {"search"}, dependsOnMethods = {"clickOnSearchButton"})
    public void searchForProducts() {
        // Search for Products and verify results
        Assert.assertFalse(new P06_ProductsPage(getDriver()).VerifySearchResults().isEmpty());
        LogsUtils.info("Product search results are displayed successfully");
    }

    @AfterClass(alwaysRun = true)
    public void quit() throws IOException {
        quitDriver();
    }
}
