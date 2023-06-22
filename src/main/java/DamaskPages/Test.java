package DamaskPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String[] args) {

        ChromeOptions ops = new ChromeOptions();
        //ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("headless");
        ops.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.get("https://sdethub.blogspot.com/");
        String title = driver.getTitle();
        System.out.println("Website Title: "+title);
        driver.close();;
    }
}
