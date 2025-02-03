package org.example;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestCase5 extends BaseTest {
//    Test Case 5: Register User with existing email
    @Test
    public void registerWithExistingEmail() {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        verifyHomepageVisible();

//4. Click on 'Signup / Login' button
        clickBtn(By.linkText("Signup / Login"));

//5. Verify 'New User Signup!' is visible
        verifyHeaderVisible(By.cssSelector(".signup-form h2"), "New User Signup!");

//6. Enter name and already registered email address
        signUp(testUser.getUsername(), testUser.getEmail());

//7. Click 'Signup' button
        clickBtn(By.cssSelector("[data-qa='signup-button']"));

//8. Verify error 'Email Address already exist!' is visible
        verifyErrorMessage(By.cssSelector(".signup-form p[style*='color: red;']"), "Email Address already exist!");
    }
}
