package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void shouldNavigateToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        // Assert URL or Title of Login Page
        String expectedUrlPart = "/login";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlPart), "Failed to navigate to Login page.");
        System.out.println("Navigation to Login page successful.");
    }

    @Test
    public void shouldNavigateToRegisterPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        // Assert Title or URL
        Assert.assertTrue(driver.getTitle().contains("Register"), "Register page title mismatch.");
        System.out.println("Navigation to Register page successful.");
    }

    @Test
    public void homePageShouldHaveCorrectTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop"; // Change this if the site title differs
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Home page title is incorrect.");
        System.out.println("Home page title is correct.");
    }
}
