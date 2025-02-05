package org.example;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestCase9 extends BaseTest {
    @Test
//    Test Case 9: Search Product
    public void searchProductTest() {
        String searchText = "jeans";

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        verifyHomepageVisible();

//4. Click on 'Products' button
        clickBtn(By.partialLinkText("Products"));

//5. Verify user is navigated to ALL PRODUCTS page successfully
        verifyPageTitle("Automation Exercise - All Products");
        verifyTextAndVisibility(By.cssSelector("h2.title"), "ALL PRODUCTS");

//6. Enter product name in search input and click search button
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchText);

        clickBtn(By.id("submit_search"));

//7. Verify 'SEARCHED PRODUCTS' is visible
        verifyTextAndVisibility(By.cssSelector("h2.title"), "SEARCHED PRODUCTS");

//8. Verify all the products related to search are visible
        verifyElementVisible(By.cssSelector(".features_items"));

        List<WebElement> searchResultsProducts = driver.findElements(By.cssSelector(".productinfo p"));
        for (WebElement product : searchResultsProducts) {
            assertTrue(product.getText().toLowerCase().contains(searchText));
        }
    }
}
