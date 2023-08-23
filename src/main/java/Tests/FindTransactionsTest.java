package Tests;

import com.parabank.webpages.FindTransactions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.GenericMethods;

import java.util.HashMap;

import static utilities.GenericMethods.waitForElementClickable;
import static utilities.GenericMethods.waitForSearchResults;
import static utilities.ReadDataFromExcelFile.readExcel;

public class FindTransactionsTest extends TestBase{



    FindTransactions FindTransactions = new FindTransactions(chromeDriver);
    GenericMethods genericMethods = new GenericMethods();
   //  this.datePickerPage = new DatePickerPage(driver);

    @DataProvider(name = "test-data")
    public Object[][] readData() throws Exception {
        Object[][] hashMapObj = readExcel("src\\main\\resources", "BillPay.xlsx", "Sheet1");
        return hashMapObj;
    }
    @Test (dataProvider = "test-data",priority = 2)
   public void TransactionTest_01(HashMap<String, String> projectDetails) throws InterruptedException {
       waitForSearchResults();
       waitForElementClickable(FindTransactions.FindLink, 2);
       FindTransactions.FindLink.click();
       Assert.assertTrue(FindTransactions.pageHeader.isDisplayed());


        FindTransactions.FillFindtransactionData(projectDetails);
       System.out.println("--- Bill Transaction is successful ---");
       Assert.assertTrue(FindTransactions.TransactionHeader.isDisplayed());

   }
}

