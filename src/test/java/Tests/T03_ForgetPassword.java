package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ForgetPasswordPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Forget Password Feature")
public class T03_ForgetPassword extends BaseTest {
    @Story("Valid Forget Password Reset")
    @Test(priority = 0,description = "User Can Reset Password By Enter Valid Email")
    public void ValidForgetPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenForgotPasswordPage();
        ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(driver);
        forgetPasswordPage.ResetPassword("m_hamed@gmail.com");
        Assert.assertTrue(loginPage.ResetPasswordTxt.getText().contains("If there is an account associated"));
    }
    @Story("InValid Forget Password Reset")
    @Test(priority = 1,description = "User Can't leave email field Empty")
    public void InValidForgetPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenForgotPasswordPage();
        ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(driver);
        forgetPasswordPage.ResetPassword("");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email_address")).getText(), "This is a required field.");
    }
}
