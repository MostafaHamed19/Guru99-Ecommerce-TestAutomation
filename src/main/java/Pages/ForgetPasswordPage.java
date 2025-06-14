package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage extends BasePage {
    public ForgetPasswordPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="email_address")
    private WebElement EmailField;

    @FindBy(css = "button[title='Submit']")
    private WebElement SubmitBtn;

    public void ResetPassword(String email) {
        EmailField.sendKeys(email);
        SubmitBtn.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
    }












    }
