package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestCase8 extends BaseTest {
    @Test
//    Test Case 8: Verify All Products and product detail page
    public void verifyAllProductsDetailsTest() {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        verifyHomepageVisible();

//4. Click on 'Products' button
        clickBtn(By.cssSelector(".nav a[href='/products']"));

//5. Verify user is navigated to ALL PRODUCTS page successfully
        verifyPageTitle("Automation Exercise - All Products");
        verifyHeaderVisible(By.cssSelector("h2.title"), "ALL PRODUCTS");

//6. The products list is visible
        verifyElementVisible(By.cssSelector(".features_items"));
        //ensures there are products
        List<WebElement> productElements = driver.findElements(By.cssSelector(".features_items div.col-sm-4"));
        boolean isProductListed = !productElements.isEmpty();
        assertTrue(isProductListed);

//7. Click on 'View Product' of first product
        WebElement firstProduct = productElements.get(0);
        WebElement viewProductBtn = firstProduct.findElement(By.linkText("View Product"));
        //save product name to verify it matches on the next ('Product Details') page
        String nameFromAllProducts = firstProduct.findElement(By.cssSelector(".productinfo p")).getText();
        viewProductBtn.click();

//8. User is landed to product detail page
        verifyPageTitle("Automation Exercise - Product Details");

//9. Verify that product details is visible: product name, category, price, availability, condition, brand
        verifyProductName(By.cssSelector(".product-information h2"), nameFromAllProducts);
        verifyElementVisible(By.xpath("//p[contains(text(), 'Category:')]"));
        verifyElementVisible(By.xpath("//span[contains(text(), 'Rs.')]"));
        verifyElementVisible(By.xpath("//p[contains(., 'Availability:')]"));
        verifyElementVisible(By.xpath("//p[contains(., 'Condition:')]"));
        verifyElementVisible(By.xpath("//p[contains(., 'Brand:')]"));
    }

    public void verifyProductName(By locator, String fromAllProductsPage) {
        verifyElementVisible(locator);

        //ensures the product name matches the one chosen from the previous ('All Products') page
        String fromProductDetailsPage = driver.findElement(locator).getText();
        assertEquals(fromAllProductsPage, fromProductDetailsPage);
    }
}
