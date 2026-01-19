package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComputersPage;
import pages.HomePage;

public class ComputersTest extends BaseTest {

    @Test
    public void userCanAccessComputersSection() {
        // Navigate to Computers page from homepage
        HomePage home = new HomePage(driver);
        home.clickOnComputers();

        // Verify user landed on Computers page
        ComputersPage computers = new ComputersPage(driver);
        Assert.assertTrue(computers.isDesktopsLinkVisible(), "Desktops link is not visible.");
        Assert.assertTrue(computers.isNotebooksLinkVisible(), "Notebooks link is not visible.");
        Assert.assertTrue(computers.isAccessoriesLinkVisible(), "Accessories link is not visible.");

        System.out.println("All Computers category links are visible.");
    }

    @Test
    public void userCanNavigateToDesktops() {
        HomePage home = new HomePage(driver);
        home.clickOnComputers();

        ComputersPage computers = new ComputersPage(driver);
        computers.clickDesktops();

        // Assert we're on the right page (you can check URL or any unique element on Desktops page)
        Assert.assertTrue(driver.getCurrentUrl().contains("desktops"), "Not on Desktops page.");
        System.out.println("Navigated to Desktops page.");
    }

    @Test
    public void userCanNavigateToNotebooks() {
        HomePage home = new HomePage(driver);
        home.clickOnComputers();

        ComputersPage computers = new ComputersPage(driver);
        computers.clickNotebooks();

        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"), "Not on Notebooks page.");
        System.out.println("Navigated to Notebooks page.");
    }

    @Test
    public void userCanNavigateToAccessories() {
        HomePage home = new HomePage(driver);
        home.clickOnComputers();

        ComputersPage computers = new ComputersPage(driver);
        computers.clickAccessories();

        Assert.assertTrue(driver.getCurrentUrl().contains("accessories"), "Not on Accessories page.");
        System.out.println("Navigated to Accessories page.");
    }
}
