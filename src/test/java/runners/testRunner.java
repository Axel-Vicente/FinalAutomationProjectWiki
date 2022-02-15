package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/test.feature"
        ,glue= {"classpath:stepdef"},
        //plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        plugin = { "pretty", "summary"},
        monochrome = true
)
public class testRunner extends AbstractTestNGCucumberTests {
/*    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));

    }
*/
}
