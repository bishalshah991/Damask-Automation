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

    @Test
    public void Login_to_Application() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.Login_to_Application();
        loginPage.Go_to_Account_tab();
        loginPage.Log_out_From_Application();

    }


}
