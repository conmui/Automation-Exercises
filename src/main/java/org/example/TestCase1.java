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
import org.openqa.selenium.support.ui.Select;

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
        String password = "itsalwayssunny";
        String day = "9";
        String month = "2";
        String year = "1976";

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
        clickBtn(By.linkText("Signup / Login"));

//5. Verify 'New User Signup!' is visible
        verifyHeaderVisible(By.cssSelector(".signup-form h2"), "New User Signup!");

//6. Enter name and email address
        fillInput(By.cssSelector("[data-qa='signup-name']"), username);
        fillInput(By.cssSelector("[data-qa='signup-email']"), email);

//7. Click 'Signup' button
        clickBtn(By.cssSelector("[data-qa='signup-button']"));

//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        verifyHeaderVisible(By.cssSelector(".login-form h2"), "ENTER ACCOUNT INFORMATION");

//9. Fill details: Title, Name, Email, Password, Date of birth
        selectOption(By.id("uniform-id_gender1"));
//        selectOption(By.id("uniform-id_gender2"));
        fillInput(By.cssSelector("[data-qa='password']"), password);
        selectDropdown(By.cssSelector("[data-qa='days']"), day);
        selectDropdown(By.cssSelector("[data-qa='months']"), month);
        selectDropdown(By.cssSelector("[data-qa='years']"), year);

//10. Select checkbox 'Sign up for our newsletter!'
        selectOption(By.id("newsletter"));

//11. Select checkbox 'Receive special offers from our partners!'
        selectOption(By.id("optin"));

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

    public void clickBtn(By locator) {
        WebElement button = driver.findElement(locator);
        button.click();
    }

    public void verifyHeaderVisible(By locator, String expectedText) {
        WebElement headerElem = driver.findElement(locator);
        boolean isVisible = headerElem.isDisplayed();
        String headerText = headerElem.getText();

        assertTrue(isVisible);
        assertEquals(expectedText, headerText);
    }

    public void fillInput(By locator, String fieldValue) {
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        inputField.sendKeys(fieldValue);
    }

    public void selectOption(By locator) {
        WebElement option = driver.findElement(locator);
        boolean isChecked = option.isSelected();
        if (!isChecked) { option.click(); }
    }

    public void selectDropdown(By locator, String fieldValue) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(fieldValue);
    }
}
