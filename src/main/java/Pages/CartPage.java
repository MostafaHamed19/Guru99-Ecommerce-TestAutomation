package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.xpath.XPath;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText="Checkout with Multiple Addresses")
     WebElement proceedToCheckout;

    @FindBy(css = "input[title=\"Qty\"]")
    WebElement QTY;

    @FindBy(css = "button.button.btn-update")
    WebElement updateBtn;

    @FindBy(css = "strong span[class='price']")
    public WebElement price;

    @FindBy(css="li[class='success-msg'] ul li")
    public WebElement successMsg;

    @FindBy(id = "coupon_code")
     WebElement couponCode;

    @FindBy(xpath ="//span[contains(text(),'Apply')]")
    WebElement apply;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]")
    public WebElement discountRow;

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }

    public void setQTY(String input)
    {
        QTY.clear();
        QTY.sendKeys(input);
        updateBtn.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
    }

    public void setCouponCode(String _couponCode) {
        couponCode.sendKeys(_couponCode);
        apply.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
    }
}
