package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/routing.feature"
        ,glue= {"classpath:stepdef"},
        plugin = { "pretty", "summary"},
        monochrome = true
)
public class RoutingRunner extends AbstractTestNGCucumberTests {

}