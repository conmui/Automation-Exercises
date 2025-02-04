package org.example;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;

public class TestCase6 extends BaseTest {
    @Test
//    Test Case 6: Contact Us Form
    public void contactUsFormTest() {
        String subject = "Lorem Ipsum";
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        String uploadFilePath = "";

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        verifyHomepageVisible();

//4. Click on 'Contact Us' button
        clickBtn(By.linkText("Contact us"));

//5. Verify 'GET IN TOUCH' is visible
        verifyTextAndVisibility(By.cssSelector(".contact-form .title"), "GET IN TOUCH");

//6. Enter name, email, subject and message
        fillInput(By.cssSelector("[data-qa='name']"), testUser.getFirstName() + " " + testUser.getLastName());
        fillInput(By.cssSelector("[data-qa='email']"), testUser.getEmail());
        fillInput(By.cssSelector("[data-qa='subject']"), subject);
        fillInput(By.cssSelector("[data-qa='message']"), message);

//7. Upload file
        WebElement fileInput = driver.findElement(By.name("upload_file"));
//        fileInput.sendKeys(uploadFilePath);

//8. Click 'Submit' button
        clickBtn(By.cssSelector("[data-qa='submit-button']"));

//9. Click OK button
        Alert alert = driver.switchTo().alert();
        alert.accept();

//10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        verifyTextAndVisibility(By.cssSelector(".contact-form .alert-success"), "Success! Your details have been submitted successfully.");

//11. Click 'Home' button and verify that landed to home page successfully
        clickBtn(By.linkText("Home"));
        verifyHomepageVisible();
    }
}
