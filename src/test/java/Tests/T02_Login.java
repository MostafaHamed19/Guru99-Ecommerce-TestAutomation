package Tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Login Feature")
public class T02_Login extends BaseTest {
    @Story("Valid Login")
    @Test(description = "Login With Valid Credentials")
    public void ValidLogin() {
        HomePage homepage = new HomePage(driver);
        homepage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("m_hamed@gmail.com","Test@123");
        String actual = driver.findElement(By.className("hello")).getText();
        Assert.assertTrue(actual.contains("Hello, "));
        homepage.Logout();

    }

    @Story("Invalid Login")
    @Test(description = "User Can't Leave Login And Password Empty")
    public void InValidLoginEmpty() {
        HomePage homepage = new HomePage(driver);
        homepage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("","");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
    }
    @Story("Invalid Login")
    @Test(description = "User Can't Login With Valid Email And Wrong Password")
    public void InValidLoginWrong() {
        HomePage homepage = new HomePage(driver);
        homepage.OpenLoginAndCreateAccPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("m_hamed@gmail.com","1234567");
        Assert.assertEquals(driver.findElement(By.cssSelector("li[class='error-msg'] ul li")).getText(), "Invalid login or password.");
    }
}

