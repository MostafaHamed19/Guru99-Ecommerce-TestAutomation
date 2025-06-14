package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SonyPage extends BasePage {
    public SonyPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "product-price-1")
     public WebElement sonyPrice;

    @FindBy(id = "qty")
     WebElement quantity;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//li[@class='error-msg']//ul//li")
    public WebElement errorMsg;

    public void VerifyCantAddMoreTheAvailableOnStore() {
        quantity.sendKeys("1000");
        addToCartBtn.click();
    }
}
