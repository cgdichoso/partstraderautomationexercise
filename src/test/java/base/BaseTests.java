package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShot() {
        var grabber = (TakesScreenshot)driver;
        File screenshot = grabber.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("screenshot/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
