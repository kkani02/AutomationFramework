package stepDefinitions;

import functionLibrary.CommonFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class loginSteps extends CommonFunction {
    @Given("I open homepage {string} with title as {string}")
    public void openHomepage(String url, String expectedTitle) {
        driver.get(url);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("sp-cc-accept")).click();

    }

    @When("I click sign button")
    public void signInOption() {
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    }

    @When("I enter username {string}")
    public void validUserName(String name) {
        driver.findElement(By.id("ap_email")).sendKeys(name);
    }

    @When("I click continue")
    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @When("I enter password{string}")
    public void validPassword(String pass) {
        driver.findElement(By.id("ap_password")).sendKeys(pass);
    }

    @When("I click sign-In button")
    public void clickSignIn() {
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Then("I should be landing on the login page with heading {string}")
    public void VerifyLoginOption(String expectedMsg) {
        String actualMsg = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Then("I shouldn't be allowed login with message {string}")
    public void InValidLogin(String expected) {
        String actual = driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
        Assert.assertEquals(actual, expected);
    }

    @Then("I shouldn't be allowed login message {string}")
    public void ValidEmail(String expectedMsg) {
        String actual = driver.findElement(By.xpath("//div[@id='auth-email-missing-alert']//following::div")).getText();
        Assert.assertEquals(actual, expectedMsg);

    }
}
