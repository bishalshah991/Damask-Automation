package Utility;

import BaseClass.TestBase;
import Verificaion.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper extends TestBase {
    WaitHelper waitHelper;

    public DropDownHelper(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,10);
    }



    public void SelectUsingVisibleValue(WebElement element1, String visibleValue)
    {
        Select select = new Select(element1);
        select.selectByVisibleText(visibleValue);
    }
}
