package com.monster.wiki.utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

public class AbstractTestNGCucumberParallelTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
