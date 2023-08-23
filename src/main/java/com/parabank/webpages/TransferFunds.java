package com.parabank.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericMethods;

import java.util.HashMap;

import static utilities.GenericMethods.*;
public class TransferFunds extends Basepage{
    WebDriver driver;
    public TransferFunds(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//a[contains(text(),'Transfer Funds')]")
    public WebElement TransferFundsLink;

    @FindBy(id="amount")
    public WebElement EnterAmount;
    @FindBy(id="fromAccountId")
    public WebElement fromAccountIdDropdown;
    @FindBy(id="toAccountId")
    public WebElement toAccountIDropdown;

    //@FindBy(xpath="input[@value='Transfer']")
    @FindBy(css="input.button")
    public WebElement TransferButton;
    @FindBy(xpath="//div[@id='rightPanel']/div/div/h1")
    public WebElement SuccessHeaderFile;

    public void FillNewAccountData(HashMap<String, String> projectDetails)
            throws InterruptedException{

       elementClick(TransferFundsLink);

        waitForElementClickable(EnterAmount,5);
        clickAndEnterText(EnterAmount,projectDetails.get("Amount"));

        waitForElementClickable(fromAccountIdDropdown, 5);
        clickAndSelect(fromAccountIdDropdown);

        waitForElementClickable(toAccountIDropdown, 5);
        clickAndSelect(toAccountIDropdown);

        GenericMethods.waitForElementClickable(TransferButton,5);
        TransferButton.click();

        System.out.println("Transfer account Created successfully");
    }



}