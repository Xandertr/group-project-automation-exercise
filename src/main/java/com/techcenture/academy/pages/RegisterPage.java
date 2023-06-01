package com.techcenture.academy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class RegisterPage {

    private static WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    protected WebElement enterAccountHeader;

    @FindBy(xpath = "//input[@id='id_gender2']")
    protected WebElement titleGenderMs;

    @FindBy(xpath = "//input[@id='id_gender1']")
    protected WebElement titleGenderMr;

    @FindBy(xpath = "//select[@name='days']")
    protected WebElement daysDropDown;

    @FindBy(xpath = "//select[@name='months']")
    protected WebElement monthsDropDown;

    @FindBy(xpath = "//select[@name='years']")
    protected WebElement yearsDropDown;

    @FindBy(xpath = "//input[@id='first_name']")
    protected WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last_name']")
    protected WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='company']")
    protected WebElement companyInput;

    @FindBy(xpath = "//input[@id='address1']")
    protected WebElement addressInput;

    @FindBy(xpath = "//select[@name='country']")
    protected WebElement countryDropDown;

    @FindBy(xpath = "//input[@id='state']")
    protected WebElement stateInput;

    @FindBy(xpath = "//input[@id='city']")
    protected WebElement cityInput;

    @FindBy(xpath = "//input[@id='zipcode']")
    protected WebElement zipCodeInput;

    @FindBy(xpath = "//input[@id='mobile_number']")
    protected WebElement mobileNumberInput;

    @FindBy(id = "password")
    protected WebElement passwordInput;

    @FindBy(id="newsletter")
    protected WebElement newsLetterCheckBox;

    @FindBy(id="optin")
    protected WebElement specialOfferCheckBox;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    protected WebElement createAccountBtn;

    public void VerifyRegisterPageTitle() {
        String registerPageTitle = driver.getTitle();
        Assert.assertTrue(enterAccountHeader.isDisplayed());
    }

    public void selectDateOfBirth() {
        Select selectDays = new Select(daysDropDown);
        selectDays.selectByVisibleText("1");
        Select selectMonths = new Select(monthsDropDown);
        selectMonths.selectByVisibleText("March");
        Select selectYears = new Select(yearsDropDown);
        selectYears.selectByVisibleText("1999");
    }

    public void selectCountry() {
        Select selectCountry = new Select(countryDropDown);
        selectCountry.selectByIndex(0);

    }

    public void enterAddressCredentials(){
        pickGenderTitle();
        setPasswordInput();
        selectDateOfBirth();
        if(!newsLetterCheckBox.isSelected()){
            newsLetterCheckBox.click();
        }
        if (!specialOfferCheckBox.isSelected()){
            specialOfferCheckBox.click();
        }
        firstNameInput.sendKeys("Joseph");
        lastNameInput.sendKeys("greenberg");
        companyInput.sendKeys("techcenture");
        addressInput.sendKeys("123 Washington street");
        stateInput.sendKeys("Virginia");
        cityInput.sendKeys("Arlington");
        zipCodeInput.sendKeys("22145");
        mobileNumberInput.sendKeys("577777777");
    }

    public void pickGenderTitle(){
        titleGenderMr.click();
    }

    public void setPasswordInput(){
        passwordInput.sendKeys("159753");
    }

    public void clickCreateAccountBtn() throws InterruptedException {
        Thread.sleep(5000);
        createAccountBtn.click();
    }


}
