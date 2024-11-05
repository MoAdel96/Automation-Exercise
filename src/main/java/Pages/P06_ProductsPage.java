package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ProductsPage {
    private final WebDriver driver;
    private final By productslist =By.className("features_items");
    private final By viewFirstProductButton =By.cssSelector("[href='/product_details/1']");



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

}
