package Tests;

import com.parabank.webpages.OpenNewAccount;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static utilities.GenericMethods.waitForElementClickable;
import static utilities.GenericMethods.waitForSearchResults;
import static utilities.ReadDataFromExcelFile.readExcel;

public class OpenNewAccountTest extends TestBase
{
    OpenNewAccount openNewAccount = new OpenNewAccount(chromeDriver);

    @DataProvider(name = "test-data")
    public Object[][] readData () throws Exception
    {
        Object[][] hashMapObj = readExcel("src\\main\\resources", "RegisterData.xlsx", "Sheet1");
        return hashMapObj;
    }

    @Test( dataProvider = "test-data" , groups = {"Regression"}, priority = 3)
    public void TestNewAccount_01(HashMap< String, String > projectDetails) throws InterruptedException {
        waitForSearchResults();
        waitForElementClickable(openNewAccount.AccountLink,2);
        openNewAccount.AccountLink.click();
        Assert.assertTrue(openNewAccount.openacctpageHeader.isDisplayed());
        openNewAccount.FillNewAccountData(projectDetails);
        System.out.println("--- User is registered and new login has been created ---");
        Assert.assertTrue(openNewAccount.SuccessheaderFile.isDisplayed());
    }
}

