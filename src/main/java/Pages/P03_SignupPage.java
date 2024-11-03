package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_SignupPage {
    private final By accountInfoText = By.xpath("//*[text()='Enter Account Information']");
    private final By titleMr = By.id("id_gender1");
    private final By titleMrs = By.id("id_gender2");
    private final By password = By.cssSelector("[data-qa='password']");
    private final By dayDropdown = By.cssSelector("[data-qa='days']");
    private final By monthDropdown = By.cssSelector("[data-qa='months']");
    private final By yearDropdown = By.cssSelector("[data-qa='years']");
    private final By newsLetterBox = By.id("newsletter");
    private final By specialOffersBox = By.id("optin");


    private final WebDriver driver;

    public P03_SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Assertions :

    public boolean accountInfoTextIsDisplayed() {
        return driver.findElement(accountInfoText).isDisplayed();
    }

    public boolean verifyingNewsLetterCheckBoxIsSelected() {
        return driver.findElement(newsLetterBox).isSelected();
    }
    public boolean verifyingSpecialOffersCheckBoxIsSelected() {
        return driver.findElement(specialOffersBox).isSelected();
    }


    //TODO: Entering Account Information :

    public P03_SignupPage enterTitleMr() {
        Utility.clickingOnElement(driver, titleMr);
        return this;

    }
    public P03_SignupPage enterTitleMrs() {
        Utility.clickingOnElement(driver, titleMrs);
        return this;

    }
    public P03_SignupPage enterPassword() {
        Utility.sendData(driver,password, DataUtils.getJsonData("accountInformation","password"));
        return this;

    }
    public  P03_SignupPage selectDay(){
        Utility.selectingFromDropDown(driver,dayDropdown,"24");
        return this;
    }
    public  P03_SignupPage selectMonth(){
        Utility.selectingFromDropDown(driver,monthDropdown,"April");
        return this;
    }
    public  P03_SignupPage selectYear(){
        Utility.selectingFromDropDown(driver,yearDropdown,"1996");
        return this;
    }
    public P03_SignupPage clickOnNewsLetterCheckBox(){
        Utility.clickingOnElement(driver,newsLetterBox);
        return this;
    }
    public P03_SignupPage clickOnSpecialOffersCheckBox(){
        Utility.clickingOnElement(driver,specialOffersBox);
        return this;
    }

}