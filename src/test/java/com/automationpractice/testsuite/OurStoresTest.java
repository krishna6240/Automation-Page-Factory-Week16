package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.OurStoresPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OurStoresTest extends TestBase {

    HomePage homePage;
    OurStoresPage ourStoresPage;

    @BeforeMethod(groups = {"smoke","sanity", "regression"})
    public void init(){
       homePage = new HomePage();
       ourStoresPage = new OurStoresPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void userCanDragTheMapAndTakeScreenshot() {

        homePage.selectFromInformationFooter("Our stores");

        ourStoresPage.acceptTheGooglePopUpAlert();

        ourStoresPage.scrollMapToSeeWestPalmBeach();

        ourStoresPage.scrollPageDown();

        ourStoresPage.takeScreenshot();
    }
}
