package BaseClass;
import Utility.ReadJsonData;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import java.io.IOException;
import java.util.Locale;

public class TestBase {
    public static WebDriver driver;
    public void LaunchBrowser(String browser) throws IOException, ParseException {
        String environment=System.getProperty("os.name");
        System.out.println("Automation Script run on ......"+environment);

        switch (browser.toLowerCase(Locale.ROOT))
        {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                driver.manage().window().setSize(new Dimension(1440, 900));
                break;
            case "firefox":
                FirefoxOptions options1 = new FirefoxOptions();
                WebDriver driver = new FirefoxDriver(options1);
                options1.setHeadless(true);
                driver=new FirefoxDriver(options1);
                driver.manage().window().setSize(new Dimension(1440, 900));

                break;
            case "safari":
                driver=new SafariDriver();
                break;


            default:
                driver=null;
                break;
        }driver.manage().window().maximize();
        driver.get(new ReadJsonData().ReadJSONData("URL"));
    }



}
