package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends BasePage {
    public ComparePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "h1")
    public WebElement title;

    @FindBy(linkText = "SONY XPERIA")
    public WebElement sonyXperia;

    @FindBy(linkText = "IPHONE")
    public WebElement iphone;

    @FindBy(css = "button[title='Close Window'] span span")
     WebElement close;

    public void CloseWindow() {
        close.click();
    }
}
