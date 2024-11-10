package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.*;

import java.util.List;

public class P06_ProductsPage {
    private final WebDriver driver;
    private final By productslist =By.className("features_items");
    private final By viewFirstProductButton =By.cssSelector("[href='/product_details/1']");
    private final By searchField =By.id("search_product");
    private final By searchButton =By.id("submit_search");
    private final By searchResults =By.xpath("//div[contains(@class, 'productinfo')]//p[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'men')]\n");




    public P06_ProductsPage(WebDriver driver) {
        this.driver=driver;
    }

    public Boolean VerifyNavigatedToALLProductsPage(String expectedValue){
       return driver.getCurrentUrl().equals(expectedValue);

    }
    public Boolean VerifyProductsListIsDisplayed(){
       return driver.findElement(productslist).isDisplayed();

    }
    public Boolean VerifyLandingOnProductDetailsPage(String expectedValue){
        return driver.getCurrentUrl().equals(expectedValue);

    }

    public P07_ProductDetailsPage clickOnViewProductButton(){
        Utility.clickingOnElement(driver,viewFirstProductButton);
        return new P07_ProductDetailsPage(driver);
    }
    public P06_ProductsPage enterProductName (){
        Utility.sendData(driver,searchField,"men");
        return this;
    }

    public P06_ProductsPage clickOnSearchButton() {
        Utility.clickingOnElement(driver, searchButton);
        return new P06_ProductsPage(driver);
    }
    public Boolean VerifyProductNameIsWritten(){
        return driver.findElement(searchField).getText().equals("men");
    }
    public List<WebElement> VerifySearchResults(){
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




}
