package com.parabank.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericMethods;
import java.util.HashMap;
import static utilities.GenericMethods.*;

public class FindTransactions extends Basepage{
    WebDriver driver;
    public FindTransactions(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//a[contains(text(),'Find Transactions')]")
    public  WebElement FindLink;

    @FindBy(xpath="//div[@id='rightPanel']/div/div/h1")
    public WebElement pageHeader;

    @FindBy(id="accountId")
    public WebElement accountiddropdown;

    @FindBy(xpath="//input[@id='criteria.amount']")
    public WebElement CriteriaAmount;

    @FindBy(xpath="//div[9]/button")
    public WebElement TransactionButton;

    @FindBy(xpath="//div[@id='rightPanel']/div/div/h1")
    public WebElement TransactionHeader;


    public void FillFindtransactionData(HashMap<String, String> projectDetails)
            throws InterruptedException{

        elementClick(FindLink);

        waitForElementClickable( accountiddropdown , 5);
        clickAndSelect( accountiddropdown);

        waitForElementClickable(CriteriaAmount,5);
        clickAndEnterText(CriteriaAmount,projectDetails.get("NewAmount"));


        GenericMethods.waitForElementClickable(TransactionButton,5);
        TransactionButton.click();

        System.out.println("Fund Transfer Transferred successfully");

    }






}

