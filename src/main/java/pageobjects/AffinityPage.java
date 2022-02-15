package pageobjects;

import org.openqa.selenium.WebDriver;
import utils.ElementWeb;

import java.util.logging.Logger;

public class AffinityPage extends ElementWeb {
    private static final Logger LOG = Logger.getLogger(AffinityPage.class.getName());

    public AffinityPage(WebDriver driver) {
        super(driver);
    }
}
