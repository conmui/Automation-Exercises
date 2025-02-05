package org.example;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class TestCase10 extends BaseTest {
    @Test
//    Test Case 10: Verify Subscription in home page
    public void verifySubscriptionInHomepageTest() {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        verifyHomepageVisible();

//4. Scroll down to footer
        WebElement footerElem = driver.findElement(By.id("footer"));
        new Actions(driver).scrollToElement(footerElem).perform();

//5. Verify text 'SUBSCRIPTION'
        verifyTextAndVisibility(By.cssSelector("#footer h2"), "SUBSCRIPTION");

//6. Enter email address in input and click arrow button
        WebElement subscriptionEmail = driver.findElement(By.id("susbscribe_email"));
        subscriptionEmail.sendKeys(testUser.getEmail());
        clickBtn(By.id("subscribe"));

//7. Verify success message 'You have been successfully subscribed!' is visible
        verifyTextAndVisibility(By.id("success-subscribe"), "You have been successfully subscribed!");
    }
}
