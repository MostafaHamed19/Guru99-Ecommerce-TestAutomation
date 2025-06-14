package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".skip-link.skip-account")
     WebElement accountList;
    @FindBy(css="a[title='My Account']")
    WebElement myAccount;
    @FindBy(xpath = "//a[normalize-space()='Mobile']")
    WebElement mobile;
    @FindBy(id = "search")
    WebElement search;
    @FindBy(css = "button[title='Search']")
    WebElement searchButton;
    @FindBy(tagName = "h1")
    public WebElement searchHeader;
    @FindBy(css = ".products-grid.products-grid--max-3-col.first.last.odd")
     WebElement productsList;
    public List<String> ProductsNames = new ArrayList<>();

    @FindBy(css = "a[title='Log Out']")
    WebElement logOut;

    public void OpenLoginAndCreateAccPage() {
        accountList.click();
        myAccount.click();
    }
    public void OpenMobilePage() {
        mobile.click();
    }
    public void SearchProduct(String productName) {
        search.sendKeys(productName);
        searchButton.click();
        driver.findElement(By.tagName("body")).sendKeys("thisisunsafe");
        List<WebElement> pName = productsList.findElements(By.className("product-name"));
        for (WebElement n : pName) {
            ProductsNames.add(n.getText().trim().toLowerCase());
        }
        System.out.println(ProductsNames);
    }
    public void Logout() {
        accountList.click();
        logOut.click();
    }
}
