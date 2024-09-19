package org.pageobjects.android;

import Utils.AndroidActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    public List<WebElement> productList;

    //driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement totalAmount;

    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    public WebElement terms;

    @AndroidFindBy(id="android:id/button1")
    public WebElement acceptButton;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    public WebElement proceed;

    @AndroidFindBy(className="android.widget.CheckBox")
    public WebElement checkBox;

    public List<WebElement> getProductList()
    {

        return productList;
    }

    public double getProductsSum()
    {
        int count = productList.size();
        double totalSum =0;
        for(int i =0; i< count; i++)
        {
            String amountString =productList.get(i).getText();
            double acprice = formatedsum(amountString.substring(1));

            totalSum = totalSum + acprice;
           //160.97 + 120 =280.97

        }

        return totalSum;

    }

    public double getTotalAmountDisplayed()
    {

       String actpriceinstring= totalAmount.getText();
        double acprice = formatedsum(actpriceinstring.substring(1));
        return acprice;
    }

    public void acceptTermsConditions()
    {
        longpress(terms);
//        PointOption point = PointOption.point(terms.getLocation().getX(), terms.getLocation().getY());
//        TouchAction action = new TouchAction(driver);
//// Perform long press
//        action.press(point)
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))) // Adjust duration as needed
//                .release()
//                .perform();
        acceptButton.click();
    }


    public void submitOrder()
    {
        checkBox.click();
        proceed.click();
    }


}





