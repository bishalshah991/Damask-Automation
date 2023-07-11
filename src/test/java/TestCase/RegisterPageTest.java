package TestCase;

import BaseClass.TestBase;
import DamaskPages.Register;
import Utility.ReadJsonData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterPageTest extends TestBase {



    @Test
    public void Go_to_shop_Now_test() throws IOException, ParseException, InterruptedException {
        Register register=new Register(driver);
        register.Go_to_shop_Now();
        register.Go_to_Add_to_Cart();
        register.Go_to_Add_Cart_Icon();
        register.Enter_Delivery_Address();
        register.Enter_First_and_Last_Name();
        register.Select_Country();
        register.Enter_City_Zip_Phone_Number();
        register.Click_Continue_Button();
        register.Go_to_Payment();
    }




}
