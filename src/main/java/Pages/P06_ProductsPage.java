package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.*;

import java.util.List;

public class P06_ProductsPage {
    private final WebDriver driver;
    private final By productslist = By.className("features_items");
    private final By viewFirstProductButton = By.cssSelector("[href='/product_details/1']");
    private final By searchField = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By searchResults = By.xpath("//div[contains(@class, 'productinfo')]//p[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'men')]\n");
    private final By firstProduct = By.xpath("(//div[@class='features_items']/div[@class='col-sm-4'])[1]\n");
    private final By firstProductPrice = By.xpath("//div[@class='productinfo text-center']/h2\n");
    private final By firstProductOverlay = By.xpath("(//div[@class='features_items']//div[@class='col-sm-4'])[1]//div[@class='product-overlay']\n");
    private final By firstAddToCart = By.xpath("(//div[@class='features_items']//div[@class='col-sm-4'])[1]//div[@class='overlay-content']//a[@data-product-id='1']");
    private final By secondProduct = By.xpath("(//div[@class='features_items']/div[@class='col-sm-4'])[2]\n");
    private final By secondProductOverlay = By.xpath("(//div[@class='features_items']//div[@class='col-sm-4'])[2]//div[@class='product-overlay']\n");
    private final By secondAddToCart = By.xpath("(//div[@class='features_items']//div[@class='col-sm-4'])[2]//div[@class='overlay-content']//a[@data-product-id='2']");
    private final By continueShoppingButton = By.cssSelector("[data-dismiss='modal']");
    private final By cartButton = By.xpath("//ul[contains(@class,'navbar-nav')]/li/a[@href='/view_cart']\n");


    public P06_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean VerifyNavigatedToALLProductsPage(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);

    }

    public Boolean VerifyProductsListIsDisplayed() {
        return driver.findElement(productslist).isDisplayed();

    }

    public Boolean VerifyLandingOnProductDetailsPage(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);

    }

    public P07_ProductDetailsPage clickOnViewProductButton() {
        Utility.clickingOnElement(driver, viewFirstProductButton);
        return new P07_ProductDetailsPage(driver);
    }

    public P06_ProductsPage enterProductName() {
        Utility.sendData(driver, searchField, "men");
        return this;
    }

    public P06_ProductsPage clickOnSearchButton() {
        Utility.clickingOnElement(driver, searchButton);
        return new P06_ProductsPage(driver);
    }

    public Boolean VerifyProductNameIsWritten() {
        return driver.getCurrentUrl().equals("https://automationexercise.com/products?search=men");
    }

    public List<WebElement> VerifySearchResults() {
        List<WebElement> elements = driver.findElements(searchResults);

        if (!elements.isEmpty()) {
            for (WebElement element : elements) {
                try {
                    if (element.isDisplayed()) {
                        LogsUtils.info("Element is displayed");
                    }
                } catch (NoSuchElementException e) {
                    LogsUtils.info("Element not found:" + element);
                } catch (StaleElementReferenceException e) {
                    LogsUtils.info("Element is stale: " + element);
                } catch (Exception e) {
                    LogsUtils.info("An error occurred while checking element: " + e.getMessage());
                }
            }
        } else {
            LogsUtils.info("No elements found");
        }
        return elements;
    }

    public P06_ProductsPage hoverOverFirstProduct() {
        Utility.hoverOverElement(driver, firstProduct);
        return new P06_ProductsPage(driver);
    }

    public Boolean verifyAppearanceOfFirstOverlay() {
        return driver.findElement(firstProductOverlay).isDisplayed();

    }

    public P06_ProductsPage firstProductAddToCart() {
        Utility.clickingOnElement(driver, firstAddToCart);
        return new P06_ProductsPage(driver);
    }
    public Boolean verifyFirstProductAddingToCart() {
        Utility.waitForLocator(driver,continueShoppingButton);
        return driver.findElement(continueShoppingButton).isDisplayed();
    }

    public P06_ProductsPage clickOnContinueButton() {
        Utility.clickingOnElement(driver, continueShoppingButton);
        return new P06_ProductsPage(driver);
    }
    public Boolean verifyClickOnContinueButton() {
        return driver.findElement(continueShoppingButton).isDisplayed();
    }
    public P06_ProductsPage hoverOverSecondProduct() {
        Utility.hoverOverElement(driver, secondProduct);
        return new P06_ProductsPage(driver);
    }

    public Boolean verifyAppearanceOfSecondOverlay() {
        return driver.findElement(secondProductOverlay).isDisplayed();

    }

    public P06_ProductsPage secondProductAddToCart() {
        Utility.clickingOnElement(driver, secondAddToCart);
        return new P06_ProductsPage(driver);
    }
    public Boolean verifySecondProductAddingToCart() {
        Utility.waitForLocator(driver,continueShoppingButton);
        return driver.findElement(continueShoppingButton).isDisplayed();
    }
    public P08_CartPage clickOnCartButton(){
        Utility.clickingOnElement(driver,cartButton);
        return new P08_CartPage(driver);
    }
    public Boolean VerifyOpeningCartPage(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);

    }
    public P06_ProductsPage getFirstProductPrice(){
        Integer.parseInt(driver.findElement(firstProductPrice).getText().replace("Rs. ", "").trim());
    return new P06_ProductsPage(driver);}

    public P06_ProductsPage scrollingToFirstProduct(){
        Utility.scrolling(driver,firstProduct);
        return new P06_ProductsPage(driver);
    }



}





