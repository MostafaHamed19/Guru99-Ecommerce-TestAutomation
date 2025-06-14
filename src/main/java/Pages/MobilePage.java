package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobilePage extends BasePage {

    public MobilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy (tagName = "h1")
    public WebElement MobileTitle;

    @FindBy(css = "select[title=\"Sort By\"]")
     WebElement SortList;

    @FindBy(css = "ul.products-grid.products-grid--max-4-col.first.last.odd")
    public WebElement ProductList;
    public List<Double> ProductsPrices = new ArrayList<>();
    public List<String> ProductsNames = new ArrayList<>();

    @FindBy(css = "#product-collection-image-1")
     WebElement sony;

    @FindBy(id = "product-price-1")
    public WebElement sonyPrice;

    @FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]")
    WebElement SonyCompareButton;

    @FindBy(xpath = "//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")
    WebElement IphoneCompareButton;

    @FindBy(css = "button[title='Compare']")
    WebElement CompareButton;

    @FindBy(css = "li[class='item odd'] a[title='Remove This Item']")
    WebElement RemoveItemButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/ol[1]/li[1]/p[1]/a[1]")
    public WebElement RecentComparedItem;

    @FindBy(xpath = "//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]")
    WebElement IphoneAddToCart;


    public boolean testSortListByPrice() {
        select=new Select(SortList);
        select.selectByVisibleText("Price");
        List<WebElement> pPrice = ProductList.findElements(By.xpath(".//span[@class='price' and not(contains(@id,'old-price'))]"));
        for (WebElement price : pPrice) {
            String priceText = price.getText().replace("$", "").replace(",", "").trim();
            ProductsPrices.add(Double.parseDouble(priceText));
        }
        List<Double> sortedPrices = new ArrayList<>(ProductsPrices);
        Collections.sort(sortedPrices);
        System.out.println(ProductsPrices);
        System.out.println(sortedPrices);
        return ProductsPrices.equals(sortedPrices);
    }
    public boolean testSortListByName() {
        select=new Select(SortList);
        select.selectByVisibleText("Name");
        List<WebElement> pName = ProductList.findElements(By.className("product-name"));
        for (WebElement n : pName) {
            ProductsNames.add(n.getText().trim());
        }
        List<String> sortedNames = new ArrayList<>(ProductsNames);
        Collections.sort(sortedNames);
        System.out.println(ProductsNames);
        System.out.println(sortedNames);
        return ProductsNames.equals(sortedNames);
    }
    public void OpenSonyPage(){
        sony.click();
    }
    public void CompareProducts(){
        SonyCompareButton.click();
        IphoneCompareButton.click();
        CompareButton.click();
    }
    public void RemoveItem(){
        RemoveItemButton.click();
    }
    public void IphoneAddToCart(){
        IphoneAddToCart.click();
    }
}
