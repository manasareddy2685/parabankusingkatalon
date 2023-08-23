package Tests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver chromeDriver;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
       chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("The setup process is completed");
    }

    @BeforeClass
    public void appSetup()
    {

        System.out.println("The app setup process is completed");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("I am in before method");
    }
    @BeforeTest
    public void profileSetup()
    {
        chromeDriver.get("https://parabank.parasoft.com/parabank/index.htm");
       chromeDriver.manage().window().maximize();
        System.out.println("The profile setup process is completed");

    }

    @AfterMethod
    public void screenShot() throws IOException, IOException {
        TakesScreenshot scr= ((TakesScreenshot)chromeDriver);
        File file1= scr.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file1, new File("C:\\Temp\\samplemavonproj\\parabank\\src\\test\\resources\\screenshots\\test1.PNG"));
        System.out.println("Screenshot of the test is taken");
    }

    @AfterClass
    public void closeUp()
    {
       // chromeDriver.quit();
        System.out.println("The close_up process is completed");
    }

    @AfterTest
    public void reportReady()
    {

        System.out.println("Report is ready to be shared, with screenshots of tests");
    }

    @AfterSuite
    public void cleanUp()
    {
        System.out.println("All close up activities completed");
        chromeDriver.quit();
    }

    @BeforeGroups("titleValidation")
    public void setUp() {
        System.out.println("url validation test starting");
    }

    @AfterGroups("titleValidation")
    public void tearDown() {
        //chromeDriver.quit();
        System.out.println("url validation test finished");
    }





}
