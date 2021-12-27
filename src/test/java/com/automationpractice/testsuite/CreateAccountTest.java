package com.automationpractice.testsuite;

import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;


public class CreateAccountTest extends TestBase {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;

    @BeforeMethod(groups = {"smoke", "sanity", "regression"})
    public void init1() {
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        createAccountPage = new CreateAccountPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity", "regression"}, dataProvider = "Valid Credentials", dataProviderClass = TestData.class)
    public void customerCanCreateANewAccountUsingValidDetails
            (String name, String surname, String password,
             String address, String city, String state,
             String postcode, String mobileNumber,
             String message, String accountName) {


        homePage.clickOnSignInButton();

        authenticationPage.enterRandomEmailInTheEmailAddressField();

        authenticationPage.clickOnCreateAnAccountTab();

        createAccountPage.fillMandatoryFields(name, surname, password, address, city, state, postcode, mobileNumber);

        createAccountPage.clickOnRegister();

        createAccountPage.verifyMyAccountText(message);

        myAccountPage.verifyUserCanSeeAccountNameOnTopRight(accountName);
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "Invalid Credentials", dataProviderClass = TestData.class)
    public void userWillGetAnErrorMessageWhileCreatingAccountWithInvalidDetails
            (String name, String surname, String password,
             String address, String city, String state,
             String postcode, String mobileNumber,
             String message) {

        homePage.clickOnSignInButton();

        authenticationPage.enterRandomEmailInTheEmailAddressField();

        authenticationPage.clickOnCreateAnAccountTab();

        createAccountPage.fillMandatoryFields(name, surname, password, address, city, state, postcode, mobileNumber);

        createAccountPage.clickOnRegister();

        createAccountPage.verifyErrorMessage(message);

    }


}
