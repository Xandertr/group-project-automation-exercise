package com.techcenture.academy.testCases.test1;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.techcenture.academy.BaseTest;
import com.techcenture.academy.pages.HomePage;
import com.techcenture.academy.pages.RegisterPage;
import com.techcenture.academy.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    private HomePage homePage;


    private RegisterPage registerPage;
    @Test(dataProvider = "CustomerInfo")
    public void loginTest(Map<String,String>data){
        extentTest = extentReports.startTest("login positive test: " + data.get("FullName"));
        homePage =new HomePage(driver);
        homePage.navigateToUrl();
        extentTest.log(LogStatus.INFO, "initiate web-driver successfully");
        homePage.VerifyTitle();
        extentTest.log(LogStatus.PASS, "verify title of the home page");
        homePage.clickLogin();
        extentTest.log(LogStatus.INFO, "login successfully");
        homePage.verifyNewUserSignup();
        extentTest.log(LogStatus.PASS, "verify new user sign up");
        homePage.enterSignUpCredentials(data);
        extentTest.log(LogStatus.INFO, "enter credentials");
        homePage.clickSignUpBtn();
        extentTest.log(LogStatus.INFO, "click sign up button");
    }

    @Test(dataProvider = "CustomerInfo")
    public void registerPageTest(Map<String,String>data) throws InterruptedException {
          loginTest(data);
          registerPage=new RegisterPage(driver);
//          registerPage.pickGenderTitle(data);
//          registerPage.setPasswordInput(data);
//          registerPage.selectDateOfBirth(data);
        registerPage.VerifyRegisterPageTitle();
//        registerPage.selectCountry();
        registerPage.enterAddressCredentials(data);
//        registerPage.setPasswordInput();
        registerPage.clickCreateAccountBtn();
    }
    @DataProvider(name = "CustomerInfo")
    public Object[][] getCreateCustomerData(){
        Object[][] reader = new ExcelReader("src/main/resources/Auto-Exercise.xlsx","customer").getData();
        return reader;
    }

    @Test(dataProvider = "CustomerInfo")
    public void test1(Map<String,String> data){
        System.out.println(data);
    }


}
