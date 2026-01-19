package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class NegativeTests extends BaseTest {

    @Test
    public void loginWithInvalidCredentials() {

        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("invalid@example.com", "wrongpassword");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".validation-summary-errors li")));
        String actualError = errorMsg.getText();

        Assert.assertTrue(actualError.contains("Login was unsuccessful"),
                "Error message not displayed as expected");

        System.out.println("Login error displayed correctly: " + actualError);
    }


    @Test
    public void registerWithExistingEmail() {

        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("John");
        driver.findElement(By.id("LastName")).sendKeys("Doe");
        driver.findElement(By.id("Email")).sendKeys("existinguser@example.com");
        driver.findElement(By.id("Password")).sendKeys("Password123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Password123");
        driver.findElement(By.id("register-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'validation-summary-errors')]//li")));
        String error = errorMsg.getText();

        Assert.assertTrue(
                error.toLowerCase().contains("already exists"),
                "Email duplicate error not shown");

        System.out.println("Register with existing email failed as expected: " + error);
    }

    @Test
    public void checkoutWithoutAcceptingTerms() {
        // Add item to cart
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElements(By.cssSelector(".product-box-add-to-cart-button")).get(0).click();

        // Try to checkout without ticking terms
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.id("checkout")).click();

        // Check error notification
        String warning = driver.findElement(By.cssSelector(".terms-of-service-warning")).getText();
        Assert.assertTrue(warning.contains("You must accept"), "No warning about accepting terms");
        System.out.println("Checkout failed without accepting terms - working as expected.");
    }
}

