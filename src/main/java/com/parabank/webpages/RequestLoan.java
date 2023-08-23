package com.parabank.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import static utilities.GenericMethods.*;
public class RequestLoan extends Basepage{
    WebDriver driver;

    public RequestLoan(WebDriver driver) {
            super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//li[7]/a")
    public WebElement RequestLink;
    @FindBy(css="h1.title")
    public WebElement GetRequestHeader;
    @FindBy(id="amount")
    public WebElement LoanAmount;
    @FindBy(id="downPayment")
    public WebElement DownPayment;
    @FindBy(id="fromAccountId")
    public WebElement FromAccountDropDown;
    @FindBy(css="input.button")
    public WebElement ApplyButton;

    @FindBy(xpath="//div[2]/div/div/div/p")
    public WebElement Loansuccessheader;

  //  @FindBy(xpath="//div[@id='rightPanel']/div/div/div/p")
 //   public WebElement  CongratulationsMsg;
    public void FillNewLoanData(HashMap<String, String> projectDetails)
            throws InterruptedException{

        elementClick(RequestLink);

        waitForElementClickable(LoanAmount,5);
        clickAndEnterText(LoanAmount,projectDetails.get("LoanAmount"));

        waitForElementClickable(DownPayment,5);
        clickAndEnterText(DownPayment,projectDetails.get("DownPayment"));

        waitForElementClickable(FromAccountDropDown , 5);
        clickAndSelect(FromAccountDropDown);

        waitForElementClickable(ApplyButton,5);
        ApplyButton.click();

        System.out.println("new account Created successfully");
    }
}






