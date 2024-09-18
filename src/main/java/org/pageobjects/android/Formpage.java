package org.pageobjects.android;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Formpage extends AndroidActions {

   //         driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']")).sendKeys("praj");
   AndroidDriver driver;

   public Formpage(AndroidDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }
            @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
            private WebElement nameField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement maleoption;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleoption;


    @AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryseletion;


    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    public void setNameField(String name){
        nameField.sendKeys(name);
        driver.hideKeyboard();

    }
    public void setGenderField(String gender){
        if(gender.equalsIgnoreCase("male")){
            maleoption.click();
        }else if(gender.equalsIgnoreCase("female")){
            femaleoption.click();
        }
    }
 public void setCountryseletion(String country){
        countryseletion.click();
        scrollToText(country);
    }

  public void ClickShopButton(){
        shopButton.click();
  }

}
