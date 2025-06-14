package Tests;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.MobilePage;
import io.qameta.allure.Feature;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Compare Feature")
public class T06_CompareTest extends BaseTest {
    @Test(description = "User Can Compare Between Two Products")
    public void CompareTest() {
        HomePage home = new HomePage(driver);
        home.OpenMobilePage();
        String currentWindow = driver.getWindowHandle();
        MobilePage mobile = new MobilePage(driver);
        mobile.CompareProducts();
        ComparePage compare = new ComparePage(driver);
        for(String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                driver.manage().window().maximize();
                Assert.assertEquals(compare.title.getText(),"COMPARE PRODUCTS");
                Assert.assertEquals(compare.sonyXperia.getText(),"SONY XPERIA");
                Assert.assertEquals(compare.iphone.getText(),"IPHONE");
                compare.CloseWindow();
                break;
            }
        }
        driver.switchTo().window(currentWindow);
        Assert.assertEquals(driver.getTitle(),"Mobile");
    }

    @Test(description = "User Can Remove Items From Compare")
    public void RemoveFromCompareTest() {
        CompareTest();
        MobilePage mobile = new MobilePage(driver);
        mobile.RemoveItem();
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        alert.accept();
        Assert.assertTrue(alertMsg.contains("Are you sure you would like to remove this item from the compare products?"));
        Assert.assertEquals(mobile.RecentComparedItem.getText(),"SONY XPERIA");
    }
}
