package Tests;

import Pages.P01_HomePage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class TC18_ViewCategoryProducts {
    //to Get dynamic Credential from json file:
    String password = DataUtils.getData("dynamicData", "ValidLoginTest.Password");
    String email = DataUtils.getData("dynamicData", "ValidLoginTest.Email");

    @BeforeClass(alwaysRun = true)


    public void setup() {

        setupDriver(DataUtils.getJsonData("environment", "Browser"));
        LogsUtils.info("Browser was opened");
        getDriver().get(DataUtils.getJsonData("environment", "HOME_URL"));
        LogsUtils.info(" Browser is redirected to the HOME URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(groups = {"category"})
    @Owner("Mohamed Adel")
    @Severity(NORMAL)
    @Epic("Web interface")
    @Feature("products page")
    @Story("Products")
    public void verifyCategoriesISDisplayed(){
        Assert.assertTrue(new P01_HomePage(getDriver()).assertCategories());
        LogsUtils.info("Categories are Displayed");
    }

    @Test(groups = {"category"}, dependsOnMethods = {"verifyCategoriesISDisplayed"})
    @Owner("Mohamed Adel")
    @Severity(NORMAL)
    @Epic("Web interface")
    @Feature("products page")
    @Story("Products")
    public void viewCategories(){
        new P01_HomePage(getDriver()).clickOnWomenCategory().clickOnDressCategory();
        Assert.assertTrue(new P01_HomePage(getDriver()).assertTitleText());
        new P01_HomePage(getDriver()).clickOnMenCategory().clickOnTShirtsCategory();
        Assert.assertTrue(new P01_HomePage(getDriver()).verifyUserIsNavigatedToThatCategoryPage(getDriver().getCurrentUrl()));
    }




    @AfterClass(alwaysRun = true)

    public void quit() throws IOException {
        quitDriver();
    }
}
