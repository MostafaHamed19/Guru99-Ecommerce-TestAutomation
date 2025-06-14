package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "h1")
    public WebElement accountHeader;

    @FindBy(css = "li[class='success-msg'] ul li")
    public WebElement successMessage;

    @FindBy(linkText = "TV")
     WebElement tv;

    @FindBy(linkText = "MY WISHLIST")
    WebElement myWishlist;

    @FindBy(linkText = "MY ORDERS")
    WebElement myOrders;

    @FindBy(css = "tr[class='first odd'] a[class='link-reorder']")
    WebElement reorder;

    public void OpenTvPage(){
        tv.click();
    }
    public void OpenMyWishlistPage(){
        myWishlist.click();
    }
    public void OpenMyOrdersPage(){
        myOrders.click();
    }
    public void OpenReorderPage(){
        reorder.click();
    }

}
