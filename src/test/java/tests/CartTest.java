package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void userShouldSeeItemInCart() {
        // Navigate to Computers category and add an item
        driver.findElement(By.linkText("Computers")).click();
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElements(By.cssSelector(".product-box-add-to-cart-button")).get(0).click();

        // Go to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();

        int itemCount = cartPage.getNumberOfItemsInCart();
        Assert.assertTrue(itemCount > 0, "No items found in cart!");
        System.out.println("Cart contains " + itemCount + " item(s).");
    }

    @Test
    public void userShouldBeAbleToRemoveItemFromCart() {
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        int itemCountBefore = cartPage.getNumberOfItemsInCart();

        if (itemCountBefore > 0) {
            cartPage.removeItemFromCart(0);
            boolean empty = cartPage.isCartEmpty();
            Assert.assertTrue(empty, "Cart is not empty after removing item.");
            System.out.println("Cart is empty after removing item.");
        } else {
            System.out.println("No item in cart to remove. Test skipped.");
        }
    }
}

