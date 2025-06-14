package Tests;

import Pages.HomePage;
import Pages.MobilePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Sort By Feature")
public class T04_SortBy extends BaseTest{
    @Test(description = "User Can Sort By Price")
    public void sortByPrice() {
        HomePage homePage = new HomePage(driver);
        homePage.OpenMobilePage();
        Assert.assertEquals(driver.getTitle(),"Mobile");
        MobilePage mobilePage = new MobilePage(driver);
        Assert.assertEquals(mobilePage.MobileTitle.getText(),"MOBILE");
        Assert.assertTrue(mobilePage.testSortListByPrice());
    }
    @Test(description = "User Can Sort By Name")
    public void sortByName() {
        HomePage homePage = new HomePage(driver);
        homePage.OpenMobilePage();
        Assert.assertEquals(driver.getTitle(),"Mobile");
        MobilePage mobilePage = new MobilePage(driver);
        Assert.assertEquals(mobilePage.MobileTitle.getText(),"MOBILE");
        Assert.assertTrue(mobilePage.testSortListByName());
    }

}
