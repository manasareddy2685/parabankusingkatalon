package com.parabank.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import static utilities.GenericMethods.*;
public class RegisterUI extends Basepage {
    public RegisterUI(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "customer.firstName")
    public WebElement FirstName;
    @FindBy(id = "customer.lastName")
    public WebElement LastName;
    @FindBy(xpath="//input[@id='customer.address.street']")
    public WebElement Address;
    @FindBy(xpath="//input[@id='customer.address.city']")
    public WebElement CityInput;
    @FindBy(id="customer.address.state")
    public WebElement stateInput;

    @FindBy(xpath="//input[@id='customer.address.zipCode']")
    public WebElement zipcodeInput;

    @FindBy(xpath="//input[@id='customer.phoneNumber']")
    public WebElement phoneNumberInput;
    @FindBy(xpath="//input[@id='customer.ssn']")
    public WebElement ssnInput;

    @FindBy(id = "customer.username")
    public WebElement RegisterUserName;
    @FindBy(id="customer.password")
    public WebElement Password;
    @FindBy(xpath="//input[@id='repeatedPassword']")
    public WebElement RegisterConfirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement getRegisterButton;
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement RegisterLink;

    @FindBy(xpath = "//div[@id='rightPanel']/h1")
    public WebElement getRegisterSuccessHeader;

    @FindBy(xpath = "//*/text()[normalize-space(.)='Signing up is easy!']/parent::*")
    public WebElement registerPageHeader;

    public void fillRegisterInfo(HashMap<String, String> projectDetails) throws InterruptedException {

        waitForElementClickable(FirstName, 2);  //FirstName
        clickAndEnterText(FirstName, projectDetails.get("FirstName"));
// lastname
        waitForElementClickable(LastName, 2);
        clickAndEnterText(LastName, projectDetails.get("LastName"));

        waitForElementClickable( Address, 2);
        clickAndEnterText( Address, projectDetails.get("Address"));

        waitForElementClickable(CityInput, 2);
        clickAndEnterText(CityInput, projectDetails.get("City"));

        waitForElementClickable(stateInput, 2);
        clickAndEnterText(stateInput, projectDetails.get("State"));

        waitForElementClickable(zipcodeInput, 2);
        clickAndEnterText(zipcodeInput, projectDetails.get("ZipCode"));

        waitForElementClickable(phoneNumberInput, 2);
        clickAndEnterText(phoneNumberInput, projectDetails.get("Phone"));

        waitForElementClickable(ssnInput, 2);
        clickAndEnterText(ssnInput,projectDetails.get("SSN"));

        waitForElementClickable(RegisterUserName, 2);
        clickAndEnterText(RegisterUserName, projectDetails.get("Username"));

        waitForElementClickable(Password, 2);
        clickAndEnterText(Password, projectDetails.get("Password"));

        waitForElementClickable(RegisterConfirmPassword, 2);
        clickAndEnterText(RegisterConfirmPassword, projectDetails.get("Password"));

        waitForElementClickable(getRegisterButton, 2);
        getRegisterButton.click();
    }
}