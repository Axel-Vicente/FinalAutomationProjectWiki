package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/searchEngine.feature"
        ,glue= {"classpath:stepdef"},
        plugin = { "pretty", "summary"},
        monochrome = true
)
public class SearchEngineRunner extends AbstractTestNGCucumberTests {

}