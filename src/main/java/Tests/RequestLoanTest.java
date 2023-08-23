package Tests;

import com.parabank.webpages.RequestLoan;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static utilities.GenericMethods.waitForElementClickable;
import static utilities.GenericMethods.waitForSearchResults;
import static utilities.ReadDataFromExcelFile.readExcel;

public class RequestLoanTest extends  TestBase {

  RequestLoan RequestLoan = new RequestLoan(chromeDriver);

    @DataProvider(name = "test-data")
    public Object[][] readData() throws Exception {
        Object[][] hashMapObj = readExcel("src\\main\\resources", "RegisterData.xlsx", "Sheet1");
        return hashMapObj;
    }
    @Test(dataProvider = "test-data" , priority = 3)
    public void RequestTest_01(HashMap<String, String> projectDetails) throws InterruptedException {
       waitForSearchResults();
        waitForElementClickable(RequestLoan.RequestLink, 2);
        RequestLoan.RequestLink.click();
        Assert.assertTrue(RequestLoan.GetRequestHeader.isDisplayed());

        RequestLoan.FillNewLoanData(projectDetails);


        Assert.assertTrue(RequestLoan.Loansuccessheader.isDisplayed());



        System.out.println("--- Congratulations,New Account Link Created succesfully ---");


    }
}