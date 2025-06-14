package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="email")
    WebElement EmailField;

    @FindBy(id = "pass")
    WebElement PasswordField;

    @FindBy(id = "send2")
    WebElement LoginBtn;

    @FindBy(css="a[title='Create an Account']")
    WebElement CreateAccountBtn;

    @FindBy(linkText = "Forgot Your Password?")
    WebElement ForgotPasswordBtn;

    @FindBy(xpath = "//span[contains(text(),'you will receive an email with a link to reset')]")
    public WebElement ResetPasswordTxt;

    public void OpenCreateAccountPage() {
        CreateAccountBtn.click();
    }
    public void OpenForgotPasswordPage() {
        ForgotPasswordBtn.click();
    }
    public void Login(String email, String password) {
        EmailField.sendKeys(email);
        PasswordField.sendKeys(password);
        LoginBtn.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
    }

}

