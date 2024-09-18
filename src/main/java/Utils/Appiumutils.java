package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Appiumutils {
    AppiumDriverLocalService service;


//    AppiumDriver driver;"
//
//    public Appiumutils(AppiumDriver driver){
//        this.driver = driver;
//    }

    public AppiumDriverLocalService startappium(String ipAddress,int port){
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Prajwal M A//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
            .withIPAddress(ipAddress).usingPort(port).build();
        service.start();
        return service;

    }


    public static List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        // Convert JSON file content to a JSON string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        // Create ObjectMapper to parse the JSON content
        ObjectMapper mapper = new ObjectMapper();

        // Deserialize JSON content to a List of HashMaps
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {});

        return data;
    }


    public void waitForElement(WebElement element,AppiumDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((element),"text","cart"));
    }

    public Double formatedsum(String sum)
    {
        Double formatted=Double.parseDouble(sum);
        return formatted;
    }

//    public String getScreenshotpath(String testCaseName, AppiumDriver driver) throws IOException {
//        File source =driver.getScreenshotAs(OutputType.FILE);
//        String destination = System.getProperty("user.dir")+"/reports/screenshots/"+testCaseName+".png";
//        FileUtils.copyFile(source, new File(destination));
//        return destination;

    public String getScreenshotpath(String testCaseName, AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);

        // Absolute path to save the screenshot
        String destination = System.getProperty("user.dir") + "/reports/screenshots" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destination));

        // Return the relative path for the report
        return destination;  // Relative path used in the report
    }



    }



