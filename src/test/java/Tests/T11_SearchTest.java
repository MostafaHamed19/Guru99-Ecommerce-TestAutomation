package Tests;

import Pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Search")
public class T11_SearchTest extends BaseTest{
    @Test(description = "User Can Search By Product Name Successfully")
    public void searchTest(){
        HomePage homePage = new HomePage(driver);
        String ProductName = "IPHONE";
        homePage.SearchProduct(ProductName);
        Assert.assertTrue(homePage.searchHeader.getText().toLowerCase().contains(ProductName.toLowerCase()));
        Assert.assertTrue(homePage.ProductsNames.contains(ProductName.toLowerCase()));
    }
}
