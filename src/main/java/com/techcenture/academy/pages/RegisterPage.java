package com.techcenture.academy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Map;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    protected WebElement enterAccountHeader;

    @FindBy(xpath = "//input[@id='id_gender2']")
    protected WebElement titleGenderMs;

    @FindBy(id = "id_gender1")
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

       @FindBy(xpath = "//h2[@data-qa='account-created']")
    protected WebElement AccountCreatedHeader;

    @FindBy(xpath = "//div[@class='pull-right']/a")
    protected WebElement clickContinueBtn;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    protected WebElement createAccountBtn;


    public void VerifyEnterAccountHeader() {
      Assert.assertTrue(enterAccountHeader.isDisplayed());
    }
    public void pickGenderTitle(Map<String ,String> data){
        if (data.get("Gender").equalsIgnoreCase("Mr")){
            titleGenderMr.click();
        }else {
            titleGenderMs.click();
        }
    }
    public void setPasswordInput(Map<String ,String> data){
        passwordInput.sendKeys(data.get("Password"));
    }



    public void selectDateOfBirth(Map<String ,String> data) {
        Select selectDays = new Select(daysDropDown);
        selectDays.selectByVisibleText(data.get("bDay"));
        Select selectMonths = new Select(monthsDropDown);
        selectMonths.selectByVisibleText(data.get("bMonth"));
        Select selectYears = new Select(yearsDropDown);
        selectYears.selectByVisibleText(data.get("bYear"));
    }

    public void selectCountry(Map<String ,String> data) {
        Select selectCountry = new Select(countryDropDown);
        countryDropDown.click();
        selectCountry.selectByVisibleText(data.get("Country"));
    }
    public void selectNewsletterSpOffers(){
        if(!newsLetterCheckBox.isSelected()){
            newsLetterCheckBox.click();
        }
        if (!specialOfferCheckBox.isSelected()){
            specialOfferCheckBox.click();
        }
    }

    public void enterCustomerInfo(Map<String ,String> data){
        firstNameInput.sendKeys(data.get("FirstName"));
        lastNameInput.sendKeys(data.get("LastName"));
        companyInput.sendKeys(data.get("Company"));
        addressInput.sendKeys(data.get("StreetAddress"));
        selectCountry(data);
        stateInput.sendKeys(data.get("State"));
        cityInput.sendKeys(data.get("City"));
        zipCodeInput.sendKeys(data.get("Zip"));
        mobileNumberInput.sendKeys(data.get("Phone"));
    }
    public void clickCreateAccountBtn() throws InterruptedException {
        Thread.sleep(1000);
        createAccountBtn.click();
    }


}
