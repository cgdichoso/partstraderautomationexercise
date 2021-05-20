package checkout;

import base.BaseTests;
import org.testng.annotations.Test;
import page.CartPage;
import page.SearchResultsPage;
import page.SummaryPage;

import static org.testng.Assert.assertTrue;

public class CheckOutTests extends BaseTests {

    @Test
    public void testCheckOutPrice() {
        SearchResultsPage search = homePage.searchFor("Printed Summer Dress");
        CartPage cart = search.selectCheapestResult();
        cart.changeQuantity("2");
        cart.changeSize("M");
        cart.changeColor("Green");
        cart.clickAddToCart();
        SummaryPage summary = cart.clickProceedToCheckout();
        assertTrue(summary.isTotalPriceEqualTo("$34.80"));
    }
}
