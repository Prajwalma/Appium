package Utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions extends Appiumutils{
    IOSDriver driver;


    public  IOSActions(IOSDriver driver) {

        this.driver = driver;
    }

    public void Scrolltotext(WebElement ele) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement) ele).getId());
        driver.executeScript("mobile:scroll", params);
    }

    public void touchandhold(WebElement ele) {
        Map<String, Object> parms = new HashMap<>();
        parms.put("element", ((RemoteWebElement) ele).getId());
        parms.put("duration", 3);
        driver.executeScript("mobile: touchAndHold", parms);
    }
}