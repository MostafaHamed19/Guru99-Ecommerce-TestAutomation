package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li[class='success-msg'] ul li")
    public WebElement successMsg;

    @FindBy(css = "button[title='Share Wishlist']")
     WebElement shareWishlistBtn;

    @FindBy(css = "#email_address")
    WebElement emailAddress;

    @FindBy(css ="button[title='Add to Cart']")
    WebElement addToCartBtn;

    public void clickShareWishlistBtn() {
        shareWishlistBtn.click();
    }
    public void EnterEmailAddress(String emailAddress) {
        this.emailAddress.sendKeys(emailAddress);
    }
    public void clickAddToCartBtn() {
        addToCartBtn.click();
    }
}
