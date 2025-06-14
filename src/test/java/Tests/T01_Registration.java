package Tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Registration Feature")
public class T01_Registration extends BaseTest {
        @Story("Valid Registration")
        @Test
        public void ValidRegistrationTest() {
            HomePage homepage = new HomePage(driver);
            homepage.OpenLoginAndCreateAccPage();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.OpenCreateAccountPage();
            RegistrationPage registrationPage = new RegistrationPage(driver);
            registrationPage.Register("Mostafa","Hamed","Sayed","m_hamed@gmail.com","Test@123","Test@123");
            AccountPage accountPage = new AccountPage(driver);
            Assert.assertEquals(accountPage.accountHeader.getText(), "MY DASHBOARD");
            Assert.assertTrue(accountPage.successMessage.getText().contains("Thank you for registering"));
        }

}
