package TestCase;

import BaseClass.TestBase;
import DamaskPageHelper.ShopNow;
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
        ShopNow shopNow=new ShopNow(driver);
        LoginPage loginPage=new LoginPage(driver);
        shopNow.Wait_For_Shop_Now();
        shopNow.Go_For_Bake();
        loginPage.Go_to_Login_In();
        loginPage.LoginToApplication();
        loginPage.Go_to_Account_tab();
        shopNow.Go_For_Bake();
    }


}
