package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestCase1 {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
//Test Case 1: Register User
    public void registerUserTest() {
        String username = "abck";
        String email = "abck@email.com";

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        String title = driver.getTitle();
        WebElement logoElement = driver.findElement(By.className("logo"));
        boolean isLogoVisible = logoElement.isDisplayed();

        assertEquals("Automation Exercise", title);
        assertTrue(isLogoVisible);

//4. Click on 'Signup / Login' button
        WebElement signupLoginButton = driver.findElement(By.linkText("Signup / Login"));
        signupLoginButton.click();

//5. Verify 'New User Signup!' is visible
        WebElement newUserHeader = driver.findElement(By.cssSelector(".signup-form h2"));
        boolean isNewUserHeaderVisible = newUserHeader.isDisplayed();
        String newUserText = newUserHeader.getText();

        assertTrue(isNewUserHeaderVisible);
        assertEquals("New User Signup!", newUserText);

//6. Enter name and email address
        WebElement usernameInput = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
        WebElement emailInput = driver.findElement(By.cssSelector("[data-qa='signup-email']"));

        usernameInput.clear();
        usernameInput.sendKeys(username);
        emailInput.clear();
        emailInput.sendKeys(email);

//7. Click 'Signup' button
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//9. Fill details: Title, Name, Email, Password, Date of birth
//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//14. Verify that 'ACCOUNT CREATED!' is visible
//15. Click 'Continue' button
//16. Verify that 'Logged in as username' is visible
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
