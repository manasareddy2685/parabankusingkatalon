package com.parabank.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

import static utilities.GenericMethods.*;

public class BillPay extends Basepage {
    public BillPay(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
}
       @FindBy(xpath = "//div[@id='leftPanel']/ul/li[4]/a")
       public WebElement BillPayLink;
       @FindBy(xpath="//h1")
       public WebElement getPageHeader;
       @FindBy(name="payee.name")
       public WebElement payeeName;
       @FindBy(name="payee.address.street")
      public WebElement payAddress;
       @FindBy(name="payee.address.city")
        public WebElement payCity;
       @FindBy(name="payee.address.state")
      public WebElement payState;
       @FindBy(name="payee.address.zipCode")
       public WebElement Zipcode;
       @FindBy(name="payee.phoneNumber")
      public WebElement phoneNumber;
       @FindBy(name="payee.accountNumber")
       public WebElement accountNumber;

       @FindBy(xpath="//tr[9]/td[2]/input")
       public WebElement VerifyAccount;

       @FindBy(xpath="//input[@name='amount']")
       public WebElement Amount;

       @FindBy(xpath="//select[@name='fromAccountId']")
       public WebElement FromAccountIdDropDown;

       @FindBy(xpath="//input[@value='Send Payment']")
       public WebElement SendPaymentButton;
      @FindBy(xpath="//div[2]/h1")
      public WebElement SuccessHeader;
      public void fillBillpayinfo(HashMap<String, String> projectDetails) throws InterruptedException {

          elementClick(BillPayLink);

        waitForElementClickable(payeeName, 2);
        clickAndEnterText(payeeName, projectDetails.get("PayeeName"));

        waitForElementClickable(payAddress, 2);
        clickAndEnterText(payAddress, projectDetails.get("Address"));

        waitForElementClickable(payCity, 2);
        clickAndEnterText(payCity, projectDetails.get("City"));

        waitForElementClickable(payState, 2);
        clickAndEnterText(payState, projectDetails.get("State"));

        waitForElementClickable(Zipcode, 2);
        clickAndEnterText(Zipcode, projectDetails.get("ZipCode"));

        waitForElementClickable(phoneNumber, 2);
        clickAndEnterText(phoneNumber, projectDetails.get("Phone"));

        waitForElementClickable(accountNumber, 2);
        clickAndEnterText(accountNumber, projectDetails.get("Account"));

        waitForElementClickable(VerifyAccount, 2);
        clickAndEnterText(VerifyAccount, projectDetails.get("VerifyAccount"));

        waitForElementClickable(Amount, 2);
        clickAndEnterText(Amount,projectDetails.get("NewAmount"));

        waitForElementClickable(FromAccountIdDropDown , 2);
          clickAndSelect(FromAccountIdDropDown);

        waitForElementClickable(SendPaymentButton, 2);
          SendPaymentButton.click();


        System.out.println("Bill Created successfully");
    }

}












