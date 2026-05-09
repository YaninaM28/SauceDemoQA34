package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutInfoTest extends BaseTest {

    @Test
    public void checkPositiveCheckout() {
        // сразу логин
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // добавить продукт
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        // переход на checkout page
        cartPage.clickCheckout();
        // заполнить поля в checkout page
        checkoutPage.enterDataForCheckout("test", "test", "12345");

        assertEquals(checkoutPage.getPageTitle(),
                "Checkout: Overview",
                "NO OVERVIEW!");
    }

    @Test
    public void checkCheckoutWithEmptyFirstName() {
        // сразу логин
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // добавить продукт
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        // переход на checkout page
        cartPage.clickCheckout();
        // заполнить поля в checkout page
        checkoutPage.enterDataForCheckout("", "test", "12345");

        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: First Name is required",
                "Errroooorrr -> empty first name");
    }

    @Test
    public void checkCheckoutWithEmptyLastName() {
        // сразу логин
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // добавить продукт
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        // переход на checkout page
        cartPage.clickCheckout();
        // заполнить поля в checkout page
        checkoutPage.enterDataForCheckout("test", "", "12345");
        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: Last Name is required",
                "Errroooorrr -> empty last name");
    }

    @Test
    public void checkCheckoutWithEmptyPostalCode() {
        // сразу логин
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        // добавить продукт
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        // переход на checkout page
        cartPage.clickCheckout();
        // заполнить поля в checkout page
        checkoutPage.enterDataForCheckout("test", "test", "");
        assertEquals(checkoutPage.getErrorMessageCheckout(),
                "Error: Postal Code is required",
                "Errroooorrr -> empty code");
    }
}
