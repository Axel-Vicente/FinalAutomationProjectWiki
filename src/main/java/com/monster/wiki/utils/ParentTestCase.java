package com.monster.wiki.utils;

import com.monster.wiki.context.TestContext;
import org.openqa.selenium.WebDriver;
import com.monster.wiki.pageobjects.AffinityPage;

import java.util.logging.Logger;

public class ParentTestCase {
    protected Logger Log;
    protected WebDriver driver;
    protected ExcelUtils dataSheet;
    protected TestContext context;
    protected AffinityPage affinityPage;

    public ParentTestCase(TestContext context) {
        this.context = context;
        driver = context.getDriver();
        Log = context.getLog();
        affinityPage = context.getAffinityPage();
        dataSheet = context.getDataSheet();
    }
}
