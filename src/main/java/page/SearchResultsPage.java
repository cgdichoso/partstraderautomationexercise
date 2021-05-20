package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;
    private Actions action;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, 30);
    }

    public CartPage selectCheapestResult() {
        By searchResultPrices = By.cssSelector("div[class='right-block'] span[class='price product-price']");
        By searchResultImages = By.cssSelector("div[class='left-block'] a[class='product_img_link']");
        List<WebElement> searchResults = driver.findElements(searchResultPrices);
        Double cheapestPrice = getPrice(searchResults.get(0));
        Integer index = 0;

        for (int i = 0; i < searchResults.size(); i++) {
            if (cheapestPrice > getPrice(searchResults.get(i)))
                index = i;
        }

        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(searchResultImages).get(index)))).click().perform();
        return new CartPage(driver);
    }

    private Double getPrice(WebElement element) {
        return Double.valueOf(element.getText().replace("$", ""));
    }
}
