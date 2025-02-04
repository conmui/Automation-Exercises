package org.example;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestCase7 extends BaseTest {
    @Test
//    Test Case 7: Verify Test Cases Page
    public void testCasesPageTest() {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        verifyHomepageVisible();

//4. Click on 'Test Cases' button
        clickBtn(By.linkText("Test Cases"));

//5. Verify user is navigated to test cases page successfully
        verifyPageTitle("Automation Practice Website for UI Testing - Test Cases");
        verifyTextAndVisibility(By.cssSelector("h2.title"), "TEST CASES");
    }
}
