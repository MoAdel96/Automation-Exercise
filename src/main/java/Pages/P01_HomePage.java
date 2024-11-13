package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_HomePage {
    private final By Logo = By.cssSelector("[src='/static/images/home/logo.png'");
    private final By SignUp_Login_Button = By.cssSelector("[href='/login']");
    private final By productsButton = By.cssSelector("[href='/products']");
    private final By deleteButton = By.cssSelector("[href='/delete_account']");
    private final By LoggedUser = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a > b");
    private final By LoggedInText = By.xpath("//*[text()=' Logged in as ']");
    private final By categories = By.xpath("//div[@id='accordian' and contains(@class,'category-products')]");
    private final By womenCategory = By.cssSelector("[href='#Women']");
    private final By menCategory = By.cssSelector("[href='#Men']");
    private final By dressCategory = By.cssSelector("[href='/category_products/1']");
    private final By tShirtsCategory = By.cssSelector("[href='/category_products/3']");
    private final By titleText = By.cssSelector("[class='title text-center']");

    private final WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO:Actions:
    public P02_LoginPage clickOnSignUpLoginButton() {
        Utility.clickingOnElement(driver, SignUp_Login_Button);

        return new P02_LoginPage(driver);

    }

    public P05_DeletePage ClickOnDeleteButton() {
        Utility.clickingOnElement(driver, deleteButton);
        return new P05_DeletePage(driver);
    }

    public P06_ProductsPage clickOnProductsButton() {
        Utility.clickingOnElement(driver, productsButton);
        return new P06_ProductsPage(driver);
    }

    public P01_HomePage clickOnWomenCategory() {
        Utility.clickingOnElement(driver, womenCategory);
        return new P01_HomePage(driver);
    }

    public P01_HomePage clickOnDressCategory() {
        Utility.clickingOnElement(driver, dressCategory);
        return new P01_HomePage(driver);
    }

    public P01_HomePage clickOnMenCategory() {
        Utility.clickingOnElement(driver, menCategory);
        return new P01_HomePage(driver);
    }

    public P01_HomePage clickOnTShirtsCategory() {
        Utility.clickingOnElement(driver, tShirtsCategory);
        return new P01_HomePage(driver);
    }


    //TODO:Assertions:

    public boolean isLogoVisible() {
        try {
            WebElement logoElement = driver.findElement(Logo);
            return logoElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Logo not found on the page.");
            return false;
        }
    }

    public Boolean assertSignUpTC(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }

    public Boolean assertLoggedInText() {
        return driver.findElement(LoggedInText).isDisplayed();
    }

    //to assert logged in User
    public String LoggedInfo() {
        String loggingText = driver.findElement(LoggedInText).getText();
        String loggedUser = driver.findElement(LoggedUser).getText();
        String loggedInfo = loggedUser + loggedUser;
        return loggingText;
    }

    public Boolean assertCategories() {
        return driver.findElement(categories).isDisplayed();
    }

    public Boolean assertTitleText() {
        return driver.findElement(titleText).isDisplayed();
    }

    public boolean verifyUserIsNavigatedToThatCategoryPage(String ExpectedValue) {
        return driver.getCurrentUrl().equals(ExpectedValue);
    }


}
