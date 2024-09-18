package org.pageobjects.IOS;

import Utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewsPage extends IOSActions {
    IOSDriver driver;
   public AlertViewsPage(IOSDriver driver){
       super(driver);
       this.driver = driver;
       PageFactory.initElements(new AppiumFieldDecorator(driver), this);
   }

    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH[c] 'Text'")
    private WebElement textentryoption;


    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField")
    private WebElement alertviewtextfield;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`name == 'OK'`]")
    private WebElement okbutton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Confirm / Cancel'")
    private WebElement cancelbutton;

    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH[c] 'A message'")
    private WebElement textmsg;

    @iOSXCUITFindBy(iOSNsPredicate = "name == Confirm")
    private WebElement confirmbutton;






    public void Filltextlabel(String text) {
        textentryoption.click();
        alertviewtextfield.sendKeys(text);
        okbutton.click();
    }

        public String getConfirmText()
    {
           cancelbutton.click();
           return textmsg.getText();
        }



    }



