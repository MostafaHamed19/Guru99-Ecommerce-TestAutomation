package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.MobilePage;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Discount Feature")
public class T12_DiscountTest extends BaseTest{
    @Test(description = "Verify Discount Coupon Works Correctly")
    public void VerifyCouponDiscountTest(){
        HomePage homepage = new HomePage(driver);
        homepage.OpenMobilePage();
        MobilePage mobilePage = new MobilePage(driver);
        mobilePage.IphoneAddToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.successMsg.getText().contains(("IPhone was added to your shopping cart.")));
        cartPage.setCouponCode("GURU50");
        Assert.assertTrue(cartPage.discountRow.getText().toLowerCase().contains("discount (guru50)"));
        Assert.assertTrue(cartPage.discountRow.getText().contains("-$25.00"));//5%
    }
    @Test(description = "Verify that the total price changes when a coupon code is applied")
    public void VerifyTotalPriceTest(){
        CartPage cartPage = new CartPage(driver);
        String OldGrandTotal = cartPage.price.getText();
        System.out.println("Old grand total is: " + OldGrandTotal);
        System.out.println("New grand total is: " + cartPage.price.getText());
        Assert.assertEquals(cartPage.price.getText(),"$475.00");
    }

}
