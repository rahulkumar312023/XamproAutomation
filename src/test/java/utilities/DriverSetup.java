package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {

    public static String browserName = System.getProperty("browser","chrome");

    private static final ThreadLocal<WebDriver> LOCAL_BROWSER = new ThreadLocal<>();

    public static void setBrowser(WebDriver browser) {
        DriverSetup.LOCAL_BROWSER.set(browser);
    }

    public static WebDriver getBrowser() {
        return LOCAL_BROWSER.get();
    }



    public WebDriver getBrowser(String browserName){

        if (browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();


        }else if (browserName.equalsIgnoreCase("edge")){
            return new EdgeDriver();
        }else if (browserName.equalsIgnoreCase("Firefox")){
            return new FirefoxDriver();
        }else {
            throw new RuntimeException("Browser is not available" + browserName);
        }

    }

    @BeforeSuite
    public void openBrowser(){

        WebDriver browser = getBrowser(browserName);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setBrowser(browser);
    }

    @AfterSuite
    public void quitBrowser(){
        getBrowser().quit();
    }
}