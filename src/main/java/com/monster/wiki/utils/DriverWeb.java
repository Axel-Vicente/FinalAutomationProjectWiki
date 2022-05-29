package com.monster.wiki.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverWeb {
    private final String PATHUSER = System.getProperty("user.dir");
    private final long IMPLICIT_WAIT = 10;
    private final String SEPARATOR = File.separator;
    private static WebDriver driver;
    private DesiredCapabilities capabilities;

    public WebDriver inicialization(PropertiesFile propertiesFile) {
        String browser = System.getProperty("browser");

        String url = propertiesFile.readFileProperties("url_web");
        String browserName = propertiesFile.readFileProperties("browser");

        if (browser != null) browserName = browser;

        setManualDriver(browserName);
        ignoreCertificateErrors(browserName);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(url);

        return driver;
    }

    private void ignoreCertificateErrors(String browserName) {
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");

            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
    }

    private void setManualDriver(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, PATHUSER + (SEPARATOR + "driver" + SEPARATOR + "chromedriver.exe"));
            driver = new ChromeDriver();
        }
    }
}
