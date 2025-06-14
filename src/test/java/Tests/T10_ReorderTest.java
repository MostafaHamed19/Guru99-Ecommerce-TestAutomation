package Tests;

import Pages.*;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Reorder Feature")
public class T10_ReorderTest extends BaseTest{
    @Test(description = "User Can Change or Reorder previously added product")
    public void ReorderTest(){
        HomePage homepage = new HomePage(driver);
        homepage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("m_hamed@gmail.com","Test@123");
        String actual = driver.findElement(By.className("hello")).getText();
        Assert.assertTrue(actual.contains("Hello, "));
        AccountPage accountPage = new AccountPage(driver);
        accountPage.OpenReorderPage();
        CartPage cartPage = new CartPage(driver);
        String OldGrandTotal = cartPage.price.getText();
        cartPage.setQTY("10");
        System.out.println("Old Grand Total = "+OldGrandTotal);
        System.out.println("Grand Total = "+cartPage.price.getText());
        Assert.assertNotSame(cartPage.price.getText(), OldGrandTotal);
        cartPage.clickProceedToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setCheckOut();
        Assert.assertEquals(checkoutPage.orderHeader.getText(), "ORDER SUCCESS");
        Assert.assertTrue(checkoutPage.orderNumber.getText().contains("Your order number is"));
    }
}
