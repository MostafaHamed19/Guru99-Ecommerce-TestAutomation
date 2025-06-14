package Tests;

import Pages.HomePage;
import Pages.MobilePage;
import Pages.SonyPage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Product Cost Feature")
public class T05_SonyTest extends BaseTest{
    @Test(description = "Cost of Product in list page  equal cost in details page")
    public void VerifySonyCostTest(){
        HomePage homePage = new HomePage(driver);
        homePage.OpenMobilePage();
        MobilePage mobilePage = new MobilePage(driver);
        String s1=mobilePage.sonyPrice.getText();
        mobilePage.OpenSonyPage();
        SonyPage sonyPage = new SonyPage(driver);
        String s2=sonyPage.sonyPrice.getText();
        System.out.println(s1);
        System.out.println(s2);
        Assert.assertEquals(s1,s2);
    }
    @Test(description = "User Cant add more than the available quantity in store")
    public void VerifySonyQuantityTest(){
        HomePage homePage = new HomePage(driver);
        homePage.OpenMobilePage();
        MobilePage mobilePage = new MobilePage(driver);
        mobilePage.OpenSonyPage();
        SonyPage sonyPage = new SonyPage(driver);
        sonyPage.VerifyCantAddMoreTheAvailableOnStore();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
        Assert.assertTrue(sonyPage.errorMsg.getText().contains("The maximum quantity allowed for purchase is 500."));
    }
}
