package TestUtils;

import Utils.Appiumutils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
import java.util.Properties;

public class BaseClass extends Appiumutils
{
    AppiumDriverLocalService service;
     public AndroidDriver driver;
    @BeforeClass(alwaysRun = true)
    public void Configure() throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
        String ipAddress= System.getProperty("ipAddress")!= null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
        prop.load(fis);


       String port= prop.getProperty("port");

        service = startappium(ipAddress,Integer.parseInt(port));


        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(System.getProperty("user.dir")+"/src/test/java/resources/General-Store.apk");
        options.setDeviceName(prop.getProperty("deviceName"));
        options.setAutomationName("UiAutomator2");
        driver = new AndroidDriver(service.getUrl(),options);
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);

    }



    @AfterClass(alwaysRun=true)
    public void Teardown()
    {
        driver.quit();
       service.stop();
    }

}
