package tests;

import org.apache.logging.log4j.core.net.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.className("ico-login")).click();
        // Navigate to Login page via HomePage
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        // Fill in valid credentials and log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("malogajan02@gmail.com");  // Replace with your actual registered email
        loginPage.enterPassword("Test123!");
        loginPage.clickLogin();

        // Debug output
        System.out.println("URL after login: " + driver.getCurrentUrl());
        System.out.println("Title after login: " + driver.getTitle());

        // Verify successful login by checking Logout link presence
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout"))
        );// assumes isLogoutVisible() is implemented
        Assert.assertTrue(logoutButton.isDisplayed(), "Login failed: Logout button not found.");
        System.out.println("Login successful.");
    }

    @Test
    public void userShouldSeeErrorMessageForInvalidLogin() {

        driver.findElement(By.className("ico-login")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("invaliduser@example.com");
        loginPage.enterPassword("wrongPassword");
        loginPage.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By errorLocator = By.xpath("//div[contains(@class,'validation-summary-errors') or contains(@class,'message-error')]");
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));

        String error = errorMsg.getText();
        Assert.assertTrue(error.contains("Login was unsuccessful"),
                "Expected error message not shown!");
        System.out.println("Login error message displayed as expected: " + error);
    }
}
