package com.monster.wiki.context;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import com.monster.wiki.pageobjects.AffinityPage;
import com.monster.wiki.utils.DriverWeb;
import com.monster.wiki.utils.ExcelUtils;
import com.monster.wiki.utils.PropertiesFile;

import java.util.logging.Logger;

@Getter
@Setter
public class TestContext {

    private Logger Log;
    private WebDriver driver;
    private String user, password;
    private ExcelUtils dataSheet;
    private AffinityPage affinityPage;
    private PropertiesFile propertiesFile;

    public TestContext(){
        propertiesFile = new PropertiesFile();
        DriverWeb driverWeb = new DriverWeb();
        driver = driverWeb.inicialization(propertiesFile);
        user = propertiesFile.readFileProperties("user");
        password = propertiesFile.readFileProperties("password");
        Log = Logger.getLogger(TestContext.class.getName());
    }
}
