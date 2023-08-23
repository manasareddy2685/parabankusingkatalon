package Tests;

import com.parabank.webpages.Logoutpage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;
import static utilities.GenericMethods.waitForElementClickable;
import static utilities.ReadDataFromExcelFile.readExcel;

public class LogoutTest extends TestBase
{
    Logoutpage logoutpage = new Logoutpage(chromeDriver);

    @DataProvider(name = "test-data")
    public Object[][] readData() throws Exception
    {

        Object[][] hashMapobj = readExcel("src\\main\\resources", "RegisterData.xlsx", "Sheet1");
        return hashMapobj;
    }
    @Test(dataProvider = "test-data",priority = 1)
        public void LaunchLogoutUI_TC01(HashMap < String, String > projectDetails) throws InterruptedException

    {
        waitForElementClickable(logoutpage.logoutLink,2);

            logoutpage.clickLogoutLink();
            Assert.assertTrue(logoutpage.homePageLogo.isDisplayed());

        }
    }


