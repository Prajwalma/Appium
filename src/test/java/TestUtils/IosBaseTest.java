package TestUtils;

import Utils.Appiumutils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class IosBaseTest  extends Appiumutils {

    AppiumDriverLocalService service;
    public IOSDriver driver;

    @BeforeClass

    public void Iosbasetest() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
        prop.load(fis);
        String ipAddress= prop.getProperty("ipAddress");
        String port= prop.getProperty("port");

      //  service = startappium(ipAddress,Integer.parseInt(port));

        XCUITestOptions options = new XCUITestOptions();
        options.setApp("/Users/prajwal/Library/Developer/Xcode/DerivedData/UIKitCatalog-hcllbthxzqcwrbcskzhltfvvfgof/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
        options.setPlatformName("IOS");
        options.setDeviceName("iPhone 15");
        options.setPlatformVersion("17.2");
        options.setAutomationName("XCUITest");
        options.setWdaLaunchTimeout(Duration.ofSeconds(30));
        driver = new IOSDriver(service.getUrl(),options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    @AfterClass
    public void Teardown()
    {
        driver.quit();
    //    service.stop();
    }
}
