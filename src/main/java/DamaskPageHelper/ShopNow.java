package DamaskPageHelper;

import BaseClass.TestBase;
import DamaskPages.LoginPage;
import Utility.ReadJsonData;
import Verificaion.Assertion;
import Verificaion.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ShopNow extends TestBase {
    WaitHelper waitHelper;
    public ShopNow(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
    }


    @FindBy(xpath = "//div[starts-with(@class,'overlay-content')]/div/div[3]/button")
    public WebElement ShopNow;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement EmailAddress;

    @FindBy(xpath = "//div[starts-with(@role,'dialog')]/div/div/form/div[2]/button")
    WebElement SubscribeButton;

    public void Wait_For_Shop_Now(){
        waitHelper.Go_to_Wait_for_Element(ShopNow);
        Assertion.Verify_the_an_Element(ShopNow);
    }

    public void Go_For_Bake() throws IOException, ParseException {

        try {
            if (SubscribeButton.isDisplayed()){
                EmailAddress.sendKeys(new ReadJsonData().ReadJSONData("Username"));
                SubscribeButton.click();
            }
            else {
                System.out.println("Element is not Displayed");
                //new LoginPage(driver).Login_IN_tab.click();
            }
        }
        catch (Exception e){
            System.out.println("Element is not displayed:----"+e);
        }




    }



}
