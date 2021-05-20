package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    private WebDriver driver;
    private Actions action;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public SearchResultsPage searchFor(String searchText) {
        driver.findElement(By.id("search_query_top")).sendKeys(searchText);
        driver.findElement(By.name("submit_search")).click();

        return new SearchResultsPage(driver);
    }
}
