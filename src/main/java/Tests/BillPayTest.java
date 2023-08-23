package Tests;
import com.parabank.webpages.BillPay;
import com.parabank.webpages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.GenericMethods;
import java.util.HashMap;
import static utilities.GenericMethods.waitForElementClickable;
import static utilities.GenericMethods.waitForSearchResults;
import static utilities.ReadDataFromExcelFile.readExcel;

public class BillPayTest extends TestBase {
    BillPay BillPay = new BillPay(chromeDriver);

   LoginPage loginPage= new LoginPage(chromeDriver);
    GenericMethods genericMethods = new GenericMethods();


    @DataProvider(name = "test-data")
    public Object[][] readData() throws Exception {
        Object[][] hashMapObj = readExcel("src\\main\\resources","BillPay.xlsx","Sheet1");
        return hashMapObj;
    }

    @Test( dataProvider = "test-data" , priority = 2)
    public void BillTest_01(HashMap<String, String> projectDetails) throws InterruptedException {
        waitForSearchResults();
        waitForElementClickable(BillPay.BillPayLink, 2);
        BillPay.BillPayLink.click();
        Assert.assertTrue(BillPay.getPageHeader.isDisplayed());
        BillPay.fillBillpayinfo(projectDetails);
       Thread.sleep(2000);
        Assert.assertTrue(BillPay.SuccessHeader.isDisplayed());
        System.out.println("--- Congratulations Loan has been approved ---");

    }
}