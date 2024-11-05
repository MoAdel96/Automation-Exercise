package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_ProductDetailsPage {
    private final WebDriver driver;
    private final By productName =By.xpath("//*[text()='Blue Top']");
    private final By productCategory =By.xpath("//*[text()='Category: Women > Tops']");
    private final By productPrice =By.xpath("//*[text()='Rs. 500']");
    private final By productAvailability =By.xpath("//*[text()=' Availability:']");
    private final By productCondition =By.xpath("//*[text()='Condition:']");
    private final By productBrand =By.xpath("//*[text()='Brand:']");

    public P07_ProductDetailsPage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean verifyProductName(){
        return driver.findElement(productName).isDisplayed();
    }
    public boolean verifyProductCategory(){
        return driver.findElement(productCategory).isDisplayed();
    }
    public boolean verifyProductPrice(){
        return driver.findElement(productPrice).isDisplayed();
    }
    public boolean verifyProductAvailability(){
        return driver.findElement(productAvailability).isDisplayed();
    }
    public boolean verifyProductCondition(){
        return driver.findElement(productCondition).isDisplayed();
    }
    public boolean verifyProductBrand(){
        return driver.findElement(productBrand).isDisplayed();
    }

}
