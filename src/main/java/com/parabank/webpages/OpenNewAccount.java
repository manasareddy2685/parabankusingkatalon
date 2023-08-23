package com.parabank.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import static utilities.GenericMethods.*;

public class OpenNewAccount extends Basepage {
        WebDriver driver;
    public OpenNewAccount(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
         @FindBy(xpath="//a[contains(text(),'Open New Account')]")
         public WebElement AccountLink;

        @FindBy(xpath="//div[@id='rightPanel']/div/div/h1")
        public WebElement openacctpageHeader;

         @FindBy(xpath="//select[@id='type']")
         public WebElement AccountType;

             @FindBy(xpath="//select[@id='type']")
             public WebElement TransferDropDown;

            @FindBy(xpath="//input[@value='Open New Account']")
            public WebElement Accountbutton;
            @FindBy(xpath="//div[@id='rightPanel']/div/div/h1")
            public WebElement SuccessheaderFile;

            public void FillNewAccountData(HashMap<String, String> projectDetails)
                throws InterruptedException{

                 waitForElementClickable(AccountType, 5);
                  selectDropdownElementByText(AccountType,projectDetails.get("AccountType")); // from excel..

                 waitForElementClickable(TransferDropDown , 5);
                 clickAndSelect(TransferDropDown);   //Transfer Account Number

                waitForElementClickable(Accountbutton,5);
                Accountbutton.click();

                System.out.println("new account Created successfully");
        }
 }




