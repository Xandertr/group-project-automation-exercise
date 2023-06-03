package com.techcenture.academy.pages;

import com.techcenture.academy.config.ConfigReader;
import com.techcenture.academy.utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//input[@name='email'])[2]")
    protected WebElement emailAdressInput;
    @FindBy(xpath = "//input[@name='name']")
    protected WebElement nameInput;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    protected WebElement loginElement;

    @FindBy(xpath = "//div[@class='signup-form']/h2")
    protected WebElement newUserSignUpHeader;
    @FindBy(id = "susbscribe_email")
    protected WebElement subscriptionInput;
    @FindBy(id = "subscribe")
    protected WebElement arrowBtn;
    @FindBy(id = "success-subscribe")
    protected WebElement successSubscribe;
    @FindBy(xpath = "//div[@class='single-widget']/h2")
    protected WebElement textSubscription;





    public void navigateToUrl(){
        driver.get(ConfigReader.getProperty("url"));
    }
    public void VerifyTitle(){
        String WebsiteTitle = driver.getTitle();
    }

    public void clickLogin(){
        loginElement.click();
    }
    public void verifyNewUserSignup(){
        Assert.assertTrue(newUserSignUpHeader.isDisplayed());
    }

    public void enterSignUpCredentials(Map<String ,String> data){
        nameInput.sendKeys(data.get("FullName"));
        emailAdressInput.sendKeys(data.get("Email"));
    }
    public void clickSignUpBtn(){
        signUpBtn.click();
    }
    public void verifyTextSubscription(){
        Assert.assertTrue(textSubscription.isDisplayed());
    }
    public void enterSubscriptionEmail(Map<String ,String> data){
        subscriptionInput.sendKeys(data.get("Email"));
    }
    public void arrowBtnClick(){
        arrowBtn.click();
        Assert.assertTrue(successSubscribe.isDisplayed());
    }
    public void cartBtnClick(){
        cartBtn.click();
    }
    public void productsBtnClick(){
        productsBtn.click();
    }
}
