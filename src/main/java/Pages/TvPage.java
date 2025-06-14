package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TvPage extends BasePage {
    public TvPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")
    WebElement addToWishList;

    public void clickAddToWishList() {
        addToWishList.click();
    }
}
