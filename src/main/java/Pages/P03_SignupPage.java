package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_SignupPage {

    //Account Information Locators:
    private final By accountInfoText = By.xpath("//*[text()='Enter Account Information']");
    private final By titleMr = By.id("id_gender1");
    private final By titleMrs = By.id("id_gender2");
    private final By password = By.cssSelector("[data-qa='password']");
    private final By dayDropdown = By.cssSelector("[data-qa='days']");
    private final By monthDropdown = By.cssSelector("[data-qa='months']");
    private final By yearDropdown = By.cssSelector("[data-qa='years']");
    private final By newsLetterBox = By.id("newsletter");
    private final By specialOffersBox = By.id("optin");

    //Address Information Locators:
    private final By FirstName = By.cssSelector("[data-qa='first_name']");
    private final By LastName = By.cssSelector("[data-qa='last_name']");
    private final By Company = By.cssSelector("[data-qa='company']");
    private final By Address = By.cssSelector("[data-qa='address']");
    private final By Address2 = By.cssSelector("[data-qa='address2']");
    private final By CountryDropDown = By.cssSelector("[data-qa='country']");
    private final By State = By.cssSelector("[data-qa='state']");
    private final By City = By.cssSelector("[data-qa='city']");
    private final By ZipCode = By.cssSelector("[data-qa='zipcode']");
    private final By MobileNumber = By.cssSelector("[data-qa='mobile_number']");
    private final By createButton = By.cssSelector("[data-qa='create-account']");


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
    //TODO: Entering Address Information :

    public P03_SignupPage enterFirstName() {
        Utility.sendData(driver,FirstName,DataUtils.getJsonData("addressInformation","FirstName")+ Utility.getTimeStamp());
        return this;
    }
    public P03_SignupPage enterLastName() {
        Utility.sendData(driver,LastName,DataUtils.getJsonData("addressInformation","LastName")+ Utility.getTimeStamp());
        return this;
    }
    public P03_SignupPage enterCompany() {
        Utility.sendData(driver,Company,DataUtils.getJsonData("addressInformation","Company")+ Utility.getTimeStamp());
        return this;
    }
    public P03_SignupPage enterAddress() {
        Utility.sendData(driver,Address,DataUtils.getJsonData("addressInformation","Address")+ Utility.getTimeStamp());
        return this;
    }
    public P03_SignupPage enterAddress2() {
        Utility.sendData(driver,Address2,DataUtils.getJsonData("addressInformation","Address2")+ Utility.getTimeStamp());
        return this;
    }
    public P03_SignupPage selectCountry() {
        Utility.selectingFromDropDown(driver,CountryDropDown,"Canada");
        return this;
    }
    public P03_SignupPage enterState() {
        Utility.sendData(driver,State,DataUtils.getJsonData("addressInformation","State")+ Utility.getTimeStamp());
        return this;
    }
    public P03_SignupPage enterCity() {
        Utility.sendData(driver,City,DataUtils.getJsonData("addressInformation","City")+ Utility.getTimeStamp());
        return this;
    }
    public P03_SignupPage enterZipCode() {
        Utility.sendData(driver,ZipCode,DataUtils.getJsonData("addressInformation","Zipcode")+ Utility.getTimeStamp());
        return this;
    }
    public P03_SignupPage enterMobileNumber(String mobileNum) {
        Utility.sendData(driver,MobileNumber,mobileNum);
        return this;
    }
    public P04_AccCreatedPage ClickOnCreateButton() {
        Utility.clickingOnElement(driver,createButton);
        return new P04_AccCreatedPage(driver);
    }









}