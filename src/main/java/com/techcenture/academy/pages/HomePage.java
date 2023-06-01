package com.techcenture.academy.pages;

import com.techcenture.academy.config.ConfigReader;
import com.techcenture.academy.utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class HomePage {

    private static WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "(//input[@name='email'])[2]")
    protected WebElement emailAdressInput;
    @FindBy(xpath = "//input[@name='name']")
    protected WebElement nameInput;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    protected WebElement loginElement;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    protected WebElement signUpBtn;
    @FindBy(xpath = "//div[@class='signup-form']/h2")
    protected WebElement newUserSignUpHeader;


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
}
