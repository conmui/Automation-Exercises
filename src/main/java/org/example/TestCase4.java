package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestCase4 extends BaseTest {
//Test Case 4: Logout User
    @Test
    public void logoutTest() {
        String loggedInStatus = "Logged in as " + testUser.getUsername();

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        verifyHomepageVisible();

//4. Click on 'Signup / Login' button
        clickBtn(By.linkText("Signup / Login"));

//5. Verify 'Login to your account' is visible
        verifyHeaderVisible(By.cssSelector(".login-form h2"), "Login to your account");

//6. Enter correct email address and password
        logIn(testUser.getEmail(), testUser.getPassword());

//7. Click 'login' button
        clickBtn(By.cssSelector("[data-qa='login-button']"));

//8. Verify that 'Logged in as username' is visible
        verifyHeaderVisible(By.cssSelector(".navbar-nav li:last-child"), loggedInStatus);

//9. Click 'Logout' button
        clickBtn(By.linkText("Logout"));

//10. Verify that user is navigated to login page
        verifyLoginPageVisible(loggedInStatus);
    }

    private void verifyLoginPageVisible(String loggedInStatus) {
        String title = driver.getTitle();
        assertEquals("Automation Exercise - Signup / Login", title);

        verifyHeaderVisible(By.cssSelector(".login-form h2"), "Login to your account");

        //check "Logged in as <username>" does not show indicating user has logged out
        String lastNavbarItem = driver.findElement(By.cssSelector(".navbar-nav li:last-child")).getText();
        assertNotEquals(loggedInStatus, lastNavbarItem);
    }
}
