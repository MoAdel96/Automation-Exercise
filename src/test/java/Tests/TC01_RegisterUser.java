package Tests;

import DriverFactory.DriverFactory;
import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import Listeners.ITestResultListenerClass;
import Listeners.IInvokedMethodListenerClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

@Listeners({ITestResultListenerClass.class, IInvokedMethodListenerClass.class})
public class TC01_RegisterUser {

    private final String Name = DataUtils.getData("dynamicData","validLoginTest.Name")+ Utility.getTimeStamp();
    private final String Email = DataUtils.getData("dynamicData","validLoginTest.Email")+ Utility.getTimeStamp();

    @BeforeMethod
    public void setup(){
        DriverFactory.setupDriver(DataUtils.getJsonData("environment","Browser"));
        LogsUtils.info("Browser was Opened");
        getDriver().get(DataUtils.getJsonData("environment","Home_URL"));
        LogsUtils.info("Home page was opened");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //Todo: Verifying Opening Home page
    @Test
    public void verifyOpeningHomepage (){
        Assert.assertTrue(new P01_HomePage(getDriver()).verifyHomePage(DataUtils.getJsonData("environment","Home_URL")));

    }
    //Todo: Verifying Opening Login page
    @Test
    public void clickOnLoginButton(){
        new P01_HomePage(getDriver()).clickOnLoginButton();

        Assert.assertTrue(new P01_HomePage(getDriver()).NewUserSignupIsVisiable());

    }
    //Todo: enter Name And Email
    @Test
    public void enterNameAndEmail(){
        new P02_LoginPage(getDriver()).wait().enterEmail(Email).enterName(Name).clickOnSignupButton();

        Assert.assertTrue(new P02_LoginPage(getDriver()).assertSignupPage(DataUtils.getJsonData("environment","Signup_URL")));
    }







    @AfterMethod
    public void Quit() throws IOException {
        quitDriver();
    }


}
