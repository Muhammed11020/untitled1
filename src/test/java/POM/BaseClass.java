package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class BaseClass {

    private static WebDriver dr;
    private static ChromeOptions opt = new ChromeOptions();

    @BeforeTest
    static public void setUp() {
        //ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("./Extentions/ADBlock.crx"));
        dr = new ChromeDriver(opt);
        dr.manage().window().maximize();
        dr.get("https://automationexercise.com/");
    }

    static public void openHomePage()
    {
        BaseClass.getWebDriver().get("https://automationexercise.com/");
    }
    public static WebDriver getWebDriver()
    {

        if (dr == null){
            BaseClass.setUp();
        }
        return dr;
    }
}
