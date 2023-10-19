package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import utils.TakeScreenshot;


public class MyListeners implements ITestListener {
    private TakeScreenshot takeScreenshot;


    @BeforeClass
    public void setup() {
        takeScreenshot = new TakeScreenshot();
    }


    @Override
    public void onTestSuccess(ITestResult result){
        String testName = result.getName();
        System.out.println(testName + " passed");
    }


    @Override
    public void onTestFailure(ITestResult result){
        String testName = result.getName();
        System.out.println(testName + " failed");
        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
                    .get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        takeScreenshot.takeScreenShot(result.getName());
    }


}
