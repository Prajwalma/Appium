package org.pageobjects.android;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Productcataloguepage extends AndroidActions {

    AndroidDriver driver;

    public Productcataloguepage(AndroidDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")
 private  List<WebElement> addCart;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;


    public void addProductToCartbyindex(int index)
    {
        addCart.get(index).click();
    }
     public void clickCartButton()
     {
         cartButton.click();
     }




//        "//        driver.findElements(By.xpath(\"//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']\")).get(0).click();\n" +
//        "//        Thread.sleep(2000);\n" +
//        "//        driver.findElements(By.xpath(\"//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']\")).get(1).click();")





}
