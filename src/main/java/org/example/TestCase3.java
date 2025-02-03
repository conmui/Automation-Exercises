package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase3 extends BaseTest {
//    Test Case 3: Login User with incorrect email and password
    @Test
    public void loginNegativeTest() {
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

//6. Enter incorrect email address and password
//        logIn(testUserIncorrect.getEmail(), testUserIncorrect.getPassword());
//6a. Enter incorrect email address or password
        logIn(testUser.getEmail(), testUserIncorrect.getPassword());

//7. Click 'login' button
        clickBtn(By.cssSelector("[data-qa='login-button']"));

//8. Verify error 'Your email or password is incorrect!' is visible
        WebElement errorElem = driver.findElement(By.cssSelector(".login-form p"));
        boolean isErrorVisible = errorElem.isDisplayed();
        String errorText = errorElem.getText();
        assertTrue(isErrorVisible);
        assertEquals("Your email or password is incorrect!", errorText);
    }
}
