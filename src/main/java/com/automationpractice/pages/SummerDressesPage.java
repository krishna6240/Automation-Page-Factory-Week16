package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SummerDressesPage extends Utility {

    public SummerDressesPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Printed Chiffon Dress']")
    WebElement printedChiffonDress;

    @CacheLookup
    @FindBy(xpath = "(//span[@class='cat-name'])[1]")
    WebElement summerDressesPageVerificationText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='layered_price_slider']")
    WebElement mainSlider;

    @CacheLookup
    @FindBy(xpath = "//div[@id='left_column']//a[2]")
    WebElement slider;

    public void addPrintedChiffonDressToCart() {
        pmClickOnElement(printedChiffonDress);
        pmClickOnElement(addToCart);
    }

    public void verifySummerDressesPageVerificationText(String message){
        Reporter.log("verifying summer page text : " + summerDressesPageVerificationText.toString() + "<br>");
        pmVerifyElements(summerDressesPageVerificationText, message, "Incorrect page");
    }

    public void moveSliderToChangePrice(){
        Reporter.log("moving slider to change price : " + slider.toString() + "<br>");
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, -183, 0).build().perform();
    }

}
