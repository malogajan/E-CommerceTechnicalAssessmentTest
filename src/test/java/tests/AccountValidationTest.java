package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountValidationTest extends BaseTest {

    @Test
    public void verifyUserAccountDetails() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to login
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("malogajan02@gmail.com");
        loginPage.enterPassword("Test123!");
        loginPage.clickLogin();

        // Verify login success (Log out link visible)
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ico-logout")));

        Assert.assertTrue(logoutLink.isDisplayed(), "Login failed – Logout link not visible");
        System.out.println("Login successful");

        // Navigate to My Account (use link text)
        WebElement myAccountLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("My account"))
        );
        myAccountLink.click();

// Verify account email is visible
        WebElement accountEmail = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".account"))
        );
        Assert.assertTrue(accountEmail.isDisplayed(), "Account email not visible");
        System.out.println("Logged in as: " + accountEmail.getText());

        Assert.assertTrue(accountEmail.isDisplayed(), "Account email not visible");
        System.out.println("Logged in as: " + accountEmail.getText());

        // Navigate to Orders
        driver.findElement(By.linkText("Orders")).click();
        System.out.println("Navigated to Orders");

        // Navigate to Addresses
        driver.findElement(By.linkText("Addresses")).click();
        System.out.println("Navigated to Addresses");

        // Navigate to Reward Points
        driver.findElement(By.linkText("Reward points")).click();
        System.out.println("Navigated to Reward Points");
    }
}
