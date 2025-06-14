package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeClass
    public void OpenWebsite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void CloseBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    @AfterMethod
    public void take_screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot...");
            TakesScreenshot sc = (TakesScreenshot) driver;
            File photo = sc.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(photo, new File("./screenshots/" + result.getName() + ".png"));
        }
    }
}
