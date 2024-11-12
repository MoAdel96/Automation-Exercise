package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_CartPage {
    private final WebDriver driver;

    public P08_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public final By firstProduct = By.id("product-1");
    public final By secondProduct = By.id("product-2");
    public final By checkOutButton = By.xpath("//a[contains(@class,'check_out')]");
    public final By firstPrice = By.xpath("//tr[@id='product-1']/td[@class='cart_price']/p");
    public final By firstQuantity = By.xpath("//tr[@id='product-1']/td[@class='cart_quantity']/button");
    public final By firstToTalPrice = By.xpath("//tr[@id='product-1']/td[@class='cart_total']/p");
    public final By secondPrice = By.xpath("//tr[@id='product-2']/td[@class='cart_price']/p");
    public final By secondQuantity = By.xpath("//tr[@id='product-2']/td[@class='cart_quantity']/button");
    public final By secondToTalPrice = By.xpath("//tr[@id='product-2']/td[@class='cart_total']/p");


    public boolean verifyProductsAreDisplayed() {
        return driver.findElement(firstProduct).isDisplayed()
                && driver.findElement(secondProduct).isDisplayed();
    }

    public P09_CheckOutPage clickOnCheckOutButton() {
        Utility.clickingOnElement(driver, checkOutButton);
        return new P09_CheckOutPage(driver);
    }

    public int calculateTotalProductPrice() {
        // Locate the price element and get its text, then remove "Rs. " and convert to an integer
        int price = Integer.parseInt(driver.findElement(firstPrice).getText().replace("Rs. ", "").trim());

        // Locate the quantity button, get its text, and convert to an integer

        int quantity = Integer.parseInt(driver.findElement(firstQuantity).getText().trim());

        // Calculate and return the total
        return price * quantity;
    }

    public int getTotalProductPrice() {
        return Integer.parseInt(driver.findElement(firstToTalPrice).getText().replace("Rs. ", "").trim());
    }

    public P08_CartPage locateFirstProductPrice() {
        Integer.parseInt(driver.findElement(firstPrice).getText().replace("Rs. ", "").trim());
        return new P08_CartPage(driver);
    }

    public P08_CartPage locateSecondProductPrice() {
        Integer.parseInt(driver.findElement(secondPrice).getText().replace("Rs. ", "").trim());
        return new P08_CartPage(driver);
    }

    public boolean verifyFirstProductInfoAreDisplayed() {
        return driver.findElement(firstPrice).isDisplayed()
                && driver.findElement(firstQuantity).isDisplayed() && driver.findElement(firstToTalPrice).isDisplayed();
    }

    public boolean verifySecondProductInfoAreDisplayed() {
        return driver.findElement(secondPrice).isDisplayed()
                && driver.findElement(secondQuantity).isDisplayed() && driver.findElement(secondToTalPrice).isDisplayed();
    }
    public boolean verifyTC13ProductIsDisplayed() {
        return driver.findElement(firstProduct).isDisplayed();
    }
    public boolean verifyTC13ProductQuantity() {
        return driver.findElement(firstQuantity).getText().equals(DataUtils.getData("dynamicData","productQuantity"));
    }

}
