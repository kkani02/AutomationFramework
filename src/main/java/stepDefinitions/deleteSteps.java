package stepDefinitions;

import functionLibrary.CommonFunction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class deleteSteps extends CommonFunction {
    @When("I click Go to Basket")
    public void goToBasket() {
        driver.findElement(By.xpath("//div[@id='nav-cart-text-container']//ancestor::span[@class='nav-line-2']")).click();
    }
    @When("I choose the item {string} and click delete button")
    public void deleteItems(String itemName){
        driver.findElement(By.xpath("//div[@class='a-fixed-left-grid-col a-col-right']//ancestor::div[@class='a-row sc-action-links']//span[@class='a-declarative']//input[contains(@aria-label,'"+itemName+"')]")).click();
    }
    @Then("I should able to see the items deleted in the basket and message displayed as {string}")
    public void verifyItemsDeleted(String expectedDeleteMsg){
        String actualDeleteMsg=driver.findElement(By.xpath("//div[@id='sc-active-cart']//div[@class='a-row']//h1")).getText();
        Assert.assertEquals(actualDeleteMsg,expectedDeleteMsg);



    }
}
