package myproject.myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver getDriver(String driverName){
        WebDriver driver = null;
        if(driverName!=null && driverName.equals("chrome")){
                System.setProperty("webdriver.chrome.driver", "src/resources/bin/chromedriver.exe");
                driver = new ChromeDriver();
        }
        else{
            try {
                throw new WebDriverNotFoundException("please specify a valid driver");
            } catch (WebDriverNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
