package Tests;

import com.parabank.webpages.AccountOverview;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static utilities.GenericMethods.waitForElementClickable;
import static utilities.GenericMethods.waitForSearchResults;
import static utilities.ReadDataFromExcelFile.readExcel;

public class AccountOverviewTest extends TestBase {

    AccountOverview AccountOverview = new AccountOverview(chromeDriver);

    @DataProvider(name = "test-data")
    public Object[][] readData() throws Exception {
        Object[][] hashMapObj = readExcel("src\\main\\resources", "BillPay.xlsx", "Sheet1");
        return hashMapObj;

    }
    @Test(dataProvider = "test-data" , priority = 3)

         public void OverViewTest_011(HashMap<String, String> projectDetails) throws InterruptedException {
        waitForSearchResults();
        waitForElementClickable(AccountOverview.overviewLink, 2);
        AccountOverview.overviewLink.click();

       // Assert.assertTrue(AccountOverview.getPageHeader.isDisplayed());
        AccountOverview.OverviewInfo(projectDetails);
        System.out.println("--- Congratulations Loan has been approved ---");
        Assert.assertTrue(AccountOverview.AccountsuccessOverview.isDisplayed());
    }
}