package utils;

import context.TestContext;
import org.openqa.selenium.WebDriver;
import pageobjects.AffinityPage;

import java.util.logging.Logger;

public class ParentTestCase {
    protected Logger Log;
    protected WebDriver driver;
    protected String user, password;
    protected TestContext context;
    protected AffinityPage affinityPage;

    public ParentTestCase(TestContext context) {
        this.context = context;
        driver = context.getDriver();
        user = context.getUser();
        password = context.getPassword();
        Log = context.getLog();
        affinityPage = context.getAffinityPage();
    }
}
