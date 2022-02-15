package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import context.TextContext;
import pageobjects.AffinityPage;
import utils.ParentTestCase;

import java.util.concurrent.TimeUnit;

public class testStepDef extends ParentTestCase {
    private AffinityPage affinityPage;

    public testStepDef(TextContext context) {
        super(context);
        affinityPage = new AffinityPage(this.driver);
    }

    public static WebDriver driver;
    @Given("user is  on homepage")
    @Step("user is  on homepage")
    public void user_is_on_homepage() throws Throwable {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("wiki-rosy.vercel.app");
    }

    @When("user navigates to Login Page")
    @Step("user navigates to Login Page")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();
    }

    @When("user enters username and Password")
    @Step("user enters username and Password")
    public void user_enters_username_and_Password() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");
        driver.findElement(By.id("SubmitLogin")).click();
    }
    @Then("success message is displayed")
    @Step("success message is displayed")
    public void success_message_is_displayed() throws Throwable {
        String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
        String actual = driver.findElement(By.cssSelector(".info-account")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();
    }

}
