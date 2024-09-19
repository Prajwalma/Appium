package org.android.test;

import TestUtils.BaseClass;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.pageobjects.android.CartPage;
import org.pageobjects.android.Formpage;
import org.pageobjects.android.Productcataloguepage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static Utils.Appiumutils.getJsonData;

public class tc_4 extends BaseClass {



    public void presetup() throws InterruptedException {

       ((JavascriptExecutor)driver).executeScript("mobile:startActivity",ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));

       Thread.sleep(5000);
    }




    @Test(groups={"smoke"})
    public void Errormsg()
    {
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String msg=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        Assert.assertEquals(msg,"Please enter your name");

    }


    @Test(dataProvider="getData",groups={"smoke"})
    public void Fillform(String name,String gender, String country) throws InterruptedException {

        Formpage page = new Formpage(driver);
        page.setNameField(name);
        page.setGenderField(gender);
        page.setCountryseletion(country);
        page.ClickShopButton();
        Productcataloguepage page2 = new Productcataloguepage(driver);
        Thread.sleep(3000);
        page2.addProductToCartbyindex(0);
        Thread.sleep(3000);
        page2.addProductToCartbyindex(1);
        page2.clickCartButton();
        Thread.sleep(2000);

        CartPage page3 = new CartPage(driver);
        double actsum = page3.getProductsSum();


        double formattedsum = page3.getTotalAmountDisplayed();
        Assert.assertEquals(actsum, formattedsum);


        page3.acceptTermsConditions();
        Thread.sleep(2000);
        page3.submitOrder();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        String filePath = System.getProperty("user.dir") + "//src//test//java//TestData//data";
        List<HashMap<String, String>> data = getJsonData(filePath);

        // Return each map's values as separate test data
        return new Object[][] {
                { data.get(0).get("name"), data.get(0).get("gender"), data.get(0).get("country") }
            //    { data.get(1).get("name"), data.get(1).get("gender"), data.get(1).get("country") }
        };
    }
    }







//        Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
//        int size = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")).size();
//        double totalsum = 0;
//        for (int i = 0; i < size; i++) {
//            String price = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")).get(i).getText();
//            double acprice = formatedsum(price.substring(1));
//            totalsum = totalsum + acprice;
//
//        }
//        String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//        double displaysum = formatedsum(total.substring(1));
//        Assert.assertEquals(totalsum, displaysum);
//        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//        longpress(ele);
//        driver.findElement(By.id("android:id/button1")).click();
//        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();


