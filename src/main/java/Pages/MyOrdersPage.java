package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyOrdersPage extends BasePage{
    public MyOrdersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".first.odd")
    WebElement first;
    public List<WebElement> cells=first.findElements(By.tagName("td"));

    @FindBy(linkText = "VIEW ORDER")
     WebElement viewOrderLink;

    @FindBy(className = "link-print")
    WebElement print;

    public void  clickViewOrder() {
        viewOrderLink.click();
    }

    public void PrintOrder()
    {
        print.click();
    }
}
