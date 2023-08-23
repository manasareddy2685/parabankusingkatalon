package Tests;

import com.parabank.webpages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.GenericMethods;

import java.util.HashMap;

import static utilities.GenericMethods.waitForElementClickable;
import static utilities.GenericMethods.waitForSearchResults;
import static utilities.ReadDataFromExcelFile.readExcel;
public class LoginTest extends TestBase

{

    LoginPage loginPage = new LoginPage(chromeDriver);
    GenericMethods genericMethods = new GenericMethods();

    @DataProvider(name = "test-data")
    public Object[][] readData() throws Exception {
        Object[][] hashMapObj = readExcel("src\\main\\resources", "RegisterData.xlsx", "Sheet1");
        return hashMapObj;
    }
    //
    @Test(dataProvider = "test-data")
    public void LaunchLoginUI_TC01(HashMap<String, String>projectDetails) throws InterruptedException {

        waitForSearchResults();
        loginPage.enterUsername(projectDetails.get("Username"));
        loginPage.enterPassword(projectDetails.get("Password"));

        //using Property_File {

           //loginPage.enterUsername(PropertyReader.getProperty("username"));
          //loginPage.enterPassword(PropertyReader.getProperty("password"));

            waitForElementClickable(loginPage.loginButton, 2);
            loginPage.clickLoginButton();
            Assert.assertTrue(loginPage.loginWelcomeHeader.getText().contains("Accounts"));
       // Assert.assertTrue(loginPage.loginWelcomeHeader.isDisplayed());
            System.out.println("Login success");
        }

    }


