package org.ios.test;

import TestUtils.IosBaseTest;
import org.pageobjects.IOS.AlertViewsPage;
import org.pageobjects.IOS.HomePage;
import org.testng.annotations.Test;

public class IosBasicsTest extends IosBaseTest {

    @Test
    public void IosBasicTest() {

        HomePage page=new HomePage(driver);
        page.clickOnAlertViewButton();
        page.clickOnAlertViewButton();

        AlertViewsPage alertView =new AlertViewsPage(driver);
        alertView.Filltextlabel("prajwal");
        String msg=alertView.getConfirmText();
        System.out.println(msg);

    }

}
