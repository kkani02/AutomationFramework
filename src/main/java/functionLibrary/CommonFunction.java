package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonFunction {
    public static WebDriver driver;
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
    public void closeBrowser(){
        driver.quit();

    }
}