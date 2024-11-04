package Tests;

import Pages.P01_HomePage;
import Pages.P02_LoginPage;
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

public class TC02_LoginUserWithCorrectEmailAndPassword {

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

    @Test(groups = {"validLogin"})
    public void LoginUserWithCorrectEmailAndPassword(){
        //TODO:Go to Login page
        new P01_HomePage(getDriver()).clickOnSignUpLoginButton();
        //TODO:Verify that login page is visible successfully
        Assert.assertTrue(new P01_HomePage(getDriver())
                .assertSignUpTC(DataUtils.getJsonData("environment", "LOGIN_URL")));
        LogsUtils.info("Login page is opened successfully");
        //TODO: enter login credentials
        new P02_LoginPage(getDriver()).enterLoginEmail(email).enterLoginPassword(password).clickOnLoginButton();
    }

    @AfterMethod(alwaysRun = true)
    public void quit () throws IOException {
        quitDriver();
    }
}
