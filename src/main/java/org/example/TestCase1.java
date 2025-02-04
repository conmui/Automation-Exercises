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

public class TestCase1 extends BaseTest {
    @Test
//Test Case 1: Register User
    public void registerUserTest() {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        verifyHomepageVisible();

//4. Click on 'Signup / Login' button
        clickBtn(By.linkText("Signup / Login"));

//5. Verify 'New User Signup!' is visible
        verifyTextAndVisibility(By.cssSelector(".signup-form h2"), "New User Signup!");

//6. Enter name and email address
        signUp(testUser.getUsername(), testUser.getEmail());

//7. Click 'Signup' button
        clickBtn(By.cssSelector("[data-qa='signup-button']"));

//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        verifyTextAndVisibility(By.cssSelector(".login-form h2"), "ENTER ACCOUNT INFORMATION");

//9. Fill details: Title, Name, Email, Password, Date of birth
//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'
        enterAccountInformation(testUser.getPassword(), testUser.getDay(), testUser.getMonth(), testUser.getYear());

//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        enterAddressInformation(testUser.getFirstName(), testUser.getLastName(), testUser.getCompany(), testUser.getAddress(), testUser.getAddress2(), testUser.getCountry(), testUser.getState(), testUser.getCity(), testUser.getZipCode(), testUser.getMobileNumber());

//13. Click 'Create Account button'
        clickBtn(By.cssSelector("[data-qa='create-account']"));

//14. Verify that 'ACCOUNT CREATED!' is visible
        verifyTextAndVisibility(By.cssSelector("[data-qa='account-created']"), "ACCOUNT CREATED!");

//15. Click 'Continue' button
        clickBtn(By.cssSelector("[data-qa='continue-button']"));

//16. Verify that 'Logged in as username' is visible
        verifyTextAndVisibility(By.cssSelector(".navbar-nav li:last-child"), "Logged in as " + testUser.getUsername());

//17. Click 'Delete Account' button
        clickBtn(By.linkText("Delete Account"));

//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        verifyTextAndVisibility(By.cssSelector("[data-qa='account-deleted']"), "ACCOUNT DELETED!");
        clickBtn(By.cssSelector("[data-qa='continue-button']"));
    }

    private void enterAccountInformation(String password, String day, String month, String year) {
        selectOption(By.id("uniform-id_gender1"));
//        selectOption(By.id("uniform-id_gender2"));
        fillInput(By.cssSelector("[data-qa='password']"), password);
        selectDropdown(By.cssSelector("[data-qa='days']"), day);
        selectDropdown(By.cssSelector("[data-qa='months']"), month);
        selectDropdown(By.cssSelector("[data-qa='years']"), year);
        selectOption(By.id("newsletter"));
        selectOption(By.id("optin"));
    }

    private void enterAddressInformation(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipCode, String mobileNumber) {
        fillInput(By.cssSelector("[data-qa='first_name']"), firstName);
        fillInput(By.cssSelector("[data-qa='last_name']"), lastName);
        fillInput(By.cssSelector("[data-qa='company']"), company);
        fillInput(By.cssSelector("[data-qa='address']"), address);
        fillInput(By.cssSelector("[data-qa='address2']"), address2);
        selectDropdown(By.cssSelector("[data-qa='country']"), country);
        fillInput(By.cssSelector("[data-qa='state']"), state);
        fillInput(By.cssSelector("[data-qa='city']"), city);
        fillInput(By.cssSelector("[data-qa='zipcode']"), zipCode);
        fillInput(By.cssSelector("[data-qa='mobile_number']"), mobileNumber);
    }
}
