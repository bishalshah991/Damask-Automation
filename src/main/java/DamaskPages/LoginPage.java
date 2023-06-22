package DamaskPages;

import BaseClass.TestBase;
import Utility.ReadJsonData;
import Verificaion.Assertion;
import Verificaion.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase {
    WaitHelper waitHelper;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,10);
    }

    @FindBy(xpath = "//a[contains(text(),'Log In')]")
    public WebElement Login_IN_tab;

    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    public WebElement Log_In_Button;

    @FindBy(xpath = "//div[@class='login form-section']/div/div/div[1]/div[1]/input")
    public WebElement Text_UserName;

    @FindBy(xpath = "//div[@class='login form-section']/div/div/div[1]/div[2]/input")
    public WebElement Text_PassWord;

    @FindBy(xpath = "//div[contains(text(),'Login Successfully')]")
    WebElement Text_Login_Successfully;
    @FindBy(xpath = "//a[contains(text(),'ACCOUNT')]")
    public WebElement Account;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement Logout;

    @FindBy(xpath = "//div[contains(text(),'Logout Successfully')]")
    WebElement Text_Logout;

    public void Login_to_Application() throws IOException, ParseException {
        waitHelper.Go_to_Wait_for_Element(new Register(driver).ShopNow);
        Login_IN_tab.click();
        waitHelper.Go_to_Wait_for_Element(Log_In_Button);
        String u_name=new ReadJsonData().ReadJSONData("Username");
        String p_password=new ReadJsonData().ReadJSONData("Password");
        Text_UserName.sendKeys(u_name);
        Text_PassWord.sendKeys(p_password);
        Log_In_Button.click();
        waitHelper.Go_to_Wait_for_Element(Text_Login_Successfully);
        Assertion.Verify_the_an_Element(Text_Login_Successfully);
        waitHelper.Go_to_Wait_for_Element(Account);
    }

    public void Go_to_Account_tab(){
        Account.click();
        waitHelper.Go_to_Wait_for_Element(Logout);
    }

    public void Log_out_From_Application() throws InterruptedException {
        Logout.click();
        waitHelper.Go_to_Wait_for_Element(Text_Logout);
        Assertion.Verify_the_an_Element(Text_Logout);
        Thread.sleep(3000);
    }
}
