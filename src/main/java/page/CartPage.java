package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void changeQuantity(String quantity) {
        driver.findElement(By.id("quantity_wanted")).sendKeys(Keys.chord(Keys.CONTROL, "a"), quantity);
    }

    public void changeSize(String size) {
        Select ddSize = new Select(driver.findElement(By.id("group_1")));
        ddSize.selectByVisibleText(size);
    }

    public void changeColor(String color) {
        clickUsingAction(driver.findElement(By.cssSelector("a[title='" + color + "'")));
    }

    public void clickAddToCart() {
        clickUsingAction(driver.findElement(By.name("Submit")));
    }

    public SummaryPage clickProceedToCheckout() {
        clickUsingAction(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Proceed to checkout']"))));
        return new SummaryPage(driver);
    }

    private void clickUsingAction(WebElement element) {
        action.moveToElement(element).click().perform();
    }
}
