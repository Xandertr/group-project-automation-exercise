package com.techcenture.academy;

import com.relevantcodes.extentreports.LogStatus;
import com.techcenture.academy.pages.HomePage;
import com.techcenture.academy.utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class verifySubscription extends BaseTest {

    private HomePage homePage;

    @Test(dataProvider = "CustomerInfo")
    public void verifySubscriptionTestHomePage(Map<String, String> data) throws InterruptedException {
        extentTest = extentReports.startTest("Verify Subscription Test on Home Page for: " + data.get("Email"));
        homePage = new HomePage(driver);
        homePage.navigateToUrl();
        extentTest.log(LogStatus.INFO, "initiate web-driver successfully");
        homePage.VerifyTitle();
        extentTest.log(LogStatus.PASS, "verify title of the home page");
        homePage.verifyTextSubscription();
        extentTest.log(LogStatus.PASS, "verify text SUBSCRIPTION is on the page");
        homePage.scrollDownToEmailInput();
        extentTest.log(LogStatus.INFO, "scrolled down to the Enail input box");
        Thread.sleep(1000);
        homePage.enterSubscriptionEmail(data);
        extentTest.log(LogStatus.INFO, "pass email: " + data.get("Email") + " to the email box");
        Thread.sleep(1000);
        homePage.arrowBtnClick();
        extentTest.log(LogStatus.INFO, "clicking arrow button and verifying success message");
    }
    @Test(dataProvider = "CustomerInfo")
    public void verifySubscriptionTestCartPage(Map<String, String> data) {
        extentTest = extentReports.startTest("Verify Subscription Test on Cart Page for: " + data.get("Email"));
        homePage = new HomePage(driver);
        homePage.navigateToUrl();
        extentTest.log(LogStatus.INFO, "initiate web-driver successfully");
        homePage.VerifyTitle();
        extentTest.log(LogStatus.PASS, "verify title of the home page");
        homePage.cartBtnClick();
        extentTest.log(LogStatus.INFO, "clicked on cart button");
        homePage.verifyTextSubscription();
        extentTest.log(LogStatus.PASS, "verify text SUBSCRIPTION is on the page");
        homePage.enterSubscriptionEmail(data);
        extentTest.log(LogStatus.INFO, "pass email: " + data.get("Email") + " to the email box");
        homePage.arrowBtnClick();
        extentTest.log(LogStatus.INFO, "clicking arrow button and verifying success message");
    }


        @DataProvider(name = "CustomerInfo")
        public Object[][] getCreateCustomerData(){
            Object[][] reader = new ExcelReader("src/main/resources/Auto-Exercise.xlsx","customer").getData();
            return reader;
        }

        @Test(dataProvider = "CustomerInfo")
        public void test1 (Map < String, String > data){
            System.out.println(data);
        }
    }

