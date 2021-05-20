package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public boolean isTotalPriceEqualTo(String totalPrice) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("total_price"))).getText().contains(totalPrice);
    }
}
