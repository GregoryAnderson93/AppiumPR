package Tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

import static Infra.DriverFactory.Url;
import static Infra.DriverFactory.startAppiumServer;

public class BaseTest {

        public AndroidDriver driver;
@BeforeMethod
        public void startAppium() {
        startAppiumServer();
        AppiumTest();
    }

    public void AppiumTest() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("emulator-5554");

        options.setCapability("appium:appPackage", "io.appium.android.apis");
        options.setCapability("appium:appActivity", ".ApiDemos");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "8.0");
        options.setCapability("appium:automationName", "UIAutomator2");
        options.setCapability("appium:app", "C:\\Users\\MY PC\\Desktop\\healthplix\\Apk\\ApiDemos-debug.apk");

        try {

            driver = new AndroidDriver(new URL(Url), options);
            System.out.println("Application Launch");

            //System.out.println("Below android driver");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getStackTrace());

        }
    }


}