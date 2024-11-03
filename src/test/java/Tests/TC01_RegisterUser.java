package Tests;

import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Pages.P03_SignupPage;
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

public class TC01_RegisterUser {

    //to Get dynamic Credential from json file:
    String name = DataUtils.getData("dynamicData", "signupN&E.Name") + Utility.getTimeStamp();
    String email = DataUtils.getData("dynamicData", "signupN&E.Email") + Utility.getTimeStamp() + "@gmail.com";



    @BeforeMethod
    public void setup() throws IOException {
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
    public void openSignupPage() {
        //TODO:Go to signup page
        new P01_HomePage(getDriver()).clickOnSignUpLoginButton();
        //TODO:Verify that signup page is visible successfully
        Assert.assertTrue(new P01_HomePage(getDriver())
                .assertSignUpTC(DataUtils.getJsonData("environment", "LOGIN_URL")));
        LogsUtils.info("Signup page is opened successfully");
    }

    @Test
    public void FillingSignupFields() {
        //TODO:Go to signup page
        new P01_HomePage(getDriver()).clickOnSignUpLoginButton();
        //TODO: Entering name and Email and click on signup button
        new P02_LoginPage(getDriver()).enterName(name).enterEmail(email).clickOnSignUpButton();

        LogsUtils.info(getDriver().getCurrentUrl());

        Assert.assertTrue(new P03_SignupPage(getDriver()).accountInfoTextIsDisplayed());

        LogsUtils.info("assertion is done");
    }

    @Test
    public void FillingAccInfo() {
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterEmail(email).clickOnSignUpButton();
        //TODO : Filling Account Information
        new P03_SignupPage(getDriver()).selectDay().selectMonth().selectYear().enterPassword().enterTitleMr();

    }

    @Test
    public void ClickOnNewsLetterCheckBox() {
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterEmail(email).clickOnSignUpButton();
        //TODO: Click On NewsLetter CheckBox
        new P03_SignupPage(getDriver()).clickOnNewsLetterCheckBox();
        Assert.assertTrue(new P03_SignupPage(getDriver()).verifyingNewsLetterCheckBoxIsSelected());
        LogsUtils.info("NewsLetter Check Box Is Selected");

    }

    @Test
    public void ClickOnSpecialOffersCheckBox() {
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterEmail(email).clickOnSignUpButton();
        //TODO: Click On NewsLetter CheckBox
        new P03_SignupPage(getDriver()).clickOnSpecialOffersCheckBox();
        Assert.assertTrue(new P03_SignupPage(getDriver()).verifyingSpecialOffersCheckBoxIsSelected());
        LogsUtils.info("Special Offer Check Box Is Selected");

    }

    @Test
    public void FillingAddressInfo() {
        //TODO: Entering name and Email
        new P01_HomePage(getDriver())
                .clickOnSignUpLoginButton().enterName(name).enterEmail(email).clickOnSignUpButton();
        //TODO: Filling Address Info
        new P03_SignupPage(getDriver()).enterFirstName()
                .enterLastName().enterCompany().enterAddress().enterAddress2().selectCountry().enterState().enterCity().enterZipCode();
        //TODO: Generate dynamic mobile number
        String dynamicMobileNumber = Utility.generateMobileNumber();

        //TODO: Enter dynamic mobile number in registration form
        new P03_SignupPage(getDriver()).enterMobileNumber(dynamicMobileNumber);

        //TODO: Click on Create Button
        new P03_SignupPage(getDriver()).ClickOnCreateButton();


    }

//    @Test
//    public void testEnterDynamicMobileNumber() {
//
//        //TODO: Entering name and Email
//        new P01_HomePage(getDriver())
//                .clickOnSignUpLoginButton().enterName(name).enterEmail(email).clickOnSignUpButton();
//        //TODO: Generate dynamic mobile number
//        String dynamicMobileNumber = Utility.generateMobileNumber();
//
//        //TODO: Enter dynamic mobile number in registration form
//        new P03_SignupPage(getDriver()).enterMobileNumber(dynamicMobileNumber);
//
//
//    }


//        @AfterMethod
//        public void quit () throws IOException {
//        quitDriver();
//}
}

