package stepDefinitions;

import functionLibrary.CommonFunction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Pattern;

public class basketSteps extends CommonFunction {
    @When("I select the product {string}")
    public void selectProduct(String selectOption) {
        driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']//ancestor::h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//a//span[contains(text(),\"" + selectOption + "\")]")).click();
    }

    @When("I select the size and colour")
    public void selectSize() {
        List<WebElement> itemsSize = driver.findElements(By.xpath("//div[@id='variation_size_name']//ancestor::div[@class='a-row a-spacing-micro']//label"));
        for (WebElement selectItemSize : itemsSize) {
            driver.findElement(By.xpath("//div[@id='popover-string']//following::span//span//select")).click();
            driver.findElement(By.xpath("//div[@id='popover-string']//following::span//span//select//option[@id='native_size_name_2']")).click();
        }
        List<WebElement> itemColour = driver.findElements(By.xpath("//div[@id='variation_color_name']//ancestor::div[@class='a-row a-spacing-micro']//label"));
        for (WebElement selectItemColour : itemColour) {
            driver.findElement(By.id("native_dropdown_selected_color_name")).click();
            driver.findElement(By.xpath("//select[@id='native_dropdown_selected_color_name']//parent::option[@id='native_color_name_3']")).click();
        }
    }

    @When("I click Add to Basket")
    public void addBasket() {
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @Then("I should be able to see the product added on the basket")
    public void verifyBasket() {


        driver.findElement(By.xpath("//div[@id='nav-cart-text-container']//ancestor::span[@class='nav-line-2']")).click();
        String addBasketItem1 = driver.findElement(By.xpath("//div[@class='sc-list-item-content']//ancestor::div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last']//p//span[1]")).getText();
        String addBasketItem2 = driver.findElement(By.xpath("//div[@class='sc-list-item-content']//ancestor::div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last']//p//span[2]")).getText();
        String addBasketItem3 = driver.findElement(By.xpath("//div[@class='sc-list-item-content']//ancestor::div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last']//p//span[3]")).getText();

        Pattern pricePattern = Pattern.compile("^0-9.");
        Double firstItemPrice = Double.parseDouble(pricePattern.matcher(addBasketItem1).toString());
        Double secondItemPrice = Double.parseDouble(pricePattern.matcher(addBasketItem2).toString());
        Double thirdItemPrice = Double.parseDouble(pricePattern.matcher(addBasketItem3).toString());

        Double calculatePrice = firstItemPrice + secondItemPrice + thirdItemPrice;

        Double totalPrice = Double.parseDouble(driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']//span")).getText());
        Assert.assertEquals(calculatePrice,totalPrice);
    }
}
