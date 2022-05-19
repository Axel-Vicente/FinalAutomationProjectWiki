package com.monster.wiki.test.stepdef;

import com.monster.wiki.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.monster.wiki.utils.ExcelUtils;
import com.monster.wiki.utils.ParentTestCase;
import com.monster.wiki.utils.Screenshots;

import java.util.List;

public class HooksCucumberStepDef extends ParentTestCase {

    public HooksCucumberStepDef(TestContext context) {
        super(context);
    }

    @Before
    public void setUp(Scenario scenario) {
        List<String> tags = (List<String>) scenario.getSourceTagNames();
        context.setDataSheet(new ExcelUtils(tags.get(0).replace("@", "") + ".xlsx", scenario.getName()));
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        Screenshots.takeScreenshot(driver, scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        driver.quit();
    }
}
