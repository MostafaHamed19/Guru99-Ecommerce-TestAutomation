package Tests;

import Pages.*;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Purchase Feature")
public class T08_PurchaseTest extends BaseTest{
    @Test(description = "User Can Purchase Successfully When He Logged In")
    public void purchaseTest(){
        HomePage homepage = new HomePage(driver);
        homepage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("m_hamed@gmail.com","Test@123");
        String actual = driver.findElement(By.className("hello")).getText();
        Assert.assertTrue(actual.contains("Hello, "));
        AccountPage account = new AccountPage(driver);
        account.OpenMyWishlistPage();
        WishListPage wishList = new WishListPage(driver);
        wishList.clickAddToCartBtn();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickProceedToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setCheckOut();
        Assert.assertEquals(checkoutPage.orderHeader.getText(), "ORDER SUCCESS");
        Assert.assertTrue(checkoutPage.orderNumber.getText().contains("Your order number is"));
    }
}
