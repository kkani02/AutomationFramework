package stepDefinitions;

import functionLibrary.CommonFunction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchSteps extends CommonFunction {
    @When("I do search for {string}")
    public void SearchOption(String searchTerm) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchTerm);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Then("I should get relevant products as results {string}")
    public void VerifySearchOption(String searchOption) {

        List<WebElement> productTitles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement productTitle : productTitles) {
            String actualText = productTitle.getText();
            System.out.println(actualText);
            Assert.assertTrue(actualText.contains(searchOption));
        }

    }
}
