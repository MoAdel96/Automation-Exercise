package Tests;

import Pages.*;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utility;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TC01_RegisterUser {

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


    @Test(groups = {"flow"})
    public void openHomePage() {
        //TODO:Go to home page
        new P01_HomePage(getDriver());
        //TODO:Verify that home page is visible successfully
        Assert.assertTrue(new P01_HomePage(getDriver()).isLogoVisible());
        LogsUtils.info("Home page is opened successfully");
    }

    @Test(groups = {"flow"})
    public void openSignupPage() {
        //TODO:Go to signup page
        new P01_HomePage(getDriver()).clickOnSignUpLoginButton();
        //TODO:Verify that signup page is visible successfully
        Assert.assertTrue(new P01_HomePage(getDriver())
                .assertSignUpTC(DataUtils.getJsonData("environment", "LOGIN_URL")));
        LogsUtils.info("Signup page is opened successfully");
    }

    @Test(groups = {"flow"})
    public void FillingSignupFields() {
        //TODO:Go to signup page
        new P01_HomePage(getDriver()).clickOnSignUpLoginButton();
        //TODO: Entering name and Email and click on signup button
        new P02_LoginPage(getDriver()).enterName(name).enterSignupEmail(email).clickOnSignUpButton();
        LogsUtils.info(name);
        LogsUtils.info(getDriver().getCurrentUrl());

        Assert.assertTrue(new P03_SignupPage(getDriver()).accountInfoTextIsDisplayed());

        LogsUtils.info("assertion is done");
    }

    @Test(groups = {"flow"})
    public void FillingAccInfo() {
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterSignupEmail(email).clickOnSignUpButton();
        //TODO : Filling Account Information
        new P03_SignupPage(getDriver()).selectDay().selectMonth().selectYear().enterPassword().enterTitleMr();

    }

    @Test(groups = {"flow"})
    public void ClickOnNewsLetterCheckBox() {
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterSignupEmail(email).clickOnSignUpButton();
        //TODO: Click On NewsLetter CheckBox
        new P03_SignupPage(getDriver()).clickOnNewsLetterCheckBox();
        Assert.assertTrue(new P03_SignupPage(getDriver()).verifyingNewsLetterCheckBoxIsSelected());
        LogsUtils.info("NewsLetter Check Box Is Selected");

    }

    @Test(groups = {"flow"})
    public void ClickOnSpecialOffersCheckBox() {
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterSignupEmail(email).clickOnSignUpButton();
        //TODO: Click On NewsLetter CheckBox
        new P03_SignupPage(getDriver()).clickOnSpecialOffersCheckBox();
        Assert.assertTrue(new P03_SignupPage(getDriver()).verifyingSpecialOffersCheckBoxIsSelected());
        LogsUtils.info("Special Offer Check Box Is Selected");

    }

    @Test(groups = {"flow"})
    public void FillingAddressInfo() {
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterSignupEmail(email).clickOnSignUpButton();
        //TODO: Filling Address Info
        new P03_SignupPage(getDriver()).enterFirstName()
                .enterLastName().enterCompany().enterAddress().enterAddress2().selectCountry().enterState().enterCity().enterZipCode();
        //TODO: Generate dynamic mobile number
        String dynamicMobileNumber = Utility.generateMobileNumber();

        //TODO: Enter dynamic mobile number in registration form
        new P03_SignupPage(getDriver()).enterMobileNumber(dynamicMobileNumber);

        //TODO: Click on Create Button
        new P03_SignupPage(getDriver()).ClickOnCreateButton();
        LogsUtils.info("current URL is : " +getDriver().getCurrentUrl());

        Assert.assertTrue(new P04_AccCreatedPage(getDriver()).assertionCreatingAccount());
    }



    @Test(groups = {"flow"})
    public void ClickOnContinueButton(){
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterSignupEmail(email).clickOnSignUpButton();

        //TODO : Filling Account Information
        new P03_SignupPage(getDriver()).selectDay().selectMonth().selectYear().enterPassword().enterTitleMr();
        //TODO: Click On NewsLetter CheckBox
        new P03_SignupPage(getDriver()).clickOnNewsLetterCheckBox();
        LogsUtils.info("NewsLetter Check Box Is Selected");
        //TODO: Click On NewsLetter CheckBox
        new P03_SignupPage(getDriver()).clickOnSpecialOffersCheckBox();
                LogsUtils.info("Special Offer Check Box Is Selected");
        //TODO: Filling Address Info
        new P03_SignupPage(getDriver()).enterFirstName()
                .enterLastName().enterCompany().enterAddress().enterAddress2().selectCountry().enterState().enterCity().enterZipCode();
        //TODO: Generate dynamic mobile number
        String dynamicMobileNumber = Utility.generateMobileNumber();

        //TODO: Enter dynamic mobile number in registration form
        new P03_SignupPage(getDriver()).enterMobileNumber(dynamicMobileNumber);

        //TODO: Click on Create Button
        new P03_SignupPage(getDriver()).ClickOnCreateButton();
        LogsUtils.info("current URL is : " +getDriver().getCurrentUrl());
        //TODO: Click on continue Button
        new P04_AccCreatedPage(getDriver()).clickOnContinueButton();
        Assert.assertTrue(new P01_HomePage(getDriver()).assertLoggedInText());
        LogsUtils.info(new P01_HomePage(getDriver()).LoggedInfo());
    }
    @Test
    public void ClickOnDeleteButton(){
        //TODO: Click on Delete Button
        new P01_HomePage(getDriver()).ClickOnDeleteButton();
        Assert.assertTrue(new P05_DeletePage(getDriver()).assertDeleteText());
        //TODO: Click on continue Button
        new P05_DeletePage(getDriver()).clickOnContinueButton();
        Assert.assertTrue(new P05_DeletePage(getDriver()).assertRedirectingToHomePage(getDriver().getCurrentUrl()));
    }






    @Test(testName = "Register new user",groups = {"register"})
    @Description("Register new user from scratch")
    @Owner("Mohamed Adel")
    @Severity(CRITICAL)
    @AllureId("1")
    @Epic("Web interface")
    @Feature("Register")
    @Story("Authentication")
   public void RegisterUser(){
       //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterSignupEmail(email).clickOnSignUpButton();
        LogsUtils.info(name);
        LogsUtils.info(email);

        //TODO : Filling Account Information
        new P03_SignupPage(getDriver()).selectDay().selectMonth().selectYear().enterPassword().enterTitleMr();
        //TODO: Click On NewsLetter CheckBox
        new P03_SignupPage(getDriver()).clickOnNewsLetterCheckBox();
        LogsUtils.info("NewsLetter Check Box Is Selected");
        //TODO: Click On NewsLetter CheckBox
        new P03_SignupPage(getDriver()).clickOnSpecialOffersCheckBox();
        LogsUtils.info("Special Offer Check Box Is Selected");
        //TODO: Filling Address Info
        new P03_SignupPage(getDriver()).enterFirstName()
                .enterLastName().enterCompany().enterAddress().enterAddress2().selectCountry().enterState().enterCity().enterZipCode();
        //TODO: Generate dynamic mobile number
        String dynamicMobileNumber = Utility.generateMobileNumber();

        //TODO: Enter dynamic mobile number in registration form
        new P03_SignupPage(getDriver()).enterMobileNumber(dynamicMobileNumber);

        //TODO: Click on Create Button
        new P03_SignupPage(getDriver()).ClickOnCreateButton();
        LogsUtils.info("current URL is : " +getDriver().getCurrentUrl());
        //TODO: Click on continue Button
        new P04_AccCreatedPage(getDriver()).clickOnContinueButton();
        Assert.assertTrue(new P01_HomePage(getDriver()).assertLoggedInText());
        LogsUtils.info(new P01_HomePage(getDriver()).LoggedInfo());
        //TODO: Click on Delete Button
        new P01_HomePage(getDriver()).ClickOnDeleteButton();
        Assert.assertTrue(new P05_DeletePage(getDriver()).assertDeleteText());
        //TODO: Click on continue Button
        new P05_DeletePage(getDriver()).clickOnContinueButton();
        Assert.assertTrue(new P05_DeletePage(getDriver()).assertRedirectingToHomePage(getDriver().getCurrentUrl()));

    }





        @AfterMethod(alwaysRun = true)

        public void quit () throws IOException {
        quitDriver();
}
}

