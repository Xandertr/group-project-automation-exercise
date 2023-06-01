package com.techcenture.academy;

import com.techcenture.academy.pages.HomePage;
import com.techcenture.academy.pages.RegisterPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private HomePage homePage;

    private RegisterPage registerPage;
    @Test
    public void loginTest(){
        homePage =new HomePage(driver);
        homePage.navigateToUrl();
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
