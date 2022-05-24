package com.monster.wiki.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverWeb {
    private final String PATHUSER = System.getProperty("user.dir");
    private final long IMPLICIT_WAIT = 10;
    private static WebDriver driver;
    private PropertiesFile propertiesFile;
    private DesiredCapabilities capabilities;
    private String separator = File.separator;

    public WebDriver inicialization(PropertiesFile propertiesFile) {
        this.propertiesFile = propertiesFile;
        String server = System.getProperty("server");
        String local = System.getProperty("local");
        String browser = System.getProperty("browser");
        String headless = System.getProperty("headless");

        String url = propertiesFile.readFileProperties("url_web");
        String browserName = propertiesFile.readFileProperties("browser");

        if (browser != null) browserName = browser;

        if (checkLocal(local)) {
            setManualDriver(browserName);
            initLocalDriver(browserName, headless);
        } else if (checkServer(server)) {
            setWdmDriver(browserName, server);
            initLocalDriver(browserName, headless);
        } else {
            setWdmDriver(browserName, server);
            initRemoteDriver(browserName, headless);
        }

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebEventListener webEventListener = new WebEventListener(driver);
        eventFiringWebDriver.register(webEventListener);
        driver = eventFiringWebDriver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(url);

        return driver;
    }

    private void initLocalDriver(String browserName, String headless) {
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            if (headless != null && (headless.equals("true") || headless.equals(""))) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
    }

    private void initRemoteDriver(String browserName, String headless) {
        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            if (headless != null && (headless.equals("true") || headless.equals(""))) {
                options.addArguments("--headless");
            }

            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
    }

    private void setManualDriver(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, PATHUSER + (separator + "driver" + separator + "chromedriver.exe"));
        }
    }

    private void setWdmDriver(String browserName, String server) {
        if (checkServer(server)) {
            WebDriverManager.getInstance(DriverManagerType.valueOf(browserName.toUpperCase())).setup();
        }
    }

    private boolean checkLocal(String local) {
        return local != null && (local.equals("true") || local.equals(""));
    }

    private boolean checkServer(String server) {
        return server != null && (server.equals("true") || server.equals(""));
    }
}
