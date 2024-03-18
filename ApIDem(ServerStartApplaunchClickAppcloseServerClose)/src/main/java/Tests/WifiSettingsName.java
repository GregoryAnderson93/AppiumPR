package Tests;

import Infra.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static Infra.DriverFactory.stopServices;

public class WifiSettingsName extends BaseTest {

    @Test
    public void Preferences() {
        WebElement preference = driver.findElement(AppiumBy.accessibilityId("Preference"));
        preference.click();
    }
/*@AfterClass
    public void stop(){
        *//*driver.quit();
    DriverFactory.stopServices();*//*
}*/
}