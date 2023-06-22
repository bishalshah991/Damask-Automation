package DamaskPages;

import BaseClass.TestBase;
import Utility.DropDownHelper;
import Utility.JavaScriptHelper;
import Utility.ReadJsonData;
import Verificaion.Assertion;
import Verificaion.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Register extends TestBase {
    WaitHelper waitHelper;

    public Register(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,30);
    }

    @FindBy(xpath = "//div[starts-with(@class,'overlay-content')]/div/div[3]/button")
    public WebElement ShopNow;

    @FindBy(xpath = "//select[@class='category']")
    WebElement TextCategory;

    @FindBy(xpath = "//div[@class='product-listing']/div/div/div/div[2]/div[1]/div[1]/div/div[1]/img[1]")
    WebElement ProductImage;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    WebElement Add_to_Cart_Button;

    @FindBy(xpath = "//button[contains(text(),'Proceed to Checkout')]")
    WebElement Proceed_to_Checkout;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement Yes;

    @FindBy(xpath = "//div[@class='checkout-box active']/img")
    WebElement Cross_Icon;

    /*
        Shopping Cart Icon
     */

    @FindBy(xpath = "//span[@class='links ts add-cart']/img")
    WebElement Shopping_Cart_Icon;

    @FindBy(xpath = "//h2[contains(text(),'Checkout')]")
    WebElement Label_Checkout;

    /*
        Delivery Address
     */

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[1]/div/input")
    WebElement Text_Email_Address;

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[2]/div/input")
    WebElement Text_Birthday;

    @FindBy(xpath = "(//span[@class='ck-checkmark'])[1]")
    WebElement CheckBox;


    /*
        Enter First Name, Last Name, Address
     */
    @FindBy(xpath = "//div[@class='delivery-address']/div/div[4]/div/input")
    WebElement Text_First_Name;

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[5]/div/input")
    WebElement Text_Last_Name;

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[6]/div/input")
    WebElement Text_Address;

    /*
        Country Drop DOwn
     */

    @FindBy(xpath = "//label[contains(text(),'Country*')]")
    WebElement Label_Country;
    @FindBy(xpath = "//div[@class='delivery-address']/div/div[8]/div/select")
    WebElement SelectState;

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[8]/div/select/option[@value='2']")
    WebElement PickState;

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[7]/div/select")
    WebElement classicDropdownXpath;

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[7]/div/select/option[@value='US']")
    WebElement US;

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[9]/div/input")
    WebElement City;


    @FindBy(xpath = "//div[@class='delivery-address']/div/div[10]/div/input")
    WebElement ZipCode;

    @FindBy(xpath = "//div[@class='delivery-address']/div/div[11]/div/input")
    WebElement PhoneNumber;

    /*
        Continue Button
     */

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement Continue_Button;

    /*
        Payment
     */

    @FindBy(xpath = "//p[contains(text(),'Pay by Card (Stripe)')]")
    WebElement PayByCard;

    @FindBy(xpath = "//label[contains(text(),'Card Number')]")
    WebElement Label_Card_Number;

    @FindBy(xpath = "//input[@placeholder='1234 1234 1234 1234']")
    WebElement TextCard;

    @FindBy(xpath = "//input[@name='exp-date']")
    WebElement ExpiryDate;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    WebElement Cvv;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    WebElement Place_Order_Button;

    /*
        Order Summary
     */

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    WebElement Continue_Shopping;

    @FindBy(xpath = "//p[contains(text(),'Order placed successfully!')]")
    WebElement Label_Order_Placed;

    @FindBy(xpath = "(//div[@class='container'])[2]/span")
    WebElement Order_Id;


    public void Go_to_shop_Now(){
        waitHelper.Go_to_Wait_for_Element(ShopNow);
        ShopNow.click();
        waitHelper.Go_to_Wait_for_Element(TextCategory);
    }

    public void Go_to_Add_to_Cart(){
        ProductImage.click();
        waitHelper.Go_to_Wait_for_Element(Add_to_Cart_Button);

        try {
            Add_to_Cart_Button.isDisplayed();
            Add_to_Cart_Button.click();
            waitHelper.Go_to_Wait_for_Element(Yes);
            Thread.sleep(2000);
            Yes.click();
            waitHelper.Go_to_Wait_for_Element(Proceed_to_Checkout);
            Assertion.Verify_the_an_Element(Proceed_to_Checkout);
            Cross_Icon.click();
        }
        catch (Exception e){
            System.out.println("Add card is Displayed:"+e);
        }
    }

    public void Go_to_Add_Cart_Icon(){
        Shopping_Cart_Icon.click();
        waitHelper.Go_to_Wait_for_Element(Proceed_to_Checkout);
        Proceed_to_Checkout.click();
        waitHelper.Go_to_Wait_for_Element(Label_Checkout);
        Assertion.Verify_the_an_Element(Label_Checkout);
    }

    public void Enter_Delivery_Address() throws IOException, ParseException {
        String email=new ReadJsonData().getEmailAddress()+"@yopmail.com";
        System.out.println("User Email:-"+email);
        Text_Email_Address.sendKeys(email);

        String birthday=new ReadJsonData().ReadJSONData("Birthday");
        System.out.println("Enter an Birthday:-"+birthday);
        Text_Birthday.click();
        Text_Birthday.sendKeys(birthday);
        CheckBox.click();
    }

    public void Enter_First_and_Last_Name() throws IOException, ParseException {
        String f_name=new ReadJsonData().Generate_First_Name();
        String l_name=new ReadJsonData().Generate_Last_Name();
        String address=new ReadJsonData().ReadJSONData("Address");
        Text_First_Name.sendKeys(f_name);
        Text_Last_Name.sendKeys(l_name);
        Text_Address.sendKeys(address);
    }

    public void Select_Country() throws InterruptedException, IOException, ParseException {
        new DropDownHelper(driver).SelectUsingVisibleValue(classicDropdownXpath, US.getText());
        Thread.sleep(2000);
        new DropDownHelper(driver).SelectUsingVisibleValue(SelectState, PickState.getText());
    }

    public void Enter_City_Zip_Phone_Number() throws IOException, ParseException {
        String city=new ReadJsonData().ReadJSONData("City");
        String zipcode=new ReadJsonData().ReadJSONData("zip_code");
        String phone_number=new ReadJsonData().ReadJSONData("Phone");
        City.sendKeys(city);
        ZipCode.sendKeys(zipcode);
        PhoneNumber.sendKeys(phone_number);
    }

    public void Click_Continue_Button() throws InterruptedException {
        new JavaScriptHelper(driver).scroll_to_View(Label_Country);
        waitHelper.Wait_for_Element(Continue_Button);
        waitHelper.Go_to_Wait_for_Element(Continue_Button);
        new JavaScriptHelper(driver).Scroll_Up_the_Page();
        Thread.sleep(3000);
        CheckBox.click();
        new JavaScriptHelper(driver).Scroll_Down_the_Page();
        Thread.sleep(3000);
        Continue_Button.click();
        waitHelper.Go_to_Wait_for_Element(Continue_Button);
        Continue_Button.click();
        waitHelper.Go_to_Wait_for_Element(PayByCard);
        Thread.sleep(2000);
    }

    public void Go_to_Payment() throws InterruptedException, IOException, ParseException {
        PayByCard.click();
        waitHelper.Go_to_Wait_for_Element(Label_Card_Number);
        Thread.sleep(2000);

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='card-input-wrapper']/div/div[1]/div/div/iframe")));
        TextCard.click();
        Thread.sleep(2000);
        String card_number=new ReadJsonData().ReadJSONData("Card_Number");
        //TextCard.sendKeys("4111 1111 1111 1111");
        TextCard.sendKeys(card_number);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='card-input-wrapper']/div/div[2]/div/div/iframe")));
        ExpiryDate.click();
        Thread.sleep(2000);
        String exp_date=new ReadJsonData().ReadJSONData("ExpDate");
        ExpiryDate.sendKeys(exp_date);
        //ExpiryDate.sendKeys("12/30");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='card-input-wrapper']/div/div[3]/div/div/iframe")));
        Cvv.click();
        Thread.sleep(2000);
        String cvv_number=new ReadJsonData().ReadJSONData("CVV");
        Cvv.sendKeys(cvv_number);
        //Cvv.sendKeys("123");
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        new JavaScriptHelper(driver).Scroll();
        waitHelper.Go_to_Wait_for_Element(Place_Order_Button);
        Thread.sleep(2000);
        Place_Order_Button.click();
    }

    public void Order_Summary(){
        waitHelper.Go_to_Wait_for_Element(Label_Order_Placed);
        Assertion.Verify_the_an_Element(Label_Order_Placed);
        Assertion.Verify_the_an_Element(Order_Id);

        if (Continue_Shopping.isDisplayed())
        {
            Continue_Shopping.click();
            waitHelper.Go_to_Wait_for_Element(ShopNow);
        }
    }

}
