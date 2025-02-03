package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    public void verifyHomepageVisible() {
        String title = driver.getTitle();
        WebElement logoElement = driver.findElement(By.className("logo"));
        boolean isLogoVisible = logoElement.isDisplayed();

        assertEquals("Automation Exercise", title);
        assertTrue(isLogoVisible);
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

    public void logIn(String email, String password) {
        fillInput(By.cssSelector("[data-qa='login-email']"), email);
        fillInput(By.cssSelector("[data-qa='login-password']"), password);
    }

    public void signUp(String username, String email) {
        fillInput(By.cssSelector("[data-qa='signup-name']"), username);
        fillInput(By.cssSelector("[data-qa='signup-email']"), email);
    }
}
