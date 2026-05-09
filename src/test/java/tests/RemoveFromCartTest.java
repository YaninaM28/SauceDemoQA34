package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void checkRemoveProductFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //add product
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        assertTrue(
                cartPage.isProductDisplayedInCart(),
                "Нет продукта в корзине!"
        );
        cartPage.clickRemoveButton();
        assertFalse(
                cartPage.isProductDisplayedInCart(),
                "Продукт не был удален"
        );
    }
}
