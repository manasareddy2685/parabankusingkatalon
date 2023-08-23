package Tests;

import com.parabank.webpages.TransferFunds;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static utilities.GenericMethods.waitForElementClickable;
import static utilities.ReadDataFromExcelFile.readExcel;
public class TransferFundsTest extends TestBase{

    TransferFunds TransferPage = new TransferFunds(chromeDriver);
   @DataProvider(name = "test-data")
    public Object[][] readData() throws Exception {
        Object[][] hashMapObj=readExcel("src\\main\\resources", "RegisterData.xlsx", "Sheet1");
        return hashMapObj;
    }

    @Test(dataProvider = "test-data", priority = 2)
      public void TestTransferFund_01(HashMap<String,String>projectDetails) throws InterruptedException {
        waitForElementClickable(TransferPage.TransferFundsLink,2);
        TransferPage.TransferFundsLink.click();
        TransferPage.FillNewAccountData(projectDetails);
        System.out.println("--- User is registered and new login has been created ---");
        Assert.assertTrue(TransferPage.SuccessHeaderFile.isDisplayed());
        // Assert.assertTrue(loginPage.loginWelcomeHeader.getText().contains("Accounts"));
        System.out.println("Fund is transferred successfully!!!!");
    }
}
