package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverWeb {
    private static WebDriver driver;
    private PropertiesFile propertiesFile;

    public WebDriver inicialization(PropertiesFile propertiesFile) {
        this.propertiesFile = propertiesFile;
        String url = propertiesFile.readFileProperties("url_web");

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        return driver;
    }
}
