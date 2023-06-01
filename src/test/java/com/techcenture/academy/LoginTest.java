package com.techcenture.academy;

import com.relevantcodes.extentreports.LogStatus;
import com.techcenture.academy.pages.HomePage;
import com.techcenture.academy.pages.RegisterPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private HomePage homePage;

    private RegisterPage registerPage;
    @Test
    public void loginTest(){
        extentTest = extentReports.startTest("login positive test");
        homePage =new HomePage(driver);
        homePage.navigateToUrl();
        extentTest.log(LogStatus.INFO, "initiate web-driver successfully");
        homePage.VerifyTitle();
        homePage.clickLogin();
        homePage.verifyNewUserSignup();
        homePage.enterSignUpCredentials();
        homePage.clickSignUpBtn();
    }

    @Test
    public void registerPageTest() throws InterruptedException {
        loginTest();
        registerPage=new RegisterPage(driver);
        registerPage.VerifyRegisterPageTitle();
        registerPage.selectCountry();
        registerPage.enterAddressCredentials();
        registerPage.setPasswordInput();
        registerPage.clickCreateAccountBtn();
    }


}
