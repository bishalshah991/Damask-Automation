package TestCase;

import BaseClass.TestBase;
import DamaskPages.Register;
import Utility.ReadJsonData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterPageTest extends TestBase {

    Register signPage;
    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("Browser"));
        signPage=new Register(driver);
    }

    @Test(priority = 1)
    public void Go_to_shop_Now_test(){
        signPage.Go_to_shop_Now();
    }

    @Test(priority = 2)
    public void Go_to_Add_to_Cart_test(){
        signPage.Go_to_Add_to_Cart();
    }

    @Test(priority = 3)
    public void Go_to_Add_Cart_Icon_test(){
        signPage.Go_to_Add_Cart_Icon();
    }

    @Test(priority = 4)
    public void Enter_Delivery_Address_test() throws IOException, ParseException, InterruptedException {
        signPage.Enter_Delivery_Address();
        signPage.Enter_First_and_Last_Name();
        signPage.Select_Country();
        signPage.Enter_City_Zip_Phone_Number();
        signPage.Click_Continue_Button();
    }

    @Test(priority = 5)
    public void Go_to_Payment_test() throws InterruptedException, IOException, ParseException {
        signPage.Go_to_Payment();
    }




}
