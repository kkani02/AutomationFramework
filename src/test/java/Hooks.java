import functionLibrary.CommonFunction;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    CommonFunction commonFunction=new CommonFunction();
    @Before
    public void beforeTest(){
commonFunction.openBrowser();
    }
    @After
    public void afterTest(){
        commonFunction.closeBrowser();
    }
}
