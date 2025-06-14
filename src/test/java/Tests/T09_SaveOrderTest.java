package Tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyOrdersPage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Save Order Feature")
public class T09_SaveOrderTest extends BaseTest{
    @Test(description = "User Can Save His Order")
    public void VerifySaveOrder() {
        HomePage homepage = new HomePage(driver);
        homepage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("m_hamed@gmail.com","Test@123");
        String actual = driver.findElement(By.className("hello")).getText();
        Assert.assertTrue(actual.contains("Hello, "));
        AccountPage account = new AccountPage(driver);
        account.OpenMyOrdersPage();
        MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
        Assert.assertEquals(myOrdersPage.cells.get(4).getText(),"Pending");
        myOrdersPage.clickViewOrder();
        String currentHandle = driver.getWindowHandle();
        myOrdersPage.PrintOrder();
        for(String handle: driver.getWindowHandles())
        {
            if(!currentHandle.equals(handle)) {
                driver.switchTo().window(handle);
                Assert.assertTrue(driver.getTitle().contains("Print Order"));
            }
        }
    }
}
