package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CreateAccountPage extends Utility {

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstNameLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastNameLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityLink;
    @CacheLookup
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement stateLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='postcode']")
    WebElement zipPostalLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobilePhoneLink;
    @CacheLookup
    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement registerLink;
    @CacheLookup
    @FindBy (css = "div[class='alert alert-danger'] p")
    WebElement errorMessage;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountTextLink;

    public void fillMandatoryFields(String name, String surname, String password, String address, String city, String state, String postcode, String mobileNumber) {
        Reporter.log("Entering firstname" + firstNameLink.toString()+ "<br>");
        pmSendTextToElement(firstNameLink, name);
        Reporter.log("Entering lastname" + lastNameLink.toString()+ "<br>");
        pmSendTextToElement(lastNameLink, surname);
        Reporter.log("Entering password" + passwordLink.toString()+ "<br>");
        pmSendTextToElement(passwordLink, password);
        Reporter.log("Entering address" + addressLink.toString()+ "<br>");
        pmSendTextToElement(addressLink, address);
        Reporter.log("Entering city" + cityLink.toString()+ "<br>");
        pmSendTextToElement(cityLink, city);
        Reporter.log("Selecting the state" + stateLink.toString()+ "<br>");
        pmSelectByVisibleTextFromDropDown(stateLink, state);
        Reporter.log("Entering postalcode" + zipPostalLink.toString()+ "<br>");
        pmSendTextToElement(zipPostalLink, postcode);
        Reporter.log("Entering contact number" + mobilePhoneLink.toString()+ "<br>");
        pmSendTextToElement(mobilePhoneLink, mobileNumber);
    }

    public void clickOnRegister() {
        Reporter.log("Clicking on register link" + registerLink.toString()+ "<br>");
        pmClickOnElement(registerLink);
    }
    public void verifyMyAccountText(String message){
        Reporter.log("Verifying the message" + myAccountTextLink.toString()+ "<br>");
        pmVerifyElements(myAccountTextLink,message, "Message is not displayed correctly" );
    }

    public void verifyErrorMessage(String error) {
        Reporter.log("verifying error message : " + errorMessage.toString() + "<br>");
        Assert.assertTrue(errorMessage.getText().contains(error));
    }

}
