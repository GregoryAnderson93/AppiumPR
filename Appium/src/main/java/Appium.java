import com.beust.jcommander.converters.URLConverter;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;

import static Infra.DriverFactory.*;
import static io.appium.java_client.AppiumBy.*;

public class Appium {
    public AndroidDriver driver;
   @BeforeMethod
    public void startAppium(){
       startAppiumServer();
   }


    @Test
    public void AppiumTest(){
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid("emulator-5554");

        options.setCapability("appium:appPackage", "io.appium.android.apis");
        options.setCapability("appium:appActivity", ".ApiDemos");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "8.0");
        options.setCapability("appium:automationName", "UIAutomator2");
        options.setCapability("appium:app", "C:\\Users\\MY PC\\Desktop\\healthplix\\Apk\\ApiDemos-debug.apk");

        try {
            System.out.println("Test start");
            driver = new AndroidDriver(new URL(Url), options);

            System.out.println("Below android driver");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Actual automation

        WebElement preference = driver.findElement(AppiumBy.accessibilityId("Preference"));
        preference.click();
        System.out.println("Preferences clicked");
    }

    @AfterMethod
    public void stopAppium(){
        stopServices();
    }
}
