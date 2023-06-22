package TestCase;

import BaseClass.TestBase;
import DamaskPages.LoginPage;
import Utility.ReadJsonData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("Browser"));
        loginPage=new LoginPage(driver);
    }
    @Test(priority = 1)
    public void Login_to_Application_test() throws IOException, ParseException {
        loginPage.Login_to_Application();
    }
    @Test(priority = 2)
    public void Go_Account_tab_test(){
        loginPage.Go_to_Account_tab();
    }

    @Test(priority = 3)
    public void Log_out_From_Application() throws InterruptedException {
        loginPage.Log_out_From_Application();
    }
    @AfterClass
    public void Quit_Application(){
        driver.quit();
    }
}
