package Tests;

import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TC03_LoginUserWithIncorrectEmailAndPassword {


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

        @Test(groups = {"invalidLogin"},testName = "invalid login")
        @Description("Login User With In Correct Email And Password ")
        @Owner("Mohamed Adel")
        @Severity(CRITICAL)
        @AllureId("3")
        @Epic("Web interface")
        @Feature("Login")
        @Story("Login")
        public void LoginUserWithInCorrectEmailAndPassword(){
            //TODO:Go to Login page
            new P01_HomePage(getDriver()).clickOnSignUpLoginButton();
            //TODO:Verify that login page is visible successfully
            Assert.assertTrue(new P01_HomePage(getDriver())
                    .assertSignUpTC(DataUtils.getJsonData("environment", "LOGIN_URL")));
            LogsUtils.info("Login page is opened successfully");
            //TODO: enter login credentials
            new P02_LoginPage(getDriver()).enterLoginEmail(email).enterLoginPassword(password).clickOnLoginButton();
            //TODO:Verify that validation is displayed
            Assert.assertTrue(new P02_LoginPage(getDriver()).assertInvalidCre());
        }

        @AfterMethod(alwaysRun = true)
        public void quit () throws IOException {
            quitDriver();
        }
    }


