package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import java.time.Duration;


public class CheckoutTest extends BaseTest {

    @Test
    public void userCanCheckoutAsGuest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Add item to cart
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".product-box-add-to-cart-button"))).click();

        // Go to cart
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.proceedToCheckoutAsGuest();

        // Billing details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_FirstName")))
                .sendKeys("John");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Doe");
        driver.findElement(By.id("BillingNewAddress_Email"))
                .sendKeys("john" + System.currentTimeMillis() + "@test.com");

        Select country = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        country.selectByVisibleText("South Africa");

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Pretoria");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 Demo Street");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("0001");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0831234567");

        // EXACT PLACEMENT
        checkout.continueBilling();
        checkout.continueShipping();
        checkout.continueShippingMethod();
        checkout.continuePaymentMethod();
        checkout.continuePaymentInfo();


        // Confirmation
        String confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".section.order-completed .title strong"))).getText();

        Assert.assertTrue(confirmation.contains("successfully processed"));
    }
}

