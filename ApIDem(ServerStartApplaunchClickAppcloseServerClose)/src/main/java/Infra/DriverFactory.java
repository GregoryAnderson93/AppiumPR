package Infra;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class DriverFactory {
    public static final int PORT = 4723;
    public static final String HOST = "127.0.0.1";
    public static String Url = "http://"+HOST+":"+PORT+"/wd/hub";
    protected static AppiumDriver driver=null;
    private static AppiumDriverLocalService services;

    public static void startAppiumServer(){
        services = new AppiumServiceBuilder()
                .withIPAddress(HOST)
                .usingPort(PORT)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                //  .withCapabilities()
                .build();
        services.start();
        services.clearOutPutStreams();
        System.out.println("Services started");
    }

    public static void main(String[] args) {
        startAppiumServer();
    }
    public static void stopServices(){
        if(services!=null){
            services.stop();
            System.out.println("appium server Stopped");
        }
    }
}
