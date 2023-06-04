package com.techcenture.academy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    protected WebElement signUpBtn;
    @FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[3]/a")
    protected WebElement cartBtn;
    @FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[2]/a")
    protected WebElement productsBtn;
    @FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[1]/a")
    protected WebElement homeBtn;
    @FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[5]/a")
    protected WebElement testCasesBtn;
    @FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[8]/a")
    protected WebElement contactUsBtn;
    @FindBy(id = "scrollUp")
    protected WebElement scrollUpBtn;





}
