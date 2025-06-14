package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(css = "button[title='Continue to Shipping Information']")
     WebElement continueToShipping;//1

    @FindBy(css = "button[title='Continue to Billing Information'] span span")
    WebElement continueToBilling; //2

    @FindBy(css = "#p_method_checkmo")
    WebElement methodCheck;

    @FindBy(css = "#payment-continue")
    WebElement paymentContinue;//3

    @FindBy(css = "#review-button")
    WebElement placeOrderReview;

    @FindBy(tagName = "h1")
    public WebElement orderHeader;

    @FindBy(css = "p[data-role='order-numbers']")
    public WebElement orderNumber;

    public void setCheckOut(){
        continueToShipping.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
        continueToBilling.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
        methodCheck.click();
        paymentContinue.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
        placeOrderReview.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
    }

}