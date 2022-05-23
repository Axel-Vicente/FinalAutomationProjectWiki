package com.monster.wiki.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/home.feature"
        ,glue= {"classpath:com.monster.wiki.test.stepdef"},
        plugin = { "pretty", "summary"},
        monochrome = true
)
public class HomeRunner extends AbstractTestNGCucumberTests {

}