package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AuthenticationPage extends Utility {

    public AuthenticationPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "email_create")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAnAccount;

    public void enterRandomEmailInTheEmailAddressField(){
        Reporter.log("entering random email : "+"<br>");
        pmSendTextToElement(emailAddressField, randomString()+"@gmail.com");

    }

    public void clickOnCreateAnAccountTab(){
        Reporter.log("Click on the create an account tab : " + createAnAccount.toString() + "<br>");
        pmClickOnElement(createAnAccount);

    }
}
