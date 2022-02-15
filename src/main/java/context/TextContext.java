package context;

import org.openqa.selenium.WebDriver;
import pageobjects.AffinityPage;
import utils.DriverWeb;
import utils.PropertiesFile;

import java.util.logging.Logger;

public class TextContext {

    private Logger Log;
    private WebDriver driver;
    private String user, password;
    //    private ExcelUtils dataSheet;
    private AffinityPage affinityPage;

    public TextContext(){
        driver = DriverWeb.inicialization();
        user = PropertiesFile.readFileProperties("user");
        password = PropertiesFile.readFileProperties("password");
        affinityPage = new AffinityPage(this.driver);
    }

    public Logger getLog() {
        return Log;
    }

    public void setLog(Logger log) {
        Log = log;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AffinityPage getAffinityPage() {
        return affinityPage;
    }

    public void setAffinityPage(AffinityPage affinityPage) {
        this.affinityPage = affinityPage;
    }
}
