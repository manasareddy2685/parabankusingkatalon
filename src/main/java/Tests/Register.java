package Tests;

import com.parabank.webpages.LoginPage;
import com.parabank.webpages.RegisterUI;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.GenericMethods;

import java.util.HashMap;

import static utilities.GenericMethods.waitForSearchResults;
import static utilities.ReadDataFromExcelFile.readExcel;

        public class Register extends TestBase
        {

               RegisterUI registerUI = new RegisterUI(chromeDriver);

                LoginPage loginPage = new LoginPage(chromeDriver);
                GenericMethods genericMethods = new GenericMethods();

            @DataProvider(name = "test-data")
                public Object[][] readData () throws Exception
                {
                    Object[][] hashMapObj = readExcel("src\\main\\resources", "RegisterData.xlsx", "Sheet1");
                    return hashMapObj;
                }

        @Test (dataProvider = "test-data",priority = 0)
        public void ClickRegister_TCc01 (HashMap< String, String > projectDetails) throws InterruptedException {
            registerUI.RegisterLink.click();
            waitForSearchResults();
            Assert.assertTrue(registerUI.registerPageHeader.getText().contains("Signing up"), "Register - signing up page is displayed");
            System.out.println(" Register link is clicked successfully ");
            registerUI.fillRegisterInfo(projectDetails);
            System.out.println("--- User is registered and new login has been created ---");
            Assert.assertTrue(registerUI.getRegisterSuccessHeader.getText().contains("Welcome " + projectDetails.get("Username")));
        }
    }



