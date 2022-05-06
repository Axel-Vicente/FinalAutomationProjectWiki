package context;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import pageobjects.AffinityPage;
import utils.DriverWeb;
import utils.PropertiesFile;

import java.util.logging.Logger;

@Getter
@Setter
public class TestContext {

    private Logger Log;
    private WebDriver driver;
    private String user, password;
    //    private ExcelUtils dataSheet;
    private AffinityPage affinityPage;

    public TestContext(){
        DriverWeb driverWeb = new DriverWeb();
        driver = driverWeb.inicialization();
        user = PropertiesFile.readFileProperties("user");
        password = PropertiesFile.readFileProperties("password");
        affinityPage = new AffinityPage(this.driver);
    }
}