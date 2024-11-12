package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_ProductDetailsPage {
    private final WebDriver driver;
    private final By productName = By.xpath("//*[text()='Blue Top']");
    private final By productCategory = By.xpath("//*[text()='Category: Women > Tops']");
    private final By productPrice = By.xpath("//*[text()='Rs. 500']");
    private final By productAvailability = By.xpath("//*[text()=' Availability:']");
    private final By productCondition = By.xpath("//*[text()='Condition:']");
    private final By productBrand = By.xpath("//*[text()='Brand:']");
    private final By productQuantity = By.id("quantity");
    private final By addToCartButton = By.cssSelector("[type='button']");
    private final By viewCartButton = By.xpath("//p[@class='text-center']//a[@href='/view_cart']");

    public P07_ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyProductName() {
        return driver.findElement(productName).isDisplayed();
    }

    public boolean verifyProductCategory() {
        return driver.findElement(productCategory).isDisplayed();
    }

    public boolean verifyProductPrice() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean verifyProductAvailability() {
        return driver.findElement(productAvailability).isDisplayed();
    }

    public boolean verifyProductCondition() {
        return driver.findElement(productCondition).isDisplayed();
    }

    public boolean verifyProductBrand() {
        return driver.findElement(productBrand).isDisplayed();
    }

    public P07_ProductDetailsPage changeQuantity() {
        driver.findElement(productQuantity).clear();
        Utility.sendData(driver, productQuantity, DataUtils.getData("dynamicData", "productQuantity"));
        return this;
    }

    public P07_ProductDetailsPage clickOnAddToCart() {
        Utility.clickingOnElement(driver, addToCartButton);
        return new P07_ProductDetailsPage(driver);
    }
    public P08_CartPage clickOnViewCart() {
        Utility.clickingOnElement(driver, viewCartButton);
        return new P08_CartPage(driver);
    }
}
