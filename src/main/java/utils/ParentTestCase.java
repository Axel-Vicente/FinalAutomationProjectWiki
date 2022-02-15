package utils;

import context.TextContext;
import org.openqa.selenium.WebDriver;
import pageobjects.AffinityPage;

import java.util.logging.Logger;

public class ParentTestCase {
    protected Logger Log;
    protected WebDriver driver;
    protected String user, password;
    protected TextContext context;
    protected AffinityPage affinityPage;

    public ParentTestCase(TextContext context) {
        this.context = context;
        driver = context.getDriver();
        user = context.getUser();
        password = context.getPassword();
        Log = context.getLog();
        affinityPage = context.getAffinityPage();
    }
}
