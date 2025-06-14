package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="firstname")
     WebElement firstnameField;
    @FindBy(id="middlename")
    WebElement middlenameField;
    @FindBy(id="lastname")
    WebElement lastnameField;
    @FindBy(id="email_address")
    WebElement emailField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(id="confirmation")
    WebElement confirmPasswordField;
    @FindBy(css="button[title='Register']")
    WebElement registerBtn;

    public void Register(String firstname, String middlename, String lastname, String email, String password, String confirmPassword) {
        firstnameField.sendKeys(firstname);
        middlenameField.sendKeys(middlename);
        lastnameField.sendKeys(lastname);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        registerBtn.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
    }
}
