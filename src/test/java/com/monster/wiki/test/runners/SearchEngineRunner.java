package com.monster.wiki.test.runners;

import com.monster.wiki.utils.AbstractTestNGCucumberParallelTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/searchEngine.feature"
        ,glue= {"classpath:com.monster.wiki.test.stepdef"},
        plugin = { "pretty", "summary"},
        monochrome = true
)
public class SearchEngineRunner extends AbstractTestNGCucumberParallelTest {

}