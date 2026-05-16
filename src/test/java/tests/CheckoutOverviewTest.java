package tests;

import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutOverviewTest extends BaseTest {

    @Test(
            testName = "Проверка overview page",
            description = "Проверка overview с корректными данными для заказа",
            groups = "smoke"
    )
    public void checkOrderCompleteButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.enterDataForCheckout("test", "test", "12345");
        assertTrue(
                checkoutOverviewPage.isFinishButtonDisplayed(),
                "Где кнопка Finish???"
        );
    }

    @Test(
            testName = "Проверка отмены формирования заказа на overview page",
            description = "Проверка отмены на overview page",
            groups = "regression"
    )
    public void checkOrderCancel() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutOverviewPage.clickCancelButton();
        cartPage = new CartPage(driver);
        assertEquals(
                cartPage.getCartTitle(),
                "Your Cart",
                "Ты не в корзине"
        );
    }
}
