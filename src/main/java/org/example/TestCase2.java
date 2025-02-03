package org.example;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestCase2 extends BaseTest {
//Test Case 2: Login User with correct email and password
    @Test
    public void loginPositiveTest() {
        String username = "abck";
        String email = "abck@email.com";
        String password = "itsalwayssunny";

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
        logIn(email, password);

//7. Click 'login' button
        clickBtn(By.cssSelector("[data-qa='login-button']"));

//8. Verify that 'Logged in as username' is visible
        verifyHeaderVisible(By.cssSelector(".navbar-nav li:last-child"), "Logged in as " + username);

//9. Click 'Delete Account' button
        clickBtn(By.linkText("Delete Account"));

//10. Verify that 'ACCOUNT DELETED!' is visible
        verifyHeaderVisible(By.cssSelector("[data-qa='account-deleted']"), "ACCOUNT DELETED!");
    }
}
