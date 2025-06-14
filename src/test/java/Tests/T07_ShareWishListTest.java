package Tests;

import Pages.*;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Share Wishlist Feature")
public class T07_ShareWishListTest extends BaseTest {
    @Test(description = "User Can Share His Wishlist Successfully")
    public void shareWishList() {
        HomePage homepage = new HomePage(driver);
        homepage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("m_hamed@gmail.com","Test@123");
        String actual = driver.findElement(By.className("hello")).getText();
        Assert.assertTrue(actual.contains("Hello, "));
        AccountPage account = new AccountPage(driver);
        account.OpenTvPage();
        TvPage tv = new TvPage(driver);
        tv.clickAddToWishList();
        WishListPage wishList = new WishListPage(driver);
        Assert.assertTrue(wishList.successMsg.getText().contains("has been added to your wishlist"));
        wishList.clickShareWishlistBtn();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
        wishList.EnterEmailAddress("m_hamed@gmail.com");
        wishList.clickShareWishlistBtn();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
        Assert.assertTrue(wishList.successMsg.getText().contains("Your Wishlist has been shared."));
    }
}
